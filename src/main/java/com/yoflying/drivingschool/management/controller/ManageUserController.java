package com.yoflying.drivingschool.management.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yoflying.drivingschool.management.BaseManageControllet;
import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.domain.service.ManageUserService;
import com.yoflying.drivingschool.utils.json.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台管理页面Controller
 * Created by liqiang on 16/12/13.
 */
@Controller
@RequestMapping("/manage")
public class ManageUserController extends BaseManageControllet {
    private final Logger logger = LoggerFactory.getLogger(ManageUserController.class);

    @Autowired
    ManageUserService manageUserService;

    @RequestMapping("/login")
    public String login (ModelMap map) {

        //// TODO: 16/12/13 返回login页面
        ManageUser m  = manageUserService.authentication("", "");
        map.put("test", "test");
        return "/manage/index.ftl";
    }

//  username  password  host Ip地址
    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<String> loginPost (UsernamePasswordToken token) {
        logger.info("manage" + token.getUsername() + "---------" + token.getHost());

        if (StringUtils.isEmpty(token.getUsername()) || StringUtils.isEmpty(token.getUsername())) {
            return new JsonResult<String>("用户密码不能为空", ErrorDef.USER_PASS_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();

        token.setRememberMe(true);
        try {
            subject.login(token);
            SecurityUtils.getSubject().getSession().setTimeout(1000 * 10);

        }catch (AuthenticationException e) {
            token.clear();
            return new JsonResult<String>("用户密码错误", ErrorDef.USER_PASS_ERROR);
        }
        return new JsonResult<String>("登录成功", ErrorDef.SUCCESS);
    }

    @RequestMapping(value = "/index")
    public String index (ModelMap map) {

         //分页demo 目前已经集成
//        PageHelper.startPage(1, peage);
//        List<User> users = userMapper.byListUserName(name);
//        long total  = ((Page) users).getTotal();

        ManageUser manageUser = getManageUser();

        return "/manage/index.ftl";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create() {

        return "";
    }
}
