package com.zkane.springdata.service.serviceImpl;

import com.zkane.springdata.entity.Department;
import com.zkane.springdata.mapper.DepartmentMapper;
import com.zkane.springdata.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author yuancc
 * @Date 2020-09-22 13:43
 * @Version V1.0
 */
@Service("deptService")
@CacheConfig(cacheNames = {"dept"},cacheManager = "deptCacheManager")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    @Cacheable(key = "#id",unless = "#result==null")//蒋方法返回值保存到缓存中
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
