package com.sky.mybatis.dao;

import com.sky.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {

    @Select(value = " SELECT id, last_name AS lastName,gender,email  FROM tbl_employee WHERE id = #{id}")
    public Employee getEmpById(Integer id);

}
