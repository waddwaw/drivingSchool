package com.yoflying.drivingschool.infrastructure.realm;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by arvin on 2016/11/14.
 * shiro ajax 处理
 */
@Component(value = "ajaxUserFilter")
public class AjaxUserFilter extends UserFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

            HttpServletRequest req = WebUtils.toHttp(request);
            String xmlHttpRequest = req.getHeader("X-Requested-With");
            if ( xmlHttpRequest != null )
                if ( xmlHttpRequest.equalsIgnoreCase("XMLHttpRequest") )  {
                    HttpServletResponse res = WebUtils.toHttp(response);
                    res.sendError(401);
                    return false;
                }

            return super.onAccessDenied(request, response);
        }

}
