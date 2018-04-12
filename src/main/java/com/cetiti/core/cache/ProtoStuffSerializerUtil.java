package com.cetiti.core.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * 序列化工具
 * @author zhouliyu
 */
public class ProtoStuffSerializerUtil {

	/**
	 * 序列化对象
	 * @param obj
	 * @return
	 */
	public static <T> byte[] serialize(T obj) {
		if (obj == null) {
			throw new RuntimeException("序列化对象(" + obj + ")!");
		}
		@SuppressWarnings("unchecked")
		Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(obj.getClass());
		LinkedBuffer buffer = LinkedBuffer.allocate(1024 * 1024);
		byte[] protostuff = null;
		try {
			protostuff = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
		} catch (Exception e) {
			throw new RuntimeException("序列化(" + obj.getClass() + ")对象(" + obj + ")发生异常!", e);
		} finally {
			buffer.clear();
		}
		return protostuff;
	}

	/**
	 * 反序列化对象
	 * @param paramArrayOfByte
	 * @param targetClass
	 * @return
	 */
	public static <T> T deserialize(byte[] paramArrayOfByte, Class<T> targetClass) {
		if (paramArrayOfByte == null || paramArrayOfByte.length == 0) {
			throw new RuntimeException("反序列化对象发生异常,byte序列为空!");
		}
		T instance = null;
		try {
			instance = targetClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("反序列化过程中依据类型创建对象失败!", e);
		}
		Schema<T> schema = RuntimeSchema.getSchema(targetClass);
		ProtostuffIOUtil.mergeFrom(paramArrayOfByte, instance, schema);
		return instance;
	}

	/**
	 * 序列化列表
	 * @param objList
	 * @return
	 */
	public static <T> byte[] serializeList(List<T> objList) {
		if (objList == null || objList.isEmpty()) {
			throw new RuntimeException("序列化对象列表(" + objList + ")参数异常!");
		}
		@SuppressWarnings("unchecked")
		Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(objList.get(0).getClass());
		LinkedBuffer buffer = LinkedBuffer.allocate(1024 * 1024);
		byte[] protostuff = null;
		ByteArrayOutputStream bos = null;
		try {
			bos = new ByteArrayOutputStream();
			ProtostuffIOUtil.writeListTo(bos, objList, schema, buffer);
			protostuff = bos.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException("序列化对象列表(" + objList + ")发生异常!", e);
		} finally {
			buffer.clear();
			try {
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return protostuff;
	}

	/**
	 * 反序列化列表
	 * @param paramArrayOfByte
	 * @param targetClass
	 * @return
	 */
	public static <T> List<T> deserializeList(byte[] paramArrayOfByte, Class<T> targetClass) {
		if (paramArrayOfByte == null || paramArrayOfByte.length == 0) {
			throw new RuntimeException("反序列化对象发生异常,byte序列为空!");
		}

		Schema<T> schema = RuntimeSchema.getSchema(targetClass);
		List<T> result = null;
		try {
			result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(paramArrayOfByte), schema);
		} catch (IOException e) {
			throw new RuntimeException("反序列化对象列表发生异常!", e);
		}
		return result;
	}

	/**
	 * Map序列化列表
     * @param map
     * @return
	 * */

	public static <T> Map<byte[],byte[]> serializeMap(Map<String,T> map){
		if (map.isEmpty()) {
			throw new RuntimeException("序列化对象(" + map + ")!");
		}
		Map<byte[],byte[]> bMap = new HashMap<>();
		for(String key : map.keySet()){
			byte[] bKeys = key.getBytes();
			byte[] bValues = serialize(map.get(key));
			bMap.put(bKeys,bValues);
		}
		return bMap;
	}

	/**
	 * Map反序列化列表
     * @param bMap
     * @param targetClass
     * @return
	 * */

	public static<T> Map<String,T> deserializeMap(Map<byte[],byte[]> bMap,Class<T> targetClass){
		if (bMap.isEmpty()) {
			throw new RuntimeException("序列化对象(" + bMap + ")!");
		}
		Map<String,T> map = new HashMap<>();
		for(byte[] bKeys : bMap.keySet()){
			String key = new String(bKeys);
			T obj = deserialize(bMap.get(bKeys),targetClass);
			map.put(key,obj);
		}
		return map;
	}
	/**
	 * 序列化的Map转List
	 * */
	public static<T> List<T> deserializeList(Map<byte[],byte[]> bMap,Class<T> targetClass){
		if (bMap.isEmpty()) {
			throw new RuntimeException("序列化对象(" + bMap + ")!");
		}
		List<T> list = new ArrayList<>();
        bMap = new LinkedHashMap<>();
		for(byte[] bKeys : bMap.keySet()){
			T obj = deserialize(bMap.get(bKeys),targetClass);
			list.add(obj);
		}
		return list;
	}
}