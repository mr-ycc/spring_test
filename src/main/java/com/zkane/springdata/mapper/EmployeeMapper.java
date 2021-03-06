package com.zkane.springdata.mapper;

import com.zkane.springdata.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

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
    public int insertEmp(Employee employee) throws SQLException;

    public Integer update(Employee employee) throws SQLException;

    public Integer delete(Integer id) throws SQLException;

    public Employee getEmpByLastName(String lastName) throws SQLException;

}
