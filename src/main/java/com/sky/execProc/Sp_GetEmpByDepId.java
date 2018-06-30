package com.sky.execProc;

import com.sky.mybatis.bean.Department;
import com.sky.mybatis.bean.Employee;
import com.sky.mybatis.dao.DepartmentMapper;
import com.sky.mybatis.utils.SqlSessionFactoryUtils2;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Sp_GetEmpByDepId {

    public static void main(String[] args) {
        SqlSession session = SqlSessionFactoryUtils2.getSqlSession();

        try {
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
            Department department = departmentMapper.getDepEmpByIdProc(1);
            System.out.println(department.getDepartmentName());

            List<Employee> employeeList = department.getEmps();
            for (Employee em : employeeList) {
                System.out.println(em.getId()+"--"+em.getLastName()+","+em.getGender()+","+em.getEmail());
            }
        }finally {
            SqlSessionFactoryUtils2.closeSqlSession();
        }

    }
}
