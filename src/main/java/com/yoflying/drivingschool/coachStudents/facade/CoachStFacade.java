package com.yoflying.drivingschool.coachStudents.facade;

import com.yoflying.drivingschool.domain.model.AppointmentSt;
import com.yoflying.drivingschool.domain.service.AppointmentStService;
import com.yoflying.drivingschool.utils.json.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liqiang on 16/12/18.
 */
@Service
public class CoachStFacade {

    @Autowired
    AppointmentStService appointmentStService;

    public List<AppointmentSt> getAppointment(long dsId, long coachId, int testCoures) {
        List<AppointmentSt>  appointmentSts = appointmentStService.findAppointmentStbyCoachIdandCoures(dsId, coachId, testCoures);
        return appointmentSts;
    }

}
