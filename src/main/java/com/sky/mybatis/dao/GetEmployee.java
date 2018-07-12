package com.sky.mybatis.dao;

import com.sky.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface GetEmployee {


    Employee getEmployeeById(Integer id);

    /*
        1.如果需要传入多个参数，得用@Param 封装参数，不然得用param1,
          param2的形式调取参数（e.id = #{param1} and e.last_name = #{param2}）
        2.传入POJO对象
        3.传入MAP
        4.TO (Transfer Object)
            {
            int Index;
            int Size;
            }

        特别注意：当传入的参数是Collection(collection) 或 List(list)时
            取参数的第一个值时 ： #{collection[0]}/#{list[0]}
     */
    //
    //
    Employee getEmployeeByIdAnDName(@Param("id") Integer id, @Param("name") String name);

    Employee getEmployeeByMap(Map<String, Object> map);

}
