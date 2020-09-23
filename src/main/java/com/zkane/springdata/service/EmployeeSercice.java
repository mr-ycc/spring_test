package com.zkane.springdata.service;

import com.zkane.springdata.entity.Employee;

import java.sql.SQLException;

/**
 * @author yuancc
 * @Date 2020-09-22 10:54
 * @Version V1.0
 */
public interface EmployeeSercice {

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
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
