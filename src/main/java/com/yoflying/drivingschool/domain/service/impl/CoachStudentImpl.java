package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.CoachStudentUserMapper;
import com.yoflying.drivingschool.domain.dao.ManageUserMapper;
import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.domain.service.CoachStudentService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by arvin on 2016/12/14.
 */
@Repository
public class CoachStudentImpl implements CoachStudentService{

    @Resource
    CoachStudentUserMapper coachStudentUserMapper;

    public CoachStudentUser authentication(String user, String pwd) {
        return coachStudentUserMapper.findOneByManageAndStatusAvailable(user, pwd);
    }

    public int insertCoachStudentUser(CoachStudentUser coachStudentUser) {
        return coachStudentUserMapper.insertCoachStudentUser(coachStudentUser);
    }
}
