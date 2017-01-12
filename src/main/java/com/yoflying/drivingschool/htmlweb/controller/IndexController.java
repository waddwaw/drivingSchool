package com.yoflying.drivingschool.htmlweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by arvin on 2016/12/22.
 */
@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @RequestMapping("/index")
    public String index(HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("index","欢迎使用 柚飞科技约车系统 ！开发人员 姚九龙 李娇 李立强");
        
        String ua = request.getHeader("user-agent");
        //// TODO: 17/1/12 判断是否为手机用户
        
        return "/index/index.ftl";
    }

    @RequestMapping("/exception")
    public String exception(ModelMap modelMap) {
        modelMap.put("error","错了错啦");
        return "/exception.ftl";
    }

    @RequestMapping("/404")
    public String err404(ModelMap modelMap) {

        return "/index/404.ftl";
    }
}
