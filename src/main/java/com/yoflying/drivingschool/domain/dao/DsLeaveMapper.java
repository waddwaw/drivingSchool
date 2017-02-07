package com.yoflying.drivingschool.domain.dao;

import com.yoflying.drivingschool.domain.model.DSSetting;
import com.yoflying.drivingschool.domain.model.DsLeave;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by liqiang on 16/12/14.
 */
@MapperScan
public interface DsLeaveMapper {

    @Insert("INSERT INTO ds_Leave (dsId, coachId,coachName,leaveDate2,leaveDate3,status,modifyTime)" +
            " VALUES( #{dsId},#{coachId},#{coachName},#{leaveDate2},#{leaveDate3},#{status},NOW())")
    int insertDsLeave(DsLeave dsLeave);

    @Update("UPDATE ds_Leave SET status = #{status}"+
            ",modifyTime = NOW() " +
            "WHERE dsId = #{dsId} and coachId = #{coachId}")
    int updateDsLeave(@Param("status") Integer status, @Param("coachId") Long coachId, @Param("dsId") Long dsId);

    @Select("SELECT * FROM ds_Leave WHERE dsId = #{dsId} and coachId = #{coachId} and status = 1")
    List<DsLeave> findDsLeavebyDsIDandCoachId(@Param("dsId") Long dsId,@Param("coachId") Long coachId);

    @Select("SELECT * FROM ds_Leave WHERE dsId = #{dsId} ORDER BY modifyTime DESC")
    List<DsLeave> findDsLeavebyDsIdALL(@Param("dsId") Long dsId);
}
