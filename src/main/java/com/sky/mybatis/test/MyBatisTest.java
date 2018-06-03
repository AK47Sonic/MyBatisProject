package com.sky.mybatis.test;

import com.sky.mybatis.bean.Department;
import com.sky.mybatis.bean.Employee;
import com.sky.mybatis.dao.DepartmentMapper;
import com.sky.mybatis.dao.EmployeeMapper;
import com.sky.mybatis.dao.EmployeeMapperAnnotation;
import com.sky.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
//        test00();
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
        test06();
    }


    private static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static void test00() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Employee e = sqlSession.selectOne("com.sky.mybatis.EmployeeMapper.getEmpById", 2);
            System.out.println(e);
        } finally {
            sqlSession.close();
        }
    }

    public static void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println(mapper.getClass());
            Employee e = mapper.getEmpById(1);
            System.out.println(e);
        } finally {
            sqlSession.close();
        }
    }

    public static void test02() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
            System.out.println(mapper.getClass());
            Employee e = mapper.getEmpById(1);
            System.out.println(e);
        } finally {
            sqlSession.close();
        }
    }

    public static void test03() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "marry123", "1", "marry@sky.com");
            Long num = mapper.addEmp(employee);
            System.out.println(employee.getId());
            System.out.println("num:" + num);

//            Employee employee = new Employee(1, "jerry1", "1", "jerry1@sky.com");
//            mapper.updateEmp(employee);

//            mapper.deleteEmpById(2);

            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static void test04() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee employee = new Employee(null, "marry12", "1", "marry@sky.com");
//            Employee e = mapper.getEmpByIdAndLastName(4, "marry");

//            Map<String, Object> map = new HashMap<>();
//            map.put("id", "4");
//            map.put("lastName", "marry");
//            map.put("tableName", "tbl_employee");
//            Employee e = mapper.getEmpByMap(map);

//            List<Employee> e = mapper.getEmpsByLastNameLike("%e%");
//            for (Employee el: e){
//                System.out.println(el);
//            }

//            Map<String, Object> map = mapper.getEmpByIdReturnMap(1);
//            System.out.println(map);

            Map<String, Employee> map = mapper.getEmpByLastNameLikeReturnMap("%e%");
            System.out.println(map);

//            System.out.println(e);
//            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public static void test05() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
//            Employee e = mapper.getEmpById(1);
//            System.out.println(e);

//            Employee e = mapper.getEmpAndDept(3);
//            System.out.println(e);
//            System.out.println(e.getDept());


            Employee e = mapper.getEmpByIdStep(3);
//            System.out.println(e);
            System.out.println(e.getDept());
//            System.out.println(e.getLastName());


        } finally {
            sqlSession.close();
        }
    }

    public static void test06() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
//            Department d = mapper.getDepEmpById(1);
//            System.out.println(d);
//            System.out.println(d.getEmps());

            Department d = mapper.getDeptEmpByIdStep(1);
            System.out.println(d);
            System.out.println(d.getEmps());

        } finally {
            sqlSession.close();
        }
    }

}
