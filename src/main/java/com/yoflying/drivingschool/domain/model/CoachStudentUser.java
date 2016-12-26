package com.yoflying.drivingschool.domain.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

/**
 * Created by arvin on 2016/12/14.
 */
public class CoachStudentUser extends BaseModel {
    public final static int COACH = 1;
    public final static int STUDENT = 2;

    private Long id;
    private String username;
    private String password;
    private Long dsId;
    @NotBlank(message = "姓名不能为空")
    private String name;
    private Integer sex;
    @Pattern(regexp = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}|^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X|x)$" ,message = "身份证号码格式不正确")
    private String identityCard;
    @Range(min=1, max=2, message = "包含非法参数")
    private int discern;
    @Pattern(regexp = "^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\\d{8}$", message = "手机号码错误")
    private String phone;
    private String wechat;
    private String address;
    private int course;
    private int coachId;
    private int status;
    private Timestamp createTime;
    private Timestamp modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getDsId() {
        return dsId;
    }

    public void setDsId(Long dsId) {
        this.dsId = dsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public Integer getDiscern() {
        return discern;
    }

    public void setDiscern(Integer discern) {
        this.discern = discern;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
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
//         `username` varchar(50) DEFAULT NULL COMMENT '用户名',
//         `password` varchar(50) NOT NULL COMMENT '密码',
//         `dsId` bigint(20) NOT NULL COMMENT '驾校id',
//         `name` varchar(20) DEFAULT NULL COMMENT '姓名',
//         `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
//         `identityCard` varchar(200) NOT NULL COMMENT '身份证',
//         `discern` int(11) NOT NULL COMMENT '教练 学员 识别ID 1为 教练 2为 学员',
//         `phone` varchar(20) NOT NULL COMMENT '联系人电话',
//         `wechat` varchar(30) DEFAULT NULL COMMENT '微信',
//         `address` varchar(128) NOT NULL COMMENT '联系地址',
//         `course` int(11) DEFAULT NULL COMMENT '课程1为科目一 2 为科目二 以此类推',
//         `coachId` bigint(20) DEFAULT NULL COMMENT '学员绑定的教练id',
//         `status` int(11) DEFAULT NULL COMMENT '状态 1为可用',
//         `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//         `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
