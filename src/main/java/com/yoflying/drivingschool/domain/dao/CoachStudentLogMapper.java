package com.yoflying.drivingschool.domain.dao;

import com.yoflying.drivingschool.domain.model.CoachStudentLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by liqiang on 16/12/15.
 */
@MapperScan
public interface CoachStudentLogMapper {

    @Insert("INSERT INTO coachStudentLog (dsId,coachId,testCourse,studentId,appointmentDate,course,testAddress,status,modifyTime)" +
            " VALUES( #{dsId},#{coachId},#{testCourse},#{studentId},#{appointmentDate},#{course},#{testAddress},#{status},NOW())")
    int insertCoachStudentLog(CoachStudentLog coachStudentLog);

    @Select("SELECT * FROM coachStudentLog WHERE dsId = #{dsId} and coachId = #{coachId} ORDER BY appointmentDate DESC")
    List<CoachStudentLog> findCoachStudentLogbyDsIDandCoachId(@Param("dsId") Long dsId, @Param("coachId") Long coachId);

    @Select("SELECT * FROM appointment_st WHERE dsId = #{dsId} and studentsIds =#{studentsIds} ORDER BY appointmentDate DESC")
    List<CoachStudentLog> findCoachStudentLogbyDsIDandStIdAll(@Param("dsId") Long dsId, @Param("studentsIds") Long studentsIds);

    @Select("SELECT * FROM appointment_st WHERE dsId = #{dsId} ORDER BY appointmentDate DESC")
    List<CoachStudentLog> findCoachStudentLogbysDsIdALL(@Param("dsId") Long dsId);


}
