package com.sky.parameterProcess;

import com.sky.mybatis.bean.Employee;
import com.sky.mybatis.dao.GetEmployee;
import com.sky.mybatis.utils.SqlSessionFactoryUtils2;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParaProcess {



    public static void getEmployeeById(){
        SqlSession sqlSession = SqlSessionFactoryUtils2.getSqlSession();
        try {
            GetEmployee getEmployee =  sqlSession.getMapper(GetEmployee.class);
            Employee employee = getEmployee.getEmployeeById(1);
            System.out.println(employee.getId() + " " + employee.getLastName() + " " + employee.getGender()
                    + " " + employee.getEmail() + " " + employee.getDept().getDepartmentName());
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

    public static void getEmployeeByMap(){
        SqlSession sqlSession = SqlSessionFactoryUtils2.getSqlSession();
        try {
            GetEmployee getEmployee =  sqlSession.getMapper(GetEmployee.class);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id",1);
            map.put("name","Xiao");
            Employee employee = getEmployee.getEmployeeByMap(map);
            System.out.println(employee.getId() + " " + employee.getLastName() + " " + employee.getGender()
                    + " " + employee.getEmail() + " " + employee.getDeptName());
        }finally {
            SqlSessionFactoryUtils2.closeSqlSession();
        }
    }

    public static void getEmployeeByIdMap(){
        SqlSession sqlSession = SqlSessionFactoryUtils2.getSqlSession();
        try {
            GetEmployee getEmployee =  sqlSession.getMapper(GetEmployee.class);
            Map<Object, Object> map = getEmployee.getEmployeeByIdMap(1);
            System.out.println(map);
        }finally {
            SqlSessionFactoryUtils2.closeSqlSession();
        }
    }

    public static void getEmployeeByIdReturnMapList(){
        SqlSession sqlSession = SqlSessionFactoryUtils2.getSqlSession();
        try {
            GetEmployee getEmployee =  sqlSession.getMapper(GetEmployee.class);
            Map<Integer,Employee> map = getEmployee.getEmployeeByIdReturnMapList(1);
            System.out.println(map);
        }finally {
            SqlSessionFactoryUtils2.closeSqlSession();
        }
    }

    public static void main(String[] args) throws IOException {
        getEmployeeById();
    }

}
