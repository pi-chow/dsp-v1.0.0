package com.cetiti.core.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis 缓存
 *
 * @author zhouliyu
 * **/
@Component
public class RedisCache {
    public final static String CACHENAME = "cache"; //缓存名
    public final static int CACHETIME = 60; //默认缓存时间

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public <T> void putCache(String key, T obj){
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bkey, bvalue);
            }
        });
    }

    public <T> void putCacheWithExpireTime(String key, T obj, final long expireTime) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serialize(obj);
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bkey, expireTime, bvalue);
                return true;
            }
        });
    }

    public <T> boolean putListCache(String key, List<T> objList) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bkey, bvalue);
            }
        });
        return result;
    }

    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, final long expireTime) {
        final byte[] bkey = key.getBytes();
        final byte[] bvalue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bkey, expireTime, bvalue);
                return true;
            }
        });
        return result;
    }

    /**
     * Hash键值对
     * */

    public <T> boolean putHashCache(String key, final Map<String, T> map){

        final byte[] bkeys = key.getBytes();
        final Map<byte[],byte[]> bMap = ProtoStuffSerializerUtil.serializeMap(map);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.hMSet(bkeys,bMap);
                return true;
            }
        });

        return result;
    }

    public <T> Map<String, T> getHashCacheAll(final String key, final Class<T> targetClass){
        final byte[] bkeys = key.getBytes();
        Map<byte[],byte[]> result = redisTemplate.execute(new RedisCallback<Map<byte[],byte[]>>() {
            @Override
            public Map<byte[],byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hGetAll(bkeys);
            }
        });
        if (result.isEmpty()) {
            return null;
        }
        return ProtoStuffSerializerUtil.deserializeMap(result,targetClass);
    }

    public <T> List<T> getHMCacheAll4List(final String key, final Class<T> targetClass){
        final byte[] bkeys = key.getBytes();
        Map<byte[],byte[]> result = redisTemplate.execute(new RedisCallback<Map<byte[],byte[]>>() {
            @Override
            public Map<byte[],byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hGetAll(bkeys);
            }
        });
        if (result.isEmpty()) {
            return null;
        }

        return ProtoStuffSerializerUtil.deserializeList(result,targetClass);
    }

    public <T> T getHashCache(final String key,final String mapKey, final Class<T> targetClass){
        final byte[] bkeys = key.getBytes();
        final byte[] bMapkeys = mapKey.getBytes();
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hGet(bkeys,bMapkeys);
            }
        });
        if (result == null) {
            return null;
        }
        return ProtoStuffSerializerUtil.deserialize(result, targetClass);
    }

    public <T> T getCache(final String key, Class<T> targetClass) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key.getBytes());
            }
        });
        if (result == null) {
            return null;
        }
        return ProtoStuffSerializerUtil.deserialize(result, targetClass);
    }

    public <T> List<T> getListCache(final String key, Class<T> targetClass) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key.getBytes());
            }
        });
        if (result == null) {
            return null;
        }
        return ProtoStuffSerializerUtil.deserializeList(result, targetClass);
    }

    /**
     * 精确删除key
     *
     * @param key
     */
    public void deleteCache(String key) {

        redisTemplate.delete(RedisCache.CACHENAME+"|"+key);
    }

    /**
     * 模糊删除key
     *
     * @param pattern
     */
    public void deleteCacheWithPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        redisTemplate.delete(RedisCache.CACHENAME+"|"+keys);
    }

    /**
     * 删除指定hashKey
     *
     * */
        public Long deleteHashCache(String key, String mapKey){
        final byte[] bkeys = key.getBytes();
        final byte[] bMapkeys = mapKey.getBytes();
            Long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hDel(bkeys,bMapkeys);
            }
        });
        if (result == 0) {
            return result;
        }
        return result;
    }
    /**
     * 清空所有缓存
     */
    public void clearCache() {
        deleteCacheWithPattern(RedisCache.CACHENAME+"|*");
    }

}
