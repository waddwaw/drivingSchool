package com.yoflying.drivingschool;

import com.yoflying.drivingschool.domain.model.ManageUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Created by liqiang on 16/12/13.
 */
public class BaseControllet {

    /**
     * 获取管理员信息
     * @return
     */
    protected ManageUser getManageUser() {
        Subject subject = SecurityUtils.getSubject();
        return (ManageUser)subject.getPrincipal();
    }
}
