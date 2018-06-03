package com.sky.mybatis.dao;

import com.sky.mybatis.bean.Department;

public interface DepartmentMapper {
    public Department getDeptById(Integer id);

    public Department getDepEmpById(Integer id);

    public Department getDeptEmpByIdStep(Integer id);

}
