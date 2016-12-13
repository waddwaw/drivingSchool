package com.yoflying.drivingschool.management.controller;

import com.yoflying.drivingschool.BaseControllet;
import com.yoflying.drivingschool.domain.dao.ManageUserMapper;
import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.domain.service.ManageUserService;
import com.yoflying.drivingschool.domain.service.impl.ManageUserImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liqiang on 16/12/13.
 */
@Controller
@RequestMapping("/manage")
public class ManageUserController extends BaseControllet {

    @Autowired
    ManageUserService manageUserService;


    @RequestMapping("/login")
    @ResponseBody
    public String login (ModelMap map) {

        //// TODO: 16/12/13 返回logo页面
        ManageUser m  = manageUserService.authentication("", "");
        return "lgoin";
    }



//  username  password  host
    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    @ResponseBody
    public String loginPost (UsernamePasswordToken token) {


        Subject subject = SecurityUtils.getSubject();

        token.setRememberMe(true);
        try {
            subject.login(token);
            SecurityUtils.getSubject().getSession().setTimeout(1000 * 10);

        }catch (AuthenticationException e) {
            token.clear();

        }
        return "";
    }
}
