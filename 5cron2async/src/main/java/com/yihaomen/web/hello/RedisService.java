package com.yihaomen.web.hello;

import java.util.Collection;  
import java.util.Set;  

public interface RedisService {

    /** 
     * <pre> 
     * 通过key删除 
     * @param keys 
     * @return 被删除的记录数 
     * </pre> 
     */  
    public long delete(String... keys);  
  
    /** 
     * <pre> 
     * 通过keys删除 
     * @param keys 
     * @return 被删除的记录数 
     * </pre> 
     */  
    public long delete(Collection<String> keys);  
  
    /** 
     * <pre> 
     *  @param key 
     *  @param value 
     *  @param activeTime 秒 
     *  @return 添加key value 并且设置存活时间 
     * </pre> 
     */  
    public boolean set(byte[] key, byte[] value, long activeTime);  
  
    /** 
     * <pre> 
     * @param key 
     * @param value 
     * @param activeTime 秒 
     * @return 添加key value 并且设置存活时间 
     * </pre> 
     */  
    public boolean set(String key, String value, long activeTime);  
  
    /** 
     * <pre> 
     *  @param key 
     *  @param value 
     *  @return 添加key value 
     * </pre> 
     */  
    public boolean set(String key, String value);  
  
    /** 
     * <pre> 
     *  @param key 
     *  @param value 
     *  @return 添加key value 
     * </pre> 
     */  
    public boolean set(byte[] key, byte[] value);  
  
    /** 
     * <pre> 
     * @param key 
     * @return 获得value 
     * </pre> 
     */  
    public String get(String key);  
  
    /** 
     * <pre> 
     * @param pattern 
     * @return 通过正则匹配keys 
     * </pre> 
     */  
    public Set<String> matchKeys(String pattern);  
  
    /** 
     * <pre> 
     * @param key 
     * @return 检查key是否已经存在 
     * </pre> 
     */  
    public boolean exists(String key);  
  
    /** 
     * <pre> 
     * @return 清空所有数据 
     * </pre> 
     */  
    public boolean flushDB();  
  
}  