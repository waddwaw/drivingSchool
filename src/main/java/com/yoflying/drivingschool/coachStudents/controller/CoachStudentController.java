package com.yoflying.drivingschool.coachStudents.controller;

import com.yoflying.drivingschool.domain.model.ManageUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liqiang on 16/12/13.
 */
@Controller
@RequestMapping("/coachstudent")
public class CoachStudentController {


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createCoachStudent() {

        return "";
    }

}
