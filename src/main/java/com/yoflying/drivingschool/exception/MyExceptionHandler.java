package com.yoflying.drivingschool.exception;

import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.utils.json.JsonResult;
import org.apache.http.HttpStatus;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Created by liqiang on 16/12/22.
 */
@ControllerAdvice
public class MyExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler
    @ResponseBody
    public Object handleException(Exception ex , HttpServletRequest request, HttpServletResponse response ) {

        logger.error("caught Errors: {}", ex.getMessage(), ex);
        ModelMap modelMap = new ModelMap();

        String accesstoken = request.getHeader("accesstoken");
        if (ex instanceof UnauthorizedException && !StringUtils.isEmpty(accesstoken)) {
            modelMap.put("error", ex.getMessage() == null ? ex.getStackTrace() : ex.getMessage());
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return new JsonResult<ModelMap>(ErrorDef.FAILURE, "当前用户权限不够", modelMap);

        } else {
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);

            modelMap.put("error", ex.getMessage() == null ? ex.getStackTrace() : ex.getMessage());
        }

        return new ModelAndView("/exception.ftl",modelMap);
    }

    protected String getMessage(String code) {
        return getMessage(code, null);
    }

    protected String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
