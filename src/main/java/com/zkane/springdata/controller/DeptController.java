package com.zkane.springdata.controller;

import com.zkane.springdata.entity.Department;
import com.zkane.springdata.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
    DepartmentService departmentService;

    //slf4j日志对象
    Logger logger= LoggerFactory.getLogger(DeptController.class);

    /**
     * 根据部门编号查询部门信息
     *
     * @param id
     * @return
     */
    @GetMapping("/dept/{id}")
    @Cacheable(cacheNames = "emp",key = "#id",unless = "#result==null")//蒋方法返回值保存到缓存中
    public Department getDepartment(@PathVariable("id") Integer id){

        logger.info("查询"+id+"号员工");
        return departmentService.getDeptById(id);
    }

    /**
     * 新增部门
     * @param department
     * @return
     */
    @GetMapping("/dept")
    public Department insertDep(Department department){
        department.setDepartmentName("客服部");
        departmentService.insertDept(department);
        return department;
    }


}
