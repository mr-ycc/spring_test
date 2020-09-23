package com.zkane.springdata;

import com.zkane.springdata.entity.Employee;
import com.zkane.springdata.service.EmployeeSercice;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.sql.SQLException;

/**
 * Redis缓存测试
 *
 * @author yuancc
 * @Date 2020-09-23 9:41
 * @Version V1.0
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    EmployeeSercice employeeSercice;

    /**
     * redis缓存操作实例对象
     *      RedisTemplate<Object, Object>：一切对象
     *      StringRedisTemplate：字符串
     */
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /*//自定义序列化规则的实例对象
    @Autowired
    RedisTemplate<Object, Employee> employeeRedisTemplate;*/

    Logger logger= LoggerFactory.getLogger(RedisTest.class);

    @Test
    void contextLoads() {
    }

    @Test
    public void test01(){
        //opsForValue()操作String字符串
        /*ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.append("msg","hello");
        valueOperations.append("msg","world");
        logger.info(valueOperations.get("msg"));*/

        //opsForList()操作集合
        ListOperations<String, String> listOperations = stringRedisTemplate.opsForList();
        listOperations.leftPush("mylist","cat");
        listOperations.leftPush("mylist","dog");
        listOperations.leftPush("mylist","fish");
    }

    /**
     * 测试redis操作对象（对象须序列化）
     */
    @Test
    public void test02() throws SQLException {

        Employee emp = employeeSercice.getEmpById(1);
       redisTemplate.opsForValue().set("emp-02",emp);
    }
}
