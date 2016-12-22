package com.yoflying.drivingschool.htmlweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by arvin on 2016/12/22.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.put("index","欢迎使用 柚飞科技约车系统 ！开发人员 姚九龙 李娇 李立强");
        return "/index/index.ftl";
    }
}
