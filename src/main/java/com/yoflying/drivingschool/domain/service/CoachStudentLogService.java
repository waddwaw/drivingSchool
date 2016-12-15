package com.yoflying.drivingschool.domain.service;

import com.yoflying.drivingschool.domain.model.CoachStudentLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by liqiang on 16/12/15.
 */
public interface CoachStudentLogService {

    int insertCoachStudentLog(CoachStudentLog coachStudentLog);

    List<CoachStudentLog> findCoachStudentLogbyDsIDandCoachId(Long dsId, Long coachId);

    List<CoachStudentLog> findCoachStudentLogbyDsIDandStIdAll(Long dsId, Long studentsIds);

    List<CoachStudentLog> findCoachStudentLogbysDsIdALL(Long dsId);
}
