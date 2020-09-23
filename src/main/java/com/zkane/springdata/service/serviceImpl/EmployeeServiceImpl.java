package com.zkane.springdata.service.serviceImpl;

import com.zkane.springdata.entity.Employee;
import com.zkane.springdata.mapper.EmployeeMapper;
import com.zkane.springdata.service.EmployeeSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author yuancc
 * @Date 2020-09-22 13:35
 * @Version V1.0
 */
@Service("empService")
@CacheConfig(cacheNames = {"emp"},cacheManager = "empCacheManager")
public class EmployeeServiceImpl implements EmployeeSercice {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    //开启缓存，将方法返回结果放到缓存，每次方法执行前，先从缓存中查询
    @Cacheable(key = "#id"/*keyGenerator = "myKeyGenerator"*/,condition = "#id>0", unless = "#result==null")
    public Employee getEmpById(Integer id) throws SQLException {
        return employeeMapper.getEmpById(id);
    }

    @Override
    public int insertEmp(Employee employee) throws SQLException {
        return employeeMapper.insertEmp(employee);
    }

    @Override
    @CachePut(key = "#result.id")
    public Integer update(Employee employee) throws SQLException {
        return employeeMapper.update(employee);
    }

    @Override
    @CacheEvict(key = "#id",beforeInvocation = true)
    public Integer delete(Integer id) throws SQLException {
        return employeeMapper.delete(id);
    }

    @Override
    @Caching(
            cacheable = {
                    @Cacheable(key="#lastName")
            },
            put = {
                    @CachePut(key="#result.id"),
                    @CachePut(key="#result.email")
            }
    )
    public Employee getEmpByLastName(String lastName) throws SQLException {
        return employeeMapper.getEmpByLastName(lastName);
    }
}
