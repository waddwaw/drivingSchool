package com.yoflying.drivingschool.domain.model;

import com.alibaba.fastjson.JSONObject;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * Created by liqiang on 16/12/14.
 */
public class DsLeave extends BaseModel {

    private Long id;
    private Long dsId;
    @NotNull()
    private Long coachId;
    @NotBlank
    private String leaveDate2;
    @NotBlank
    private String leaveDate3;
    @NotBlank
    private String coachName;
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

    public String getLeaveDate2() {
        return leaveDate2;
    }

    public void setLeaveDate2(String leaveDate2) {
        this.leaveDate2 = leaveDate2;
    }

    public String getLeaveDate3() {
        return leaveDate3;
    }

    public void setLeaveDate3(String leaveDate3) {
        this.leaveDate3 = leaveDate3;
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

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }
}
//        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
//        `dsId` bigint(20) NOT NULL COMMENT '驾校id',
//        `coachId` bigint(20) NOT NULL COMMENT '教练id',
//        `leaveDate2` JSON DEFAULT NULL COMMENT '科目二 教练请假时间 不生成预约表信息 JSON格式',
//        `leaveDate3` JSON DEFAULT NULL COMMENT '科目三 教练请假时间 不生成预约表信息 JSON格式',
//        `status` int(11) DEFAULT NULL COMMENT '状态 1为正常 2为过期',
//        `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//        `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',