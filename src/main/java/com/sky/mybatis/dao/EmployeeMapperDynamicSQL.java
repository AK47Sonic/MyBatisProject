package com.sky.mybatis.dao;

import com.sky.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmpsByConditionIf(Employee employee);

}
