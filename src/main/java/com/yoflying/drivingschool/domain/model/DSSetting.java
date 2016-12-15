package com.yoflying.drivingschool.domain.model;

import com.alibaba.fastjson.JSONObject;

import java.sql.Timestamp;

/**
 * Created by liqiang on 16/12/14.
 */
public class DSSetting {
    private Long id;
    private Long dsId;
    private String dsAppointment2;
    private String dsAppointment3;
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

    public String getDsAppointment2() {
        return dsAppointment2;
    }

    public void setDsAppointment2(String dsAppointment2) {
        this.dsAppointment2 = dsAppointment2;
    }

    public String getDsAppointment3() {
        return dsAppointment3;
    }

    public void setDsAppointment3(String dsAppointment3) {
        this.dsAppointment3 = dsAppointment3;
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

//        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
//        `dsId` bigint(20) NOT NULL COMMENT '驾校id',
//        `dsAppointment2` JSON DEFAULT NULL COMMENT '科目二 驾校自动生成预约时间 JSON格式',
//        `dsAppointment3` JSON DEFAULT NULL COMMENT '科目三驾校自动生成预约时间 JSON格式',
//        `outCoachIds` JSON DEFAULT NULL COMMENT '排除教练id 不生成预约表信息 JSON格式',
//        `status` int(11) DEFAULT NULL COMMENT '状态 1为正常 2为过期',
//        `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//        `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',