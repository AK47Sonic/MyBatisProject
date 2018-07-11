package com.sky.parameterProcess;

import com.sky.mybatis.bean.Employee;
import com.sky.mybatis.dao.GetEmployee;
import com.sky.mybatis.utils.SqlSessionFactoryUtils2;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class ParaProcess {

    public static void main(String[] args) throws IOException {
        getEmpbyIDAndName();
    }

    public static void getEmpbyID(){
        SqlSession sqlSession = SqlSessionFactoryUtils2.getSqlSession();
        try {
            GetEmployee getEmployee =  sqlSession.getMapper(GetEmployee.class);
            Employee employee = getEmployee.getEmployeeById(1);
            System.out.println(employee.getId() + " " + employee.getLastName() + " " + employee.getGender()
                    + " " + employee.getEmail() + " " + employee.getDeptName());
        }finally {
            SqlSessionFactoryUtils2.closeSqlSession();
        }
    }


    public static void getEmpbyIDAndName(){
        SqlSession sqlSession = SqlSessionFactoryUtils2.getSqlSession();
        try {
            GetEmployee getEmployee =  sqlSession.getMapper(GetEmployee.class);
            Employee employee = getEmployee.getEmployeeByIdAnDName(1, "Xiao");
            System.out.println(employee.getId() + " " + employee.getLastName() + " " + employee.getGender()
                    + " " + employee.getEmail() + " " + employee.getDeptName());
        }finally {
            SqlSessionFactoryUtils2.closeSqlSession();
        }
    }

}
