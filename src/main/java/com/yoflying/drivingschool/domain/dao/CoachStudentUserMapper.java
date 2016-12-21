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

    @Select("SELECT * FROM coach_students WHERE identityCard = #{identityCard} and password = #{pwd} and status = 1")
    CoachStudentUser findOneByCoachStAndStatusAvailable(@Param("identityCard") String identityCard, @Param("pwd") String pwd);

    @Select("SELECT * FROM coach_students WHERE id = #{id} and status = 1")
    CoachStudentUser findOneByCoachStID(@Param("id") long id);

    @Select("SELECT * FROM coach_students WHERE dsId = #{dsId} and discern = 2 and status = 1 ORDER BY createTime DESC")
    List<CoachStudentUser> findStByDsIdList(@Param("dsId") Long dsId);

    @Select("SELECT * FROM coach_students WHERE dsId = #{dsId} and discern = 1 and status = 1 ORDER BY createTime DESC")
    List<CoachStudentUser> findCoachByDsIdList(@Param("dsId") Long dsId);

    @Select("SELECT * FROM coach_students WHERE dsId = #{dsId} and discern = 1 and status = 1 " +
            "and name LIKE concat('%',#{name},'%') ORDER BY createTime DESC")
    List<CoachStudentUser> findCoachByDsIdAndNameList(@Param("dsId") Long dsId, @Param("name") String name);

    @Select("SELECT * FROM coach_students WHERE dsId = #{dsId} and discern = 2 and status = 1 " +
            "and name LIKE concat('%',#{name},'%') ORDER BY createTime DESC")
    List<CoachStudentUser> findStByDsIdAndNameList(@Param("dsId") Long dsId, @Param("name") String name);

    @Insert("INSERT INTO coach_students (username, password,dsId,name,sex,identityCard,discern,phone,wechat,address" +
            "course,coachId,status,modifyTime)" +
            " VALUES(#{username},#{password},#{dsId},#{name},#{sex},#{identityCard},#{discern},#{phone},#{wechat},#{address}" +
            ",#{course},#{coachId},#{status},NOW())")
    int insertCoachStudentUser(CoachStudentUser coachStudentUser);

    @Update("UPDATE coach_students SET coachId = #{coachId},course = #{course}"+
            ",modifyTime = NOW() " +
            "WHERE dsId = #{dsId} and id = #{studentsId}")
    int updateStudentBindCoach(@Param("dsId") Long dsId, @Param("studentsId") Long studentsId,
                               @Param("coachId") Long coachId, @Param("course") int course);

    @Update("UPDATE coach_students SET status = #{status},course = #{course}"+
            ",modifyTime = NOW() " +
            "WHERE dsId = #{dsId} and id = #{coachIdStId}")
    int updateCoachStudentUserStatus(@Param("dsId") Long dsId, @Param("coachIdStId") Long coachIdStId,
                                     @Param("status") Integer status, @Param("course") int course);


}
