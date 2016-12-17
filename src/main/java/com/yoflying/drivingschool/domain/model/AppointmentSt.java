package com.yoflying.drivingschool.domain.model;

import com.alibaba.fastjson.JSONObject;

import java.sql.Timestamp;

/**
 * Created by liqiang on 16/12/15.
 */
public class AppointmentSt extends BaseModel{
    private Long id;
    private Long dsId;
    private Long coachId;
    private Integer testCourse;
    private String testAddress;
    private String studentsIds;
    private Timestamp appointmentDate;
    private int status;
    private Timestamp createTime;
    private Timestamp modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDsId() {
        return dsId;
    }

    public void setDsId(Long dsId) {
        this.dsId = dsId;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Integer getTestCourse() {
        return testCourse;
    }

    public void setTestCourse(Integer testCourse) {
        this.testCourse = testCourse;
    }

    public String getTestAddress() {
        return testAddress;
    }

    public void setTestAddress(String testAddress) {
        this.testAddress = testAddress;
    }

    public String getStudentsIds() {
        return studentsIds;
    }

    public void setStudentsIds(String studentsIds) {
        this.studentsIds = studentsIds;
    }

    public Timestamp getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Timestamp appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Timestamp modifyTime) {
        this.modifyTime = modifyTime;
    }
}
//          `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
//          `dsId` bigint(20) NOT NULL COMMENT '驾校id',
//          `coachId` bigint(20) NOT NULL COMMENT '教练id',
//          `testCourse` int(11) NOT NULL COMMENT '预约科目',
//          `testAddress` varchar(250) NOT NULL COMMENT '练车地点',
//          `studentsIds` JSON DEFAULT NULL COMMENT '预约学习id JSON格式',
//          `appointmentDate` datetime NOT NULL COMMENT '预约时间',
//          `status` int(11) DEFAULT NULL COMMENT '状态 1为正常 2为过期',
//          `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//          `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',