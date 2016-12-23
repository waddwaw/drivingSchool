package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.DrivingSchoolMapper;
import com.yoflying.drivingschool.domain.model.DrivingSchool;
import com.yoflying.drivingschool.domain.service.DrivingSchoolService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liqiang on 16/12/14.
 */
@Repository
public class DrivingSchoolmpl implements DrivingSchoolService {

    @Resource
    DrivingSchoolMapper drivingSchoolMapper;

    public int insertByDrivingSchool(DrivingSchool drivingSchool) {
        return drivingSchoolMapper.insertByDrivingSchool(drivingSchool);
    }

    public DrivingSchool findByDrivingSchool(@Param("id") long id) {
        return drivingSchoolMapper.findByDrivingSchool(id);
    }

    public List<DrivingSchool> findDrivingSchoolByStatusAll() {
        return drivingSchoolMapper.findDrivingSchoolByStatusAll();
    }
}
