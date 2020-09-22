package com.zkane.springdata.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @author yuancc
 * @Date 2020-09-22 16:10
 * @Version V1.0
 */
@Configuration
public class MyCacheConfig {

    /**
     * 自定义缓存的key生成方法
     * @return
     */
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator(){

        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+ Arrays.asList(objects).toString()+"]";
            }
        };
    }
}
