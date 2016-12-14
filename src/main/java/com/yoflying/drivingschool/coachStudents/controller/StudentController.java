package com.yoflying.drivingschool.coachStudents.controller;

import com.yoflying.drivingschool.coachStudents.BaseCsController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liqiang on 16/12/14.
 */
@RequestMapping("/coachstudent/student")
@Controller
public class StudentController extends BaseCsController {

    @RequestMapping("/index")
    public String index(ModelMap map) {

        return "coach.ftl";
    }
}
