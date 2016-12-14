package com.yoflying.drivingschool.domain.dao;


import com.yoflying.drivingschool.domain.model.DSSetting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by liqiang on 16/12/14.
 */
@MapperScan
public interface DSSettingMapper {

    @Insert("INSERT INTO ds_setting (dsId, dsAppointment2,dsAppointment3,outCoachIds,status,modifyTime)" +
            " VALUES(#{dsId},#{dsAppointment2},#{dsAppointment3},#{outCoachIds},#{status},NOW())")
    int insertDssetting(DSSetting dsSetting);

    @Update("UPDATE INTO ds_setting SET  dsAppointment2 = #{dsAppointment2}," +
            " dsAppointment3 = #{dsAppointment3}, outCoachIds = #{outCoachIds}, " +
            "status = #{status}, modifyTime = NOW() " +
            "WHERE dsId = #{dsId}")
    int updateDssetting(DSSetting dsSetting);

    @Select("SELECT * FROM ds_setting WHERE dsId = #{dsId}")
    DSSetting findOneDSSetting(@Param("dsId") Long dsId);
}
