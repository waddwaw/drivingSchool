package com.yoflying.drivingschool.infrastructure.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created by arvin on 2016/12/14.
 */
public class RestAccessToken extends UsernamePasswordToken {

    private String accessToken;


    public RestAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    @Override
    public Object getCredentials() {
        return getAccessToken();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

}
