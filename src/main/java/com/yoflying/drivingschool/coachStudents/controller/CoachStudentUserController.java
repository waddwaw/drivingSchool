package com.yoflying.drivingschool.coachStudents.controller;

import com.yoflying.drivingschool.coachStudents.BaseCsController;
import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.infrastructure.token.RestAccessToken;
import com.yoflying.drivingschool.utils.json.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liqiang on 16/12/13.
 */
@Controller
@RequestMapping("/coachstudent")
public class CoachStudentUserController extends BaseCsController{
    private final Logger logger = LoggerFactory.getLogger(CoachStudentUserController.class);


    @RequestMapping(value = "/login")
    public String login() {

        return "";
    }

    //  username  password  host Ip地址
    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<Integer> loginPost (RestAccessToken token) {
        logger.info("coachstudent" + token.getUsername() + "---------" + token.getHost());

        if (StringUtils.isEmpty(token.getUsername()) || StringUtils.isEmpty(token.getUsername())) {
            return new JsonResult<Integer>("用户密码不能为空", ErrorDef.USER_PASS_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();

        token.setRememberMe(true);
        try {
            subject.login(token);
            SecurityUtils.getSubject().getSession().setTimeout(1000 * 11);
            CoachStudentUser coachStudentUser = getCoachStudentUser();
            if (coachStudentUser.getDiscern() == CoachStudentUser.COACH ) {
                return new JsonResult<Integer>(CoachStudentUser.COACH, "欢迎教练登录", ErrorDef.SUCCESS);
            }
            if (coachStudentUser.getDiscern() == CoachStudentUser.STUDENT ) {
                return new JsonResult<Integer>(CoachStudentUser.STUDENT, "欢迎学员登录", ErrorDef.SUCCESS);
            }

        }catch (AuthenticationException e) {
            token.clear();
            return new JsonResult<Integer>("用户密码错误", ErrorDef.USER_PASS_ERROR);
        }
        return new JsonResult<Integer>("非法用户", ErrorDef.USER_PASS_ERROR);
    }

}
