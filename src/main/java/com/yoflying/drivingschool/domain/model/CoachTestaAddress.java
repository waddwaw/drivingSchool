package com.yoflying.drivingschool.domain.model;

import java.sql.Timestamp;

/**
 * Created by arvin on 2016/12/23.
 */
public class CoachTestaAddress {
    public final static int COURSE2 = 2;
    public final static int COURSE3 = 3;

    private Long id;
    private Long userId;
    private Integer testCourse;
    private String testAddress;
    private Timestamp createTime;
    private Timestamp modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
//        `id` bigint(20) NOT NULL AUTO_INCREMENT,
//        `userId` bigint(20) NOT NULL COMMENT '教练id',
//        `testCourse` int(1) NOT NULL COMMENT '练习科目',
//        `testAddress` varchar(200) NOT NULL COMMENT '练车地点',
//        `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
//        `modifyTime` datetime DEFAULT NULL COMMENT '修改时间',
