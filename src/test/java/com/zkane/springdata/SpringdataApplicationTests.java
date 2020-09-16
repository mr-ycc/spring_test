package com.zkane.springdata;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringdataApplicationTests {

    @Autowired
    DataSource dataSource;

    Logger logger= LoggerFactory.getLogger(SpringdataApplicationTests.class);

    @Test
    void contextLoads() {
    }

    @Test
    public void test01() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        System.out.println("获取到的数据库连接为：" + connection);
        connection.close();

    }

}
