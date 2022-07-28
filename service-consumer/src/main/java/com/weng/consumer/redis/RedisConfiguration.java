package com.weng.consumer.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类
 */
@SuppressWarnings("unchecked")//忽略 unchecked 警告信息
@Configuration//配置类,相当于配置文件
@Slf4j//日志输出
public class RedisConfiguration {


    @Bean//容器中添加组件，方法名即组件id，返回值就是组件实例
    public RedisTemplate redisTemplate(LettuceConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        // key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value序列化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // hash类型 key序列化
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // hash类型 value序列化
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.setConnectionFactory(redisConnectionFactory);

        log.info("redisTemplate：" + redisTemplate.toString());
        return redisTemplate;
    }
}