package com.yoflying.drivingschool.domain.dao;

import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by arvin on 2016/12/14.
 */
@MapperScan
public interface CoachStudentUserMapper {

    @Select("SELECT * FROM coach_students WHERE username = #{user} and password = #{pwd} and status = 1")
    CoachStudentUser findOneByCoachStAndStatusAvailable(@Param("user") String user, @Param("pwd") String pwd);

    @Select("SELECT * FROM coach_students WHERE dsId = #{dsId} and discern = 2 and status = 1 ORDER BY createTime DESC")
    List<CoachStudentUser> findStByDsIdList(@Param("dsId") Long dsId);

    @Select("SELECT * FROM coach_students WHERE dsId = #{dsId} and discern = 1 and status = 1 ORDER BY createTime DESC")
    List<CoachStudentUser> findCoachByDsIdList(@Param("dsId") Long dsId);

    @Insert("INSERT INTO coach_students (username, password,dsId,name,sex,identityCard,discern,phone,wechat,address" +
            "course,coachId,status,modifyTime)" +
            " VALUES(#{username},#{password},#{dsId},#{name},#{sex},#{identityCard},#{discern},#{phone},#{wechat},#{address}" +
            ",#{course},#{coachId},#{status},NOW())")
    int insertCoachStudentUser(CoachStudentUser coachStudentUser);

    @Update("UPDATE INTO coach_students SET coachId = #{coachId}"+
            ",modifyTime = NOW() " +
            "WHERE dsId = #{dsId} and id = #{studentsId}")
    int updateStudentBindCoach(@Param("dsId") Long dsId, @Param("studentsId") Long studentsId, @Param("coachId") Long coachId);

    @Update("UPDATE INTO coach_students SET status = #{status}"+
            ",modifyTime = NOW() " +
            "WHERE dsId = #{dsId} and id = #{coachIdStId}")
    int updateCoachStudentUserStatus(@Param("dsId") Long dsId, @Param("coachIdStId") Long coachIdStId, @Param("status") Integer status);
}
