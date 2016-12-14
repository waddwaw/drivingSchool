package com.yoflying.drivingschool.domain.model;

import java.sql.Timestamp;

/**
 * 后台管理员模型
 * Created by liqiang on 16/12/13.
 */

public class ManageUser {

    private Long id;
    private String username;
    private String password;
    private Long dsId;
    private String identityCard;
    private String dsPhone;
    private int status;
    private Timestamp createTime;
    private Timestamp modifyTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getDsId() {
        return dsId;
    }

    public void setDsId(long dsId) {
        this.dsId = dsId;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getDsPhone() {
        return dsPhone;
    }

    public void setDsPhone(String dsPhone) {
        this.dsPhone = dsPhone;
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

//    DROP TABLE IF EXISTS `management`;
//        CREATE TABLE `management` (
//        `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
//        `username` varchar(50) NOT NULL COMMENT '用户名',
//        `password` varchar(50) NOT NULL COMMENT '密码',
//        `dsId` bigint(20) NOT NULL COMMENT '驾校id',
//        `identityCard` varchar(200) NOT NULL COMMENT '身份证',
//        `dsPhone` varchar(20) NOT NULL COMMENT '联系人电话',
//        `status` int(11) DEFAULT NULL COMMENT '状态 1为可用',
//        `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//        `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
//        PRIMARY KEY (`id`)
//        ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';
