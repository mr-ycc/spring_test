package com.zkane.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching//开启基于注解的缓存
public class SpringdataApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringdataApplication.class, args);
    }

}
