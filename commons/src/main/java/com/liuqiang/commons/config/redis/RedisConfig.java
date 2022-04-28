package com.liuqiang.commons.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类
 * @author LiuQiang
 * @date 3:58 下午
 */
@Configuration
public class RedisConfig {


    @Bean(name="myRedisTemplate")
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        RedisFastJsonSerializer<Object> fastJsonSerializer = new RedisFastJsonSerializer<>(Object.class);

        // 使用StringRedisSerializer序列化和反序列化key
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(fastJsonSerializer);

        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(fastJsonSerializer);

        template.afterPropertiesSet();
        return template;

    }
}
