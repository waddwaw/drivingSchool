package com.yoflying.drivingschool.domain.service;

import com.yoflying.drivingschool.domain.model.DrivingSchool;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liqiang on 16/12/14.
 */
public interface DrivingSchoolService {

    int insertByDrivingSchool(DrivingSchool drivingSchool);

    DrivingSchool findByDrivingSchool( @Param("id") long id);

    List<DrivingSchool> findDrivingSchoolByStatusAll();
}
