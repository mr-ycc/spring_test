package com.zkane.springdata.service.serviceImpl;

import com.zkane.springdata.entity.Department;
import com.zkane.springdata.mapper.DepartmentMapper;
import com.zkane.springdata.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuancc
 * @Date 2020-09-22 13:43
 * @Version V1.0
 */
@Service("deptService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Department getDeptById(Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @Override
    public int deleteDeptById(Integer id) {
        return departmentMapper.deleteDeptById(id);
    }

    @Override
    public int insertDept(Department department) {
        return departmentMapper.insertDept(department);
    }

    @Override
    public int updateDept(Department department) {
        return departmentMapper.updateDept(department);
    }
}
