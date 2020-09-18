package com.zkane.springdata.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuancc
 * @Date 2020-09-18 10:09
 * @Version V1.0
 */
@MapperScan(value = "com.zkane.springdata.mapper")//该路径下的所有类均为mapper接口
@Configuration
public class MybatisConfig {

    /***
     *     
     * @Param: []
     * @Return: org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer
     * @Author: yuancc
     * @Date: 2020/9/18 10:12
     **/
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //开启驼峰命名
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
