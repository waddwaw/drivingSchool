package com.yoflying.drivingschool.domain.dao;

import com.yoflying.drivingschool.domain.model.ManageUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * 管理员对应Mapper
 * Created by liqiang on 16/12/13.
 */
@MapperScan
public interface ManageUserMapper {


    @Select("SELECT * FROM management WHERE username = #{user} and password = #{pwd} and status = 1")
    ManageUser findOneByManageAndStatusAvailable(@Param("user") String user, @Param("pwd") String pwd);
}
