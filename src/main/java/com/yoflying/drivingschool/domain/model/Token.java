package com.yoflying.drivingschool.domain.model;

import java.sql.Timestamp;

/**
 * Created by arvin on 2016/12/21.
 */
public class Token extends BaseModel{
    private Long id;
    private Long userId;
    private int category;
    private String tokenCode;
    private Timestamp createTime;

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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getTokenCode() {
        return tokenCode;
    }

    public void setTokenCode(String tokenCode) {
        this.tokenCode = tokenCode;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
//        `id` bigint(20) NOT NULL AUTO_INCREMENT,
//        `userId` bigint(20) NOT NULL COMMENT '用户ID',
//        `category` int(1) NOT NULL COMMENT 'token类别',
//        `tokenCode` varchar(100) NOT NULL COMMENT 'token Code',
//        `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',