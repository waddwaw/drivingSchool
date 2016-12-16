package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.CoachStudentUserMapper;
import com.yoflying.drivingschool.domain.dao.ManageUserMapper;
import com.yoflying.drivingschool.domain.model.CoachStudentUser;
import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.domain.service.CoachStudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by arvin on 2016/12/14.
 */
@Repository
public class CoachStudentImpl implements CoachStudentService{

    @Resource
    CoachStudentUserMapper coachStudentUserMapper;

    public CoachStudentUser authentication(String user, String pwd) {
        return coachStudentUserMapper.findOneByCoachStAndStatusAvailable(user, pwd);
    }

    public int insertCoachStudentUser(CoachStudentUser coachStudentUser) {
        return coachStudentUserMapper.insertCoachStudentUser(coachStudentUser);
    }

    public int updateStudentBindCoach(Long dsId, Long studentsId, Long coachId, Integer course) {
        return coachStudentUserMapper.updateStudentBindCoach(dsId, studentsId, coachId,course);
    }

    public int updateCoachStudentUserStatus(Long dsId, Long coachIdStId, Integer status, Integer course) {
        return coachStudentUserMapper.updateCoachStudentUserStatus(dsId, coachIdStId, status, course);
    }

    //根据驾校id 查找所有学生信息
    public List<CoachStudentUser> findStByDsIdList(Long dsId) {
        return coachStudentUserMapper.findStByDsIdList(dsId);
    }

    //根据驾校id 查找所有教练信息
    public List<CoachStudentUser> findCoachByDsIdList(Long dsId) {
        return coachStudentUserMapper.findCoachByDsIdList(dsId);
    }

}
