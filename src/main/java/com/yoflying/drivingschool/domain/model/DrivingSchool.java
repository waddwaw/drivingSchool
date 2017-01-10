package com.yoflying.drivingschool.domain.model;

import org.hibernate.validator.constraints.NotBlank;

import java.sql.Timestamp;

/**
 * Created by liqiang on 16/12/14.
 */
public class DrivingSchool extends BaseModel {

    private Long id;
    @NotBlank(message = "驾校名字不能为空")
    private String dsName;
    @NotBlank(message = "驾校电话不能为空")
    private String dsPhone;
    private String dsWeb;
    private String dsAddress;
    private String logo;
    private int status;
    private Timestamp createTime;
    private Timestamp modifyTime;

    public String getDsAddress() {
        return dsAddress;
    }

    public void setDsAddress(String dsAddress) {
        this.dsAddress = dsAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getDsPhone() {
        return dsPhone;
    }

    public void setDsPhone(String dsPhone) {
        this.dsPhone = dsPhone;
    }

    public String getDsWeb() {
        return dsWeb;
    }

    public void setDsWeb(String dsWeb) {
        this.dsWeb = dsWeb;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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
//        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '驾校id',
//        `dsName` varchar(128) NOT NULL COMMENT '驾校名称',
//        `dsAddress` varchar(128) NOT NULL COMMENT '驾校地址',
//        `dsPhone` varchar(20) NOT NULL COMMENT '驾校电话',
//        `dsWeb` varchar(100) DEFAULT NULL COMMENT '驾校网站',
//        `logo` varchar(150) DEFAULT NULL COMMENT '驾校Logo',
//        `status` int(11) DEFAULT NULL COMMENT '状态 1为可用',
//        `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//        `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',