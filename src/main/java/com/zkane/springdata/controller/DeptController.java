package com.zkane.springdata.controller;

import com.zkane.springdata.entity.Department;
import com.zkane.springdata.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuancc
 * @Date 2020-09-18 9:47
 * @Version V1.0
 */
@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    /**
     * 根据部门编号查询部门信息
     *
     * @param id
     * @return
     */
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){

        return departmentMapper.getDeptById(id);
    }

    /**
     * 新增部门
     * @param department
     * @return
     */
    @GetMapping("/dept")
    public Department insertDep(Department department){
        department.setDepartmentName("客服部");
        departmentMapper.insertDept(department);
        return department;
    }


}
