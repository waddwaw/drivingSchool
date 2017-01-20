package com.yoflying.drivingschool.coachStudents.controller;

import com.alibaba.fastjson.JSON;
import com.yoflying.drivingschool.coachStudents.BaseCsController;
import com.yoflying.drivingschool.coachStudents.facade.CoachStFacade;
import com.yoflying.drivingschool.coachStudents.model.StudentModel;
import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.domain.model.AppointmentSt;
import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.infrastructure.realm.RoleSign;
import com.yoflying.drivingschool.utils.json.JsonResult;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liqiang on 16/12/14.
 */
@RequestMapping("/coachstudent/student")
@Controller
public class StudentController extends BaseCsController {

    @Autowired
    CoachStFacade coachStFacade;

    @RequiresRoles(RoleSign.STUDENT)
    @RequestMapping("/index")
    public String index(ModelMap map) {

        CoachStudentUser studentUser = getCoachStudentUser();

        StudentModel studentModel = coachStFacade.getStudentModel(studentUser.getDsId(), studentUser.getCoachId());
        studentModel.setMyId(studentUser.getId());
        map.put("studentModel", JSON.toJSONString(studentModel));

        map.put("appointment", JSON.toJSONString(coachStFacade.getAppointmentInfo(studentUser.getDsId(), studentUser.getCoachId(), studentUser.getCourse())));

        return "/coachSt/student.ftl";
    }

    @RequestMapping(value = "/getAppointment", method = RequestMethod.GET)
    @RequiresRoles(RoleSign.STUDENT)
    @ResponseBody
    public JsonResult getAppointment() {
        CoachStudentUser coachStudentUser = getCoachStudentUser();

        List<AppointmentSt> appointmentSts = coachStFacade.getAppointmentInfo(coachStudentUser.getDsId(), coachStudentUser.getCoachId(), coachStudentUser.getCourse());
//        if (appointmentSts != null && appointmentSts.size() > 0)
        return new JsonResult<List<AppointmentSt>>(ErrorDef.SUCCESS, "返回数据", appointmentSts);
    }



}
