package com.yoflying.drivingschool.management.facade;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yoflying.drivingschool.constdef.Const;
import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.domain.model.*;
import com.yoflying.drivingschool.domain.service.*;
import com.yoflying.drivingschool.entity.DSInfoEntity;
import com.yoflying.drivingschool.management.model.CoachStatusCouresModel;
import com.yoflying.drivingschool.utils.json.JsonResult;
import com.yoflying.drivingschool.utils.json.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Autowired
    DSSettingService dsSettingService;

    @Autowired
    AppointmentStService appointmentStService;

    public int createManage(ManageUser manageUser) {

        int err = manageUserService.insertManage(manageUser);

        return err > 0 ? ErrorDef.SUCCESS : ErrorDef.FAILURE;
    }

    public int createCoachSt(CoachStudentUser coachStudentUser) {

       int err = coachStudentService.insertCoachStudentUser(coachStudentUser);


        return err > 0 ? ErrorDef.SUCCESS : ErrorDef.FAILURE;
    }

    public int createDrivingSchool(DrivingSchool drivingSchool) {

        int err = drivingSchoolService.insertByDrivingSchool(drivingSchool);

        return err > 0 ? ErrorDef.SUCCESS : ErrorDef.FAILURE;
    }

    public int createLeave(DsLeave dsLeave) {

        int err = dsLeaveService.insertDsLeave(dsLeave);

        return err > 0 ? ErrorDef.SUCCESS : ErrorDef.FAILURE;
    }

    public JsonResult<List<CoachStudentUser>> findStudentbyDsIdList(Long dsId, int pageNum) {

        PageHelper.startPage(pageNum, Const.DEF_PAGE_SIZA);
        List<CoachStudentUser> studentUsers = coachStudentService.findStByDsIdList(dsId);
        long total  = ((Page) studentUsers).getTotal();

        return new JsonResult<List<CoachStudentUser>>(ErrorDef.SUCCESS, "查询成功", pageNum, total, studentUsers);
    }

    public JsonResult<List<CoachStudentUser>> findCoachbyDsIdList(Long dsId, int pageNum) {

        PageHelper.startPage(pageNum, Const.DEF_PAGE_SIZA);
        List<CoachStudentUser> studentUsers = coachStudentService.findCoachByDsIdList(dsId);
        long total  = ((Page) studentUsers).getTotal();

        return new JsonResult<List<CoachStudentUser>>(ErrorDef.SUCCESS, "查询成功", pageNum, total, studentUsers);
    }

    public int settingDrivingconfig(DSSetting dsSetting) {

        dsSettingService.updateDssetting(dsSetting);

        return ErrorDef.SUCCESS;
    }

    public JsonResult searchCoachStList(Long dsId, String name, int discern) {

        List<CoachStudentUser> coachStudentUsers = null;

        if (discern == CoachStudentUser.COACH) {
            coachStudentUsers = coachStudentService.findCoachByDsIdAndNameList(dsId, name);
        }else if (discern == CoachStudentUser.STUDENT) {
            coachStudentUsers = coachStudentService.findStByDsIdAndNameList(dsId, name);
        }

        return new JsonResult<List<CoachStudentUser>>(ErrorDef.SUCCESS, "返回查询结果", coachStudentUsers);
    }

    public int bindCoachorStatusCourseUpdate(long dsId, CoachStatusCouresModel coachStatusCouresModel) {

        int err = coachStudentService.updateStudentBindCoach(dsId, coachStatusCouresModel.getStudentsId(),
                coachStatusCouresModel.getCoachId(), coachStatusCouresModel.getCourse());

        return err > 0 ? ErrorDef.SUCCESS : ErrorDef.FAILURE;
    }

    public DSInfoEntity getDSInfo(long dsid) {

        DrivingSchool drivingSchool = drivingSchoolService.findByDrivingSchool(dsid);

        DSInfoEntity dsInfoEntity = new DSInfoEntity();
        dsInfoEntity.setDsName(drivingSchool.getDsName());
        dsInfoEntity.setDsLogo(drivingSchool.getLogo());
        dsInfoEntity.setAddress(drivingSchool.getDsAddress());
        dsInfoEntity.setCoachTotal(coachStudentService.findCoachTotal(dsid));
        dsInfoEntity.setStudentTotal(coachStudentService.findStudentTotal(dsid));

        return dsInfoEntity;
    }

    public List<AppointmentSt> dsAppointrentSt(long dsId) {

        List<AppointmentSt> appointmentSts = appointmentStService.findAppointmentStbysDsIdToday(dsId, TimeUtils.DateToString(
                new Date(), TimeUtils.YYYY_MM_DD));

        return appointmentSts;
    }

}
