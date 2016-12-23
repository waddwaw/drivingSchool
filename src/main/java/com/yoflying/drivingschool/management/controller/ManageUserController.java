package com.yoflying.drivingschool.management.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yoflying.drivingschool.domain.model.*;
import com.yoflying.drivingschool.infrastructure.realm.PermissionSign;
import com.yoflying.drivingschool.infrastructure.realm.RoleSign;
import com.yoflying.drivingschool.management.BaseManageControllet;
import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.domain.service.ManageUserService;
import com.yoflying.drivingschool.management.facade.ManageServiceFacade;
import com.yoflying.drivingschool.management.model.CoachStatusCouresModel;
import com.yoflying.drivingschool.utils.json.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
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


    /**
     * 管理员页面登录页面
     * @param map
     * @return
     */
    @RequestMapping("/login")
    public String login (ModelMap map) {

        //// TODO: 16/12/13 返回login页面
        ManageUser m  = manageUserService.authentication("", "");
        map.put("test", "test");
        return "/manage/login.ftl";
    }

//  username  password  host Ip地址

    /**
     * 管理员用户登录 post 请求 可以携带IP地址
     * @param token
     * @return
     */
    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult<String> loginPost (UsernamePasswordToken token) {
        logger.info("manage" + token.getUsername() + "---------" + token.getHost());

        if (StringUtils.isEmpty(token.getUsername()) || StringUtils.isEmpty(token.getUsername())) {
            return new JsonResult<String>("用户密码不能为空", ErrorDef.USER_PASS_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (AuthenticationException e) {
            token.clear();
            return new JsonResult<String>("用户密码错误", ErrorDef.USER_PASS_ERROR);
        }
        return new JsonResult<String>("登录成功", ErrorDef.SUCCESS);
    }

    @RequestMapping(value = "/index")
    @RequiresRoles(RoleSign.ADMIN)
    public String index (ModelMap map) {

         //分页demo 目前已经集成
//        PageHelper.startPage(1, peage);
//        List<User> users = userMapper.byListUserName(name);
//        long total  = ((Page) users).getTotal();
        ManageUser manageUser = getManageUser();

        return "/manage/index.ftl";
    }

    /**
     * 超级管理员创建驾校管理员
     * @param manageUser
     * @return
     */
    @RequestMapping(value = "/createManage", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createManage(@RequestBody ManageUser manageUser) {
        int err = manageServiceFacade.createManage(manageUser);
        return new JsonResult<String>("创建管理员成功", err);
    }

    /**
     * 创建教练or 学员
     * @param coachStudentUser
     * @return
     */
    @RequestMapping(value = "/createCoachSt", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createCoachSt(@RequestBody @Valid CoachStudentUser coachStudentUser) {

        coachStudentUser.setDsId(getManageUser().getDsId());
        int err = manageServiceFacade.createCoachSt(coachStudentUser);
        int discern = coachStudentUser.getDiscern();
        if (discern == 1) {
            return new JsonResult<String>("创建教练成功", err);
        }
        return new JsonResult<String>("创建学员成功", err);
    }

    /**
     * 超级管理员创建驾校
     * @param drivingSchool
     * @return
     */
    @RequestMapping(value = "/createDrivingSchool", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createDrivingSchool(@RequestBody @Valid DrivingSchool drivingSchool) {
        int err = manageServiceFacade.createDrivingSchool(drivingSchool);

        return new JsonResult<String>("创建驾校成功", err);
    }


    /**
     * 教练请假申请
     * @param dsLeave
     * @return
     */
    @RequestMapping(value = "/createLeave", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createLeave(@RequestBody @Valid DsLeave dsLeave) {

        dsLeave.setDsId(getManageUser().getDsId());

        int err = manageServiceFacade.createLeave(dsLeave);

        return new JsonResult<String>("教练请假成功", err);
    }

    /**
     * 根据驾校id 查找驾校所有学生
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/findStudentList")
    @ResponseBody
    public JsonResult findStudentbyDsIdList(Integer pageNum) {
        ManageUser manageUser = getManageUser();

        return manageServiceFacade.findStudentbyDsIdList(manageUser.getDsId(), pageNum);
    }

    /**
     * discern 为1 对该驾校教练进行模糊搜索 为2 对学员进行模糊搜索
     * @param
     * @return
     */
    @RequestMapping(value = "/searchCoachStList")
    @ResponseBody
    public JsonResult searchCoachStList(Integer discern, String name) {

        if ( !(discern <= 2) || !(discern > 0) ||StringUtils.isEmpty(name)) {
            return new JsonResult("参数传递错误", ErrorDef.SUCCESS);
        }

        return manageServiceFacade.searchCoachStList(getManageUser().getDsId(), name, discern);
    }

    /**
     * 根据驾校id 查找驾校所有教练
     * @param pageNum
     * @return
     */
    @RequestMapping(value = "/findCoachList")
    @ResponseBody
    public JsonResult findCoachbyDsIdList(Integer pageNum) {
        ManageUser manageUser = getManageUser();

        return manageServiceFacade.findCoachbyDsIdList(manageUser.getDsId(), pageNum);
    }

    /**
     * 管理员更改驾校配置设置
     * @param dsSetting
     * @return
     */
    @RequestMapping(value = "/settingDrivingConfig", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult settingDrivingConfig(@RequestBody @Valid DSSetting dsSetting) {

        dsSetting.setDsId(getManageUser().getDsId());
        //{"time":[{"start":"","stop":""},{"start":"","stop":""}],"size":3}
        int err = manageServiceFacade.settingDrivingconfig(dsSetting);

        return new JsonResult("更改驾校配置设置成功", err);
    }


    /**
     *更改学员绑定教练 or 更改学员当前科目
     * @return
     */
    @RequestMapping(value = "/bindCSCUpdate", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult bindCoachorStatusCourseUpdate(@RequestBody @Valid CoachStatusCouresModel cscModel, BindingResult result) {

        if(result.hasErrors()) {
            return getErrors(result);
        }

        int err = manageServiceFacade.bindCoachorStatusCourseUpdate(getManageUser().getDsId(), cscModel);

        return new JsonResult("操作成功", err);
    }
}
