package com.yoflying.drivingschool.apprestful.controller;

import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.domain.model.Token;
import com.yoflying.drivingschool.domain.service.CoachStudentService;
import com.yoflying.drivingschool.domain.service.ManageUserService;
import com.yoflying.drivingschool.domain.service.TokenService;
import com.yoflying.drivingschool.infrastructure.token.RestAccessToken;
import com.yoflying.drivingschool.utils.json.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/restful")
@Controller
public class AppUserController {
    private final Logger logger = LoggerFactory.getLogger(AppUserController.class);
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ManageUserService manageUserService;
    @Autowired
    private CoachStudentService coachStudentService;

    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult loginPost(@RequestBody RestAccessToken token) {
        logger.info("coachstudent" + token.getUsername() + "---------" + token.getHost());

        if (StringUtils.isEmpty(token.getUsername()) || StringUtils.isEmpty(token.getUsername())) {
            return new JsonResult<Integer>("用户密码不能为空", ErrorDef.USER_PASS_ERROR);
        }

        if (token.getCategory() == 0) {
            return new JsonResult<Integer>("关键性参数错误", ErrorDef.USER_PASS_ERROR);
        }

        if (token.getCategory() == 1) {
            ManageUser manageUser = manageUserService.authentication(token.getUsername(), new String(token.getPassword()));
            if (manageUser != null) {
                String uuid = UUID.randomUUID().toString();
                Token token1 = new Token();
                token1.setUserId(manageUser.getId());
                token1.setCategory(1);
                token1.setTokenCode(uuid);
                tokenService.insertToken(token1);
                return new JsonResult<Object>(ErrorDef.SUCCESS, uuid, manageUser);
            }
        }
        if (token.getCategory() == 2) {
            CoachStudentUser coachStudentUser = coachStudentService.authentication(token.getUsername(), new String(token.getPassword()));
            if (coachStudentUser != null) {
                String uuid = UUID.randomUUID().toString();
                Token token1 = new Token();
                token1.setUserId(coachStudentUser.getId());
                token1.setCategory(2);
                token1.setTokenCode(uuid);
                tokenService.insertToken(token1);
                return new JsonResult<Object>(ErrorDef.SUCCESS, uuid, coachStudentUser);
            }
        }
        return new JsonResult<Object>("用户或者密码错误", ErrorDef.USER_PASS_ERROR);
    }

}
