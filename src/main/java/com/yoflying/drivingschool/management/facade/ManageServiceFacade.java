package com.yoflying.drivingschool.management.facade;

import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.DrivingSchool;
import com.yoflying.drivingschool.domain.model.DsLeave;
import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.domain.service.CoachStudentService;
import com.yoflying.drivingschool.domain.service.DrivingSchoolService;
import com.yoflying.drivingschool.domain.service.DsLeaveService;
import com.yoflying.drivingschool.domain.service.ManageUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liqiang on 16/12/15.
 */
@Service
public class ManageServiceFacade {

    private final Logger logger = LoggerFactory.getLogger(ManageServiceFacade.class);

    @Autowired
    ManageUserService manageUserService;

    @Autowired
    CoachStudentService coachStudentService;

    @Autowired
    DrivingSchoolService drivingSchoolService;

    @Autowired
    DsLeaveService dsLeaveService;

    public int createManage(ManageUser manageUser) {

        manageUserService.insertManage(manageUser);

        return ErrorDef.SUCCESS;
    }

    public int createCoachSt(CoachStudentUser coachStudentUser) {

        coachStudentService.insertCoachStudentUser(coachStudentUser);

        return ErrorDef.SUCCESS;
    }

    public int createDrivingSchool(DrivingSchool drivingSchool) {

        drivingSchoolService.insertByDrivingSchool(drivingSchool);

        return ErrorDef.SUCCESS;
    }

    public int createLeave(DsLeave dsLeave) {

        dsLeaveService.insertDsLeave(dsLeave);

        return  ErrorDef.SUCCESS;
    }
}
