package com.yoflying.drivingschool.infrastructure.interceptor;

import com.yoflying.drivingschool.domain.model.ManageUser;
import org.apache.http.HttpStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by liqiang on 16/12/13.
 */
public class ManagementInterceptor extends HandlerInterceptorAdapter {
    private final Logger logger = LoggerFactory.getLogger(ManagementInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            HandlerMethod handlerMethod = (HandlerMethod) handler;

            Subject subject = SecurityUtils.getSubject();
            ManageUser manageUser = (ManageUser)subject.getPrincipal();

            if (Objects.isNull(manageUser)) {

                if (Objects.isNull(handlerMethod.getMethodAnnotation(ResponseBody.class))) {

                    response.sendRedirect("/manage/login");

                }else {
                    response.setStatus(HttpStatus.SC_UNAUTHORIZED);
                }
                return false;
            }
        return true;
    }

}
