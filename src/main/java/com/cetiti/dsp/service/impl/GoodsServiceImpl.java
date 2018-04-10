package com.cetiti.dsp.service.impl;

import com.cetiti.core.annotation.LogInject;
import com.cetiti.core.cache.RedisCache;
import com.cetiti.core.support.BaseSupport;
import com.cetiti.dsp.dao.GoodsDao;
import com.cetiti.dsp.entity.Goods;
import com.cetiti.dsp.service.GoodsService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl extends BaseSupport implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private RedisCache cache;
    @LogInject
    private Logger LOG;

    @Override
    public List<Goods> getGoodsList() {
        String cache_key = RedisCache.CACHENAME + "|getGoodsList|";
        List<Goods> result_cache = cache.getListCache(cache_key,Goods.class);
        if(!isNull(result_cache)){
            LOG.info("get cache with key:" + cache_key);
        } else {
            result_cache = goodsDao.queryAll();
            cache.putListCache(cache_key,result_cache);
            LOG.info("put cache with key:" + cache_key);
            return result_cache;
        }
        return  result_cache;
    }
}
