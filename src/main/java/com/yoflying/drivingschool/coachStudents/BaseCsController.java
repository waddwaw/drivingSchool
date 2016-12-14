package com.yoflying.drivingschool.coachStudents;

import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.ManageUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Created by liqiang on 16/12/14.
 */
public class BaseCsController {

    /**
     * 获取教练学员信息
     * @return
     */
    protected CoachStudentUser getCoachStudentUser() {
        Subject subject = SecurityUtils.getSubject();
        return (CoachStudentUser)subject.getPrincipal();
    }
}
