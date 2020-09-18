package com.zkane.springdata.controller;

import com.zkane.springdata.entity.Employee;
import com.zkane.springdata.mapper.EmployeeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author yuancc
 * @Date 2020-09-17 17:37
 * @Version V1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeMapper employeeMapper;
    private static Logger logger= LoggerFactory.getLogger(EmployeeController.class);

    @RequestMapping("/emp")
    @ResponseBody
    public Map<String,Object> getEmp(ModelMap modelMap){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setLastName("jacklove");
        employee.setEmail("jacklove@tes.com");
        employee.setGender(1);
        employee.setD_id(1);

        modelMap.addAttribute("employee",employee);
        return modelMap;
    }

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable("id") Integer id) throws SQLException {
        return employeeMapper.getEmpById(id);
    }
}
