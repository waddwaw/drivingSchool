package com.yoflying.drivingschool.domain.service;

import com.alibaba.fastjson.JSONObject;
import com.yoflying.drivingschool.domain.model.AppointmentSt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by liqiang on 16/12/15.
 */
public interface AppointmentStService {

    int insertAppointmentSt(AppointmentSt appointmentSt);


    int updateAppointmentSt( Integer status, Long coachId,  Long dsId, String studentsIds);


    List<AppointmentSt> findAppointmentStbyDsIDandCoachId(Long dsId, Long coachId);


    List<AppointmentSt> findAppointmentStbyDsIDandStIdAll(Long dsId, Long stId);


    List<AppointmentSt> findAppointmentStbysDsIdALL(Long dsId);

    List<AppointmentSt> findAppointmentStbyCoachIdandCoures(Long dsId, Long coachId, int testCoures);

    List<AppointmentSt> findAppointmentStbysDsIdToday(Long dsId, String adate);

    int deleteAppointmentStbyIdALL(int status);
}
