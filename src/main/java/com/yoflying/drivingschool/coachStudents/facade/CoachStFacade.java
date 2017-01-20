package com.yoflying.drivingschool.coachStudents.facade;

import com.yoflying.drivingschool.coachStudents.model.StudentModel;
import com.yoflying.drivingschool.domain.model.AppointmentSt;
import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.DrivingSchool;
import com.yoflying.drivingschool.domain.service.AppointmentStService;
import com.yoflying.drivingschool.domain.service.CoachStudentService;
import com.yoflying.drivingschool.domain.service.DrivingSchoolService;
import com.yoflying.drivingschool.entity.DSInfoEntity;
import com.yoflying.drivingschool.utils.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liqiang on 16/12/18.
 */
@Service
public class CoachStFacade {

    @Autowired
    AppointmentStService appointmentStService;

    @Autowired
    DrivingSchoolService drivingSchoolService;

    @Autowired
    CoachStudentService coachStudentService;
    public List<AppointmentSt> getAppointmentInfo(long dsId, long coachId, int testCoures) {
        List<AppointmentSt>  appointmentSts = appointmentStService.findAppointmentStbyCoachIdandCoures(dsId, coachId, testCoures);
        return appointmentSts;
    }

    public DSInfoEntity getDsInfo(long dsId) {

        DrivingSchool drivingSchool = drivingSchoolService.findByDrivingSchool(dsId);

        DSInfoEntity dsInfoEntity = new DSInfoEntity();
        dsInfoEntity.setDsName(drivingSchool.getDsName());
        dsInfoEntity.setDsLogo(drivingSchool.getLogo());
        dsInfoEntity.setAddress(drivingSchool.getDsAddress());

        return dsInfoEntity;
    }

    public List<AppointmentSt> getAppointmentInfo(long dsId, long coachId) {
        List<AppointmentSt>  appointmentSts = appointmentStService.findAppointmentStbyDsIDandCoachId(dsId, coachId);
        return appointmentSts;
    }

    public CoachStudentUser getCoach(long coachId) {
        return coachStudentService.findOneByCoachStID(coachId);
    }

    public StudentModel getStudentModel(long dsId, long caachId) {
        StudentModel studentModel = new StudentModel();
        DrivingSchool drivingSchool = drivingSchoolService.findByDrivingSchool(dsId);
        CoachStudentUser coach = getCoach(caachId);
        studentModel.setDsName(drivingSchool.getDsName());
        studentModel.setAnnouncement("测试消息----测试消息");
        studentModel.setComments("100%");
        studentModel.setDsLogo(drivingSchool.getLogo());
        studentModel.setLevel("神级");
        studentModel.setMyCoach(coach == null ? "未绑定" : coach.getName());
        studentModel.setMyCoachId(coach == null ? 0 :coach.getId());
        studentModel.setPhone(coach == null ? "未绑定" : coach.getPhone());
        return studentModel;
    }
}
