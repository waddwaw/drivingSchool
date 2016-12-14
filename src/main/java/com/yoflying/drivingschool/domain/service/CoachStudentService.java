package com.yoflying.drivingschool.domain.service;

import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.ManageUser;

/**
 * Created by arvin on 2016/12/14.
 */
public interface CoachStudentService {
    /**
     * 验证用户密码是否正确
     * 并且数据status 字段为 1
     * @param user
     * @param pwd
     * @return
     */
    CoachStudentUser authentication (String user, String pwd);
}
