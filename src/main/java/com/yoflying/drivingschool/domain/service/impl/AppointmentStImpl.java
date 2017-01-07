package com.yoflying.drivingschool.domain.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yoflying.drivingschool.domain.dao.AppointmentStMapper;
import com.yoflying.drivingschool.domain.model.AppointmentSt;
import com.yoflying.drivingschool.domain.service.AppointmentStService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by liqiang on 16/12/15.
 */
@Repository
public class AppointmentStImpl implements AppointmentStService {

    @Resource
    AppointmentStMapper appointmentStMapper;

    public int insertAppointmentSt(AppointmentSt appointmentSt) {
        return appointmentStMapper.insertAppointmentSt(appointmentSt);
    }

    public int updateAppointmentSt(Integer status, Long coachId, Long dsId, String studentsIds) {
        return appointmentStMapper.updateAppointmentSt(status, coachId, dsId, studentsIds);
    }

    public List<AppointmentSt> findAppointmentStbyDsIDandCoachId(Long dsId, Long coachId) {
        return appointmentStMapper.findAppointmentStbyDsIDandCoachId(dsId, coachId);
    }

    public List<AppointmentSt> findAppointmentStbyDsIDandStIdAll(Long dsId, Long stId) {
        return appointmentStMapper.findAppointmentStbyDsIDandStIdAll(dsId, stId);
    }

    public List<AppointmentSt> findAppointmentStbysDsIdALL(Long dsId) {
        return appointmentStMapper.findAppointmentStbysDsIdALL(dsId);
    }

    public List<AppointmentSt> findAppointmentStbyCoachIdandCoures(Long dsId, Long coachId, int testCoures) {
        return appointmentStMapper.findAppointmentStbyCoachIdandCoures(dsId, coachId, testCoures);
    }

    public int deleteAppointmentStbyIdALL(int id) {
        return appointmentStMapper.deleteAppointmentStbyStatusALL(id);
    }
}
