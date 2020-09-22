package com.zkane.springdata.mapper;

import com.zkane.springdata.entity.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import javax.websocket.server.PathParam;
import java.sql.SQLException;

/**
 * @author yuancc
 * @Date 2020-09-18 10:17
 * @Version V1.0
 */
@Mapper
@Component
public interface EmployeeMapper {

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Select("select * from employee where id=#{id}")
    public Employee getEmpById(Integer id) throws SQLException;

    /**
     *
     * @param employee
     * @param id
     * @return int
     * @throws SQLException
     */
    @Insert("INSERT into employee(lastName,gender) VALUES(#{lastName},#{gender})")
    public int insertEmp(@PathParam("employee") Employee employee) throws SQLException;

    @Update("UPDATE employee set email=#{email},d_id=#{d_id} WHERE id=#{id}")
    public Integer update(@PathParam("emp") Employee employee) throws SQLException;

    @Delete("DELETE FROM employee WHERE id=#{id}")
    public Integer delete(Integer id) throws SQLException;

    @Select("select * from employee where lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName) throws SQLException;
    
}
