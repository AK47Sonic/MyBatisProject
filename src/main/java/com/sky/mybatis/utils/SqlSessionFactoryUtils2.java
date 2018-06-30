package com.sky.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class SqlSessionFactoryUtils2 {

    private static String MB_FILE_PATH = "mybatis.cfg.xml";

    //使用ThreadLocal管理Mybatis中SqlSession对象
    private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    private static Reader reader = null;

    private static SqlSessionFactory sqlSessionFactory;

    //不管这个类被调用多少次，这个方法只会被执行一次
    static{
        try {
            reader = Resources.getResourceAsReader(MB_FILE_PATH);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SqlSessionFactoryUtils2() {}

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if(null == sqlSession) {//没有获取到连接信息
            if(null == sqlSessionFactory) {//没有打开的连接
                System.out.println("创建新的连接操作.................");
                rebuildSqlSessionFactory();
            }
            sqlSession = (null != sqlSessionFactory)?sqlSessionFactory.openSession(): null;
            //保存会话信息
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        //取消保存会话信息
        threadLocal.set(null);
        if(null != sqlSession) {
            System.out.println("执行关闭会话操作。。。");
            sqlSession.close();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static Reader getCfgInfo() {
        return reader;
    }

    public static void rebuildSqlSessionFactory() {
        try {
            reader = Resources.getResourceAsReader(MB_FILE_PATH);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
