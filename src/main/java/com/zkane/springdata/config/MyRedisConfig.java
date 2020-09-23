package com.zkane.springdata.config;

import com.zkane.springdata.entity.Department;
import com.zkane.springdata.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.net.UnknownHostException;
import java.util.Objects;

/**
 * @author yuancc
 * @Date 2020-09-23 10:05
 * @Version V1.0
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Employee> se = new Jackson2JsonRedisSerializer<>(Employee.class);
        template.setDefaultSerializer(se);
        return template;
    }

    @Bean("empCacheManager")
    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, Employee> redisTemplate){
        //第一步：创建RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(Objects.requireNonNull(redisTemplate.getConnectionFactory()));

        //创建Jackson对象并传入需要序列化的对象
        Jackson2JsonRedisSerializer<Employee> serializer = new Jackson2JsonRedisSerializer<>(Employee.class);

        RedisSerializationContext<Employee, Employee> serializationContext = RedisSerializationContext.fromSerializer(serializer);
        RedisCacheConfiguration redisCacheConfiguration =  RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(serializationContext.getValueSerializationPair());

        return new RedisCacheManager(redisCacheWriter,redisCacheConfiguration);
        
    }

    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Department> se = new Jackson2JsonRedisSerializer<>(Department.class);
        template.setDefaultSerializer(se);
        return template;
    }
    @Bean("deptCacheManager")
    public RedisCacheManager DeptCacheManager(RedisTemplate<Object, Department> redisTemplate){
        //第一步：创建RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(Objects.requireNonNull(redisTemplate.getConnectionFactory()));

        //创建Jackson对象并传入需要序列化的对象
        Jackson2JsonRedisSerializer<Department> serializer = new Jackson2JsonRedisSerializer<>(Department.class);

        RedisSerializationContext<Department, Department> serializationContext = RedisSerializationContext.fromSerializer(serializer);
        RedisCacheConfiguration redisCacheConfiguration =  RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(serializationContext.getValueSerializationPair());

        return new RedisCacheManager(redisCacheWriter,redisCacheConfiguration);

    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Object> se = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setDefaultSerializer(se);
        return template;
    }
    @Primary//默认缓存管理器
    @Bean
    public RedisCacheManager cacheManager(RedisTemplate<Object, Object> redisTemplate){
        //第一步：创建RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(Objects.requireNonNull(redisTemplate.getConnectionFactory()));

        //创建Jackson对象并传入需要序列化的对象
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);

        RedisSerializationContext<Object, Object> serializationContext = RedisSerializationContext.fromSerializer(serializer);
        RedisCacheConfiguration redisCacheConfiguration =  RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(serializationContext.getValueSerializationPair());

        return new RedisCacheManager(redisCacheWriter,redisCacheConfiguration);

    }

}
