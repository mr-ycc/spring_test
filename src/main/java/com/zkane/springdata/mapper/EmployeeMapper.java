package com.zkane.springdata.mapper;

import com.zkane.springdata.entity.Employee;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

/**
 * @author yuancc
 * @Date 2020-09-18 10:17
 * @Version V1.0
 */
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
    public int insertEmp(Employee employee,Integer id) throws SQLException;
    
}
