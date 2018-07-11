package com.sky.mybatis.dao;

import com.sky.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

public interface GetEmployee {

    Employee getEmployeeById(Integer id);

    //如果需要传入多个参数，得用@Param 封装参数，不然得用param1,
    // param2的形式调取参数（e.id = #{param1} and e.last_name = #{param2}）
    Employee getEmployeeByIdAnDName(@Param("id") Integer id, @Param("name") String name);

}
