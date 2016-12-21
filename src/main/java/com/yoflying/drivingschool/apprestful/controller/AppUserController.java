package com.yoflying.drivingschool.apprestful.controller;

import com.yoflying.drivingschool.coachStudents.controller.CoachStudentUserController;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * Created by arvin on 2016/12/21.
 */
@RequestMapping("/restful/")
@Controller
public class AppUserController {
    private final Logger logger = LoggerFactory.getLogger(AppUserController.class);

    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult loginPost(@RequestBody RestAccessToken token) {
        logger.info("coachstudent" + token.getUsername() + "---------" + token.getHost());
        if (StringUtils.isEmpty(token.getUsername()) || StringUtils.isEmpty(token.getUsername())) {
            return new JsonResult<Integer>("用户密码不能为空", ErrorDef.USER_PASS_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            String uuid = UUID.randomUUID().toString();


        }catch (AuthenticationException e) {
            token.clear();
        }
        return new JsonResult<Integer>("非法用户", ErrorDef.USER_PASS_ERROR);
    }

}
