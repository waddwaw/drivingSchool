package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.CoachStudentLogMapper;
import com.yoflying.drivingschool.domain.model.CoachStudentLog;
import com.yoflying.drivingschool.domain.service.CoachStudentLogService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liqiang on 16/12/15.
 */
@Repository
public class CoachStudentLogImpl implements CoachStudentLogService {

    @Resource
    CoachStudentLogMapper coachStudentLogMapper;

    public int insertCoachStudentLog(CoachStudentLog coachStudentLog) {
        return coachStudentLogMapper.insertCoachStudentLog(coachStudentLog);
    }

    public List<CoachStudentLog> findCoachStudentLogbyDsIDandCoachId(Long dsId, Long coachId) {
        return coachStudentLogMapper.findCoachStudentLogbyDsIDandCoachId(dsId, coachId);
    }

    public List<CoachStudentLog> findCoachStudentLogbyDsIDandStIdAll(Long dsId, Long studentsIds) {
        return coachStudentLogMapper.findCoachStudentLogbyDsIDandStIdAll(dsId, studentsIds);
    }

    public List<CoachStudentLog> findCoachStudentLogbysDsIdALL(Long dsId) {
        return coachStudentLogMapper.findCoachStudentLogbysDsIdALL(dsId);
    }
}
