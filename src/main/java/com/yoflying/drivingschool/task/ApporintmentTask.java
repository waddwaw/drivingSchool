package com.yoflying.drivingschool.task;

import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.DSSetting;
import com.yoflying.drivingschool.domain.model.DrivingSchool;
import com.yoflying.drivingschool.domain.model.DsLeave;
import com.yoflying.drivingschool.domain.service.CoachStudentService;
import com.yoflying.drivingschool.domain.service.DSSettingService;
import com.yoflying.drivingschool.domain.service.DrivingSchoolService;
import com.yoflying.drivingschool.domain.service.DsLeaveService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by arvin on 2016/12/23.
 * 定时系统 在夜间系统运行不繁忙的时候执行预约订单和预约历史记录的数据维护操作
 */
@Component
public class ApporintmentTask {
    private final Logger logger = LoggerFactory.getLogger(ApporintmentTask.class);

    @Autowired
    DrivingSchoolService drivingSchoolService;
    @Autowired
    DsLeaveService dsLeaveService;
    @Autowired
    DSSettingService dsSettingService;
    @Autowired
    CoachStudentService coachStudentService;

    private List<DrivingSchool> drivingSchools;
    private int day;

    //    @Scheduled(cron ="0 0 2 * * ?")
    public void AppointmentTask() {
        day = 0;
        drivingSchools = drivingSchoolService.findDrivingSchoolByStatusAll();
        for (DrivingSchool drivingSchool : drivingSchools) {
            List<CoachStudentUser> coachStudentUsers = coachStudentService.findCoachByDsIdList(drivingSchool.getId());
            DSSetting dsSetting = dsSettingService.findOneDSSetting(drivingSchool.getId());
            for(CoachStudentUser coachStudentUser : coachStudentUsers) {
                DsLeave dsLeaves = dsLeaveService.findDsLeavebyDsIDandCoachId(drivingSchool.getId(), coachStudentUser.getId());
            }
        }
    }

}
