package com.zkane.springdata.service;

import com.zkane.springdata.entity.Department;

/**
 * @author yuancc
 * @Date 2020-09-22 13:20
 * @Version V1.0
 */
public interface DepartmentService {

    public Department getDeptById(Integer id);

    public int deleteDeptById(Integer id);

    public int insertDept(Department department);

    public int updateDept(Department department);
}
