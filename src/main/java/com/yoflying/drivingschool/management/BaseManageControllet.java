package com.yoflying.drivingschool.management;

import com.yoflying.drivingschool.constdef.ErrorDef;
import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.utils.json.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiang on 16/12/13.
 */
public class BaseManageControllet {

    /**
     * 获取管理员信息
     *
     * @return
     */
    protected ManageUser getManageUser() {
        Subject subject = SecurityUtils.getSubject();
        return (ManageUser) subject.getPrincipal();
    }

    /**
     * ajax格式组合错误信息返回
     *
     * @param result
     * @return
     */
    public JsonResult getErrors(BindingResult result) {
        List<String> errorList = new ArrayList<String>();
        for (ObjectError error : result.getAllErrors()) {
            errorList.add(error.getDefaultMessage());
        }
        return new JsonResult<List<String>>(ErrorDef.FAILURE, "错误", errorList);
    }
}
