package com.yoflying.drivingschool.infrastructure.token;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

/**
 * Created by arvin on 2016/12/21.
 */
public class RestAccessToken extends UsernamePasswordToken {
    private Long userId;
    private int category;
    private String tokenCode;

    @Override
    public Object getCredentials() {
        return getTokenCode();
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
}
