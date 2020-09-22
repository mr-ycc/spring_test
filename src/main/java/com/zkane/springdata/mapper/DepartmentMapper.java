package com.zkane.springdata.mapper;

import com.zkane.springdata.entity.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author yuancc
 * @Date 2020-09-18 9:40
 * @Version V1.0
 */
@Mapper
@Component
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where i#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

}
