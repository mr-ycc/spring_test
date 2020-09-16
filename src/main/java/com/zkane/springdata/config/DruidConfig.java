package com.zkane.springdata.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 29204
 * @Date 2020-09-16 11:25
 */
@Configuration
public class DruidConfig {

    /**
     * 自定义数据源
     * @return
     */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * 配置Druid的监控
     *   1、配置一个管理后台的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        HashMap<Object, Object> initParams = new HashMap<>();
        initParams.put("loginUsername","adimin");//设置登录用户
        initParams.put("loginPassword","111");//设置登录密码
        initParams.put("allow","");//访问权限，默认所有主机
        initParams.put("deny","192.168.137.1");//拒绝访问的主机
        registrationBean.setInitParameters(initParams);

        return registrationBean;
    }

    /**
     * 配置Druid的监控
     *    2、配置一个管理后台的Servlet
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){

        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new WebStatFilter());

        /**
         * 不拦截的静态资源
         */
        HashMap<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,*.jpeg,/druid/*");
        registrationBean.setInitParameters(initParams);

        //拦截所有请求
        registrationBean.setUrlPatterns(Arrays.asList("/*"));

        return registrationBean;

    }


}
