package com.yoflying.drivingschool.domain.dao;

import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by arvin on 2016/12/14.
 */
@MapperScan
public interface CoachStudentUserMapper {

    @Select("SELECT * FROM coach_students WHERE username = #{user} and password = #{pwd} and status = 1")
    CoachStudentUser findOneByManageAndStatusAvailable(@Param("user") String user, @Param("pwd") String pwd);
}
