package com.yoflying.drivingschool.infrastructure.interceptor;

import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import org.apache.http.HttpStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by arvin on 2016/12/21.
 */
@Component(value = "authInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter {
    private final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        RequiresPermissions requiresPermissions = handlerMethod.getBeanType().getAnnotation(RequiresPermissions.class);
        RequiresRoles requiresRoles = handlerMethod.getBeanType().getAnnotation(RequiresRoles.class);

        if (Objects.isNull(requiresPermissions) && Objects.isNull(requiresRoles)) {
            requiresPermissions = handlerMethod.getMethod().getAnnotation(RequiresPermissions.class);
            requiresRoles = handlerMethod.getMethod().getAnnotation(RequiresRoles.class);
        }
        //对需要权限认证的接口进行拦截操作
        if (!Objects.isNull(requiresPermissions) || !Objects.isNull(requiresRoles)) {
            String accesstoken = request.getHeader("accesstoken");

        }
        return true;
    }
}

