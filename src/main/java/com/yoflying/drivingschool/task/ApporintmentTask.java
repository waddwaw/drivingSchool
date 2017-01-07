package com.yoflying.drivingschool.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yoflying.drivingschool.domain.model.*;
import com.yoflying.drivingschool.domain.service.*;
import com.yoflying.drivingschool.utils.json.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by arvin on 2016/12/23.
 * 定时系统 在夜间系统运行不繁忙的时候执行预约订单和预约历史记录的数据维护操作
 */
@Component
public class ApporintmentTask {
    private final Logger logger = LoggerFactory.getLogger(ApporintmentTask.class);

    @Autowired
    DrivingSchoolService drivingSchoolService;
    @Autowired
    DsLeaveService dsLeaveService;
    @Autowired
    DSSettingService dsSettingService;
    @Autowired
    CoachStudentService coachStudentService;
    @Autowired
    AppointmentStService appointmentStService;
    @Autowired
    CoachTestAddressService coachTestAddressService;

    private List<DrivingSchool> drivingSchools;
    private int day;

    //    @Scheduled(cron ="0 0 2 * * ?")
    public void appointmentTask() {
        day = 0;
        drivingSchools = drivingSchoolService.findDrivingSchoolByStatusAll();
        while (day < 7) {  // 每次生成一周的预约信息
            for (DrivingSchool drivingSchool : drivingSchools) {
                List<CoachStudentUser> coachStudentUsers = coachStudentService.findCoachByDsIdList(drivingSchool.getId());
                DSSetting dsSetting = dsSettingService.findOneDSSetting(drivingSchool.getId());
                List<Long> outCoachIds = (List<Long>) JSON.parse(dsSetting.getOutCoachIds());
                for (CoachStudentUser coachStudentUser : coachStudentUsers) {
                    if (outCoachIds != null && outCoachIds.contains(coachStudentUser.getId())) {
                        continue;
                    }
                    DsLeave dsLeaves = dsLeaveService.findDsLeavebyDsIDandCoachId(drivingSchool.getId(), coachStudentUser.getId());
                    List<CoachTestaAddress> ctas = coachTestAddressService.findCTAByUserIdAndCoures(coachStudentUser.getId());
                    String cta2 = null;
                    String cta3 = null;
                    for (CoachTestaAddress c : ctas) {
                        if (c.getTestCourse() == CoachTestaAddress.COURSE2) {
                            cta2 = c.getTestAddress();
                        }
                        if (c.getTestCourse() == CoachTestaAddress.COURSE3) {
                            cta3 = c.getTestAddress();
                        }
                    }
                    String taskTime = TimeUtils.getBackTime(TimeUtils.YYYY_MM_DD, day);
                    JSONObject setting2 = (JSONObject) JSON.parse(dsSetting.getDsAppointment2());
                    JSONArray setting2Arr = (JSONArray) JSON.parse(setting2.getString("time"));
                    for (int i = 0; i < setting2Arr.size(); i++) {
                        String start = setting2Arr.getJSONObject(i).getString("start");
                        String stop = setting2Arr.getJSONObject(i).getString("stop");
                        insetApporintment(taskTime, start, stop, cta2, dsLeaves == null ? "" : dsLeaves.getLeaveDate2(),
                                setting2.getInteger("size"), coachStudentUser.getId(), coachStudentUser.getDsId(), CoachTestaAddress.COURSE2);
                    }
                    JSONObject setting3 = (JSONObject) JSON.parse(dsSetting.getDsAppointment3());
                    JSONArray setting3Arr = (JSONArray) JSON.parse(setting3.getString("time"));
                    for (int i = 0; i < setting3Arr.size(); i++) {
                        String start = setting3Arr.getJSONObject(i).getString("start");
                        String stop = setting3Arr.getJSONObject(i).getString("stop");
                        insetApporintment(taskTime, start, stop, cta3, dsLeaves == null ? "" : dsLeaves.getLeaveDate3(),
                                setting3.getInteger("size"), coachStudentUser.getId(), coachStudentUser.getDsId(), CoachTestaAddress.COURSE3);
                    }
                }
            }
            day++;
        }
    }

    private void insetApporintment(String taskTime, String start, String stop, String address, String leaves, int size, long coachId, long dsId, int testCoures) {
        if (StringUtils.isEmpty(address)) {
            return;
        }
        AppointmentSt appointmentSt = new AppointmentSt();
        JSONObject appointmentStJson = new JSONObject();
        JSONObject obj = new JSONObject();
        obj.put("start", taskTime + " " + start);
        obj.put("stop", taskTime + " " + stop);
        appointmentStJson.put("time", obj);
        appointmentStJson.put("size", size);
        appointmentSt.setAppointmentDate(appointmentStJson.toJSONString());
        appointmentSt.setTestCourse(testCoures);
        appointmentSt.setTestAddress(address);
        appointmentSt.setCoachId(coachId);
        appointmentSt.setDsId(dsId);
        appointmentSt.setStatus(1);
        if (StringUtils.isEmpty(leaves)) {
            appointmentStService.insertAppointmentSt(appointmentSt);
        } else { //处理请假 半天为一个单位
            if (!(TimeUtils.getAMorPM(leaves) == TimeUtils.getAMorPM(taskTime + " " + start))) {
                appointmentStService.insertAppointmentSt(appointmentSt);
            }
        }
    }

}
