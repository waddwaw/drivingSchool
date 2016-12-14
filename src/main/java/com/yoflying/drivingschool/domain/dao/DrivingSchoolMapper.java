package com.yoflying.drivingschool.domain.dao;

import com.yoflying.drivingschool.domain.model.DrivingSchool;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;


/**
 * Created by liqiang on 16/12/14.
 */
@MapperScan
public interface DrivingSchoolMapper {

    @Insert("INSERT INTO drivingSchool (dsName, dsAddress,dsPhone,dsWeb,logo,status,modifyTime)" +
            " VALUES(#{dsName},#{dsAddress},#{dsPhone},#{dsWeb},#{logo},#{status},NOW())")
    int insertByDrivingSchool(DrivingSchool drivingSchool);

    @Select("SELECT * FROM drivingSchool WHERE id = #{id} and status = 1")
    DrivingSchool findByDrivingSchool( @Param("id") long id);

}
