package com.yoflying.drivingschool.coachStudents.controller;

import com.alibaba.fastjson.JSON;
import com.yoflying.drivingschool.coachStudents.BaseCsController;
import com.yoflying.drivingschool.coachStudents.facade.CoachStFacade;
import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.infrastructure.realm.RoleSign;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liqiang on 16/12/14.
 */
@RequestMapping("/coachstudent/coach")
@Controller
public class CoachController extends BaseCsController {

    @Autowired
    CoachStFacade coachStFacade;

    @RequestMapping("/index")
    @RequiresRoles(RoleSign.COACH)
    public String index(ModelMap map) {
        CoachStudentUser coach = getCoachStudentUser();

        map.put("dsInfo", JSON.toJSONString(coachStFacade.getDsInfo(coach.getDsId())));
        map.put("coachInfo", JSON.toJSONString(coach));
        map.put("appointment", JSON.toJSONString(coachStFacade.getAppointmentInfo(coach.getDsId(), coach.getId())));

        return "/coachSt/coach.ftl";
    }
}
