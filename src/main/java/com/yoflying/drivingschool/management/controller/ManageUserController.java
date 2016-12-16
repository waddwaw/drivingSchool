package com.yoflying.drivingschool.management.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.DrivingSchool;
import com.yoflying.drivingschool.domain.model.DsLeave;
import com.yoflying.drivingschool.management.BaseManageControllet;
import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.domain.service.ManageUserService;
import com.yoflying.drivingschool.management.facade.ManageServiceFacade;
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
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    ManageServiceFacade manageServiceFacade;

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

    @RequestMapping(value = "/createManage", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createManage(@RequestBody ManageUser manageUser) {
        int err = manageServiceFacade.createManage(manageUser);
        return new JsonResult<String>("创建管理员成功", err);
    }

    @RequestMapping(value = "/createCoachSt", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createCoachSt(@RequestBody CoachStudentUser coachStudentUser) {

        coachStudentUser.setDsId(getManageUser().getDsId());
        int err = manageServiceFacade.createCoachSt(coachStudentUser);
        int discern = coachStudentUser.getDiscern();
        if (discern == 1) {
            return new JsonResult<String>("创建教练成功", err);
        }
        return new JsonResult<String>("创建学员成功", err);
    }

    @RequestMapping(value = "/createDrivingSchool", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createDrivingSchool(@RequestBody DrivingSchool drivingSchool) {
        int err = manageServiceFacade.createDrivingSchool(drivingSchool);

        return new JsonResult<String>("创建驾校成功", err);
    }

    @RequestMapping(value = "/createLeave", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createLeave(@RequestBody DsLeave dsLeave) {

        dsLeave.setDsId(getManageUser().getDsId());

        int err = manageServiceFacade.createLeave(dsLeave);

        return new JsonResult<String>("教练请假成功", err);
    }

    @RequestMapping(value = "/findStudentList")
    @ResponseBody
    public JsonResult findStudentbyDsIdList(Integer pageNum) {
        return manageServiceFacade.findStudentbyDsIdList(1L, pageNum);
    }

}
