package com.yoflying.drivingschool.domain.service;

import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.ManageUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    CoachStudentUser findOneByCoachStID(long id);

    int insertCoachStudentUser(CoachStudentUser coachStudentUser);

    int updateStudentBindCoach(Long dsId, Long studentsId, Long coachId, Integer course);

    int updateCoachStudentUserStatus(Long dsId, Long coachIdStId, Integer status, Integer course);

    List<CoachStudentUser> findStByDsIdList(Long dsId);

    List<CoachStudentUser> findCoachByDsIdList(Long dsId);

    List<CoachStudentUser> findCoachByDsIdAndNameList(Long dsId, String name);

    List<CoachStudentUser> findStByDsIdAndNameList(Long dsId, String name);
}
