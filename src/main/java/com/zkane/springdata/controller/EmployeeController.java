package com.zkane.springdata.controller;

import com.zkane.springdata.entity.Employee;
import com.zkane.springdata.service.EmployeeSercice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author yuancc
 * @Date 2020-09-17 17:37
 * @Version V1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeSercice employeeSercice;

    @Resource(name = "empCacheManager")
    RedisCacheManager redisCacheManager;

    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    /**
     * 根据id查询员工信息
     *
     * @param id
     * @return Employee
     * @throws SQLException
     */
    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable("id") Integer id) throws SQLException {
        logger.info("查询" + id + "号员工");
        return employeeSercice.getEmpById(id);
    }

    /**
     * 根据id删除员工
     *
     * @param id
     * @return Employee 删除的员工
     * @throws SQLException
     */
    @GetMapping("/emp/del/{id}")
    @ResponseBody
    public String deleteEmp(@PathVariable("id") Integer id) throws SQLException {
        logger.info("删除" + id + "号员工");
        Integer row = employeeSercice.delete(id);
        return row > 0 ? "success" : "failed";
    }

    @GetMapping("/emp/add/{lastName}")
    @ResponseBody
    public int insertEmp(@PathVariable("lastName") String lastName) throws SQLException {
        logger.info("添加新员工");
        Employee employee = new Employee();
        employee.setLastName(lastName);
        return employeeSercice.insertEmp(employee);
    }

    @GetMapping("/emp/update/{id}/{email}/{dId}")
    @ResponseBody
    public Employee updateEmp(@PathVariable("email") String email,
                              @PathVariable("dId") Integer dId,
                              @PathVariable("id") Integer id) throws SQLException {
        logger.info("修改" + id + "号员工信息");
        Employee employee = new Employee();
        employee.setEmail(email);
        employee.setD_id(dId);
        employee.setId(id);
        employeeSercice.update(employee);
        return employeeSercice.getEmpById(id);
    }

    @GetMapping("/emp/lastName/{lastName}")
    @ResponseBody
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) throws SQLException {
        logger.info("查询" + lastName + "员工信息");
        Employee emp = employeeSercice.getEmpByLastName(lastName);
        return emp;
    }

    /**
     * 编码方式进行redis缓存
     *     ---使用缓存管理器获取缓存对象，进行api调用
     * @return
     */
    @GetMapping("/emp/cache")
    @ResponseBody
    public Employee getEmp(){
        Employee employee = new Employee("rookies", 1);

        //获取缓存
        Cache cache = redisCacheManager.getCache("emp");
        //向emp缓存对象中添加数据
        cache.put("emp-01",employee);
        return  employee;
    }

}
