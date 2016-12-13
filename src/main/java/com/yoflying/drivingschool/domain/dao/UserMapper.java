package com.yoflying.drivingschool.domain.dao;

import com.yoflying.drivingschool.domain.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


/**
 * 用户Dao 接口
 *
 * @author liliqiang
 * @since 2016年11月12日 上午11:59:03
 **/
@MapperScan
public interface UserMapper {

    /**
     * 用户登录验证查询
     * 
     * @param user
     * @param pwd
     * @return
     */
    @Select("SELECT * FROM user WHERE username = #{user} and password = #{pwd}")
    User authentication(@Param("user") String user, @Param("pwd") String pwd);

    @Select("SELECT * FROM user WHERE username = #{user}")
    User byUserName(@Param("user") String user);

    @Select("SELECT * FROM user WHERE username = #{user}")
    List<User> byListUserName(@Param("user") String user);

}