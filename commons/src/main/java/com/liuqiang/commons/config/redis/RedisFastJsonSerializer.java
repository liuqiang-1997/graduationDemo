package com.liuqiang.commons.config.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * 使用fastjson对redis进行序列化防止出现乱码
 * @author LiuQiang
 * @date 4:04 下午
 */

public class RedisFastJsonSerializer<T> implements RedisSerializer<T> {

    public static final Charset DEFAULT_CHARACTER = Charset.forName("UTF-8");

    private Class<T> clazz;

    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    public RedisFastJsonSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if(t ==null){
            return new byte[0];
        }
       return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARACTER);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if(bytes ==null ||bytes.length<=0){
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARACTER);
        return JSON.parseObject(str,clazz);
    }

    protected JavaType getJavaType(Class<T> clazz){
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}
