package com.yangzhuo.mapper;

import com.yangzhuo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    /*
    MyBatis参数封装
        单个参数：
            1.PoJo类型:直接使用，属性名和参数占位符名称一致
            2.Map集合：直接使用，键名和参数占位符名称一致
            3.Collection:底层封装成了Map集合
                map.put("arg0",collection集合);
                map.put("collection",collection集合);
            4.List
                map.put("arg0",list集合);
                map.put("collection",list集合);
                map.put("list",list集合)
            5.Array
            6.其他类型：直接使用
        *多个参数 :封装为Map集合,可以使用@Param注解，替换Map集合中的默认的键名
        map.put("arg0",参数值1)
        map.put("param1",参数值1)
        map.put("arg1",参数值2)
        map.put("param2",参数值2)
     */
    User select(@Param("username") String username,String password);
   /*
   注解开发，不需要写xml文件，但只能进行简单的@Select @Insert @Update @Delete
   注解完成简单功能，配置文件完成复杂功能
    */
    @Select("select * from tb_user where id=#{id}")
    User selectById(int id);
}
