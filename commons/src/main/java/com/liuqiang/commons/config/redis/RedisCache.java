package com.liuqiang.commons.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 封装redis方法工具类
 * @author LiuQiang
 * @date 4:44 下午
 */
@Component
public class RedisCache {

    @Autowired
    @Qualifier(value = "myRedisTemplate")
    private RedisTemplate<Object, Object> redisTemplate;



    /**
     * 设置缓存的基本对象
     * @param key 键
     * @param value 值
     */
    public boolean setCacheObject(final String key, final Object value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置缓存的基本对象
     * @param key 键
     * @param value 值
     * @param timeout 缓存时间
     * @param timeUnit 时间颗粒度
     */
    public boolean setCacheObject(final String key, final Object value, final Integer timeout, final TimeUnit timeUnit){
        try {
            if (timeout > 0) {
            redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
            return true;
        } else {
            setCacheObject(key, value);
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 设置有效时间默认时间单位
     * @param key 键
     * @param timeout 时间
     * @return true成功
     */
    public boolean expire(final String key,final long timeout){
        return expire(key,timeout,TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间自定义时间单位
     * @param key 键
     * @param timeout 时间
     * @param timeUnit 单位
     * @return true 成功
     */
    public boolean expire(final String key,final long timeout,final TimeUnit timeUnit){
        try {
            if (timeout > 0){
                redisTemplate.expire(key,timeout, timeUnit);
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取缓存数据
     * @param key 键
     * @return 数据
     */
   public Object getCacheObject(final String key){
       return key == null ? null : redisTemplate.opsForValue().get(key);
   }


    /**
     * 根据key获取过期时间
     * @param key 键  不能为null
     * @return 时间（秒） 返回0代表为永久有效；500 错误
     */
    public long getExpire(String key, TimeUnit timeUnit){
        try {
            return redisTemplate.getExpire(key, timeUnit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 500;
    }




    /**
     * 判断key是否存在
     * @param key  键
     * @return  true的话存在，false不存在
     */
    public boolean getInCacheObject(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



    /**
     * 删除缓存
     * @param key  可以传一个key或多个key
     */
    @SuppressWarnings("unchecked")
    public void deleteCacheObject(String... key){
        if (key!=null && key.length>0){
            if (key.length==1){
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 缓存List数据
     * @param key 键
     * @param data 数据
     * @return true成功
     */
    public boolean setCacheList(final String key,final List<Object> data){
        try {
            if(data != null){
                redisTemplate.opsForList().rightPushAll(key, data);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 缓存list数据
     * @param key 键
     * @param time 时间
     * @param timeUnit 时间单位
     * @param value 值
     * @return 成功个数
     */
    public boolean setCacheList(String key, List<Object> value, long time, TimeUnit timeUnit) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0){
                expire(key, time, timeUnit);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取list数据
     * @param key 键
     * @return list数据
     */
    public List<Object> getCacheList(final String key){
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 通过索引 获取list中的值
     * @param key   键
     * @param index 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     */
    public Object getCacheListIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list缓存长度
     * @param key 键
     * @return 长度
     */
    public long getCacheListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 缓存set数据
     * @param key 键
     * @param values 值，可以多个
     * @return 成功个数
     */
    public long setCacheSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 缓存set数据
     * @param key 键
     * @param time 时间
     * @param timeUnit 时间单位
     * @param values 值
     * @return 成功个数
     */
    public long setCacheSet(String key, long time, TimeUnit timeUnit, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                expire(key, time, timeUnit);
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 根据key获取Set中的所有值
     * @param key 键
     */
    public Set<Object> getCacheSet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 根据value从一个set中查询,是否存在
     *
     * @param key   键
     * @param value 值
     * @return true 存在 false不存在
     */
    public boolean getInCacheSet(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取缓存列表
     * @param key 前缀
     * @return 列表对象
     */
    public Collection<Object> keys(String key){
        return redisTemplate.keys(key);
    }
}
