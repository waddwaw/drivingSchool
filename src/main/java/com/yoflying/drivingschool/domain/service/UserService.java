package com.yoflying.drivingschool.domain.service;


import com.yoflying.drivingschool.domain.model.User;

/**
 * 用户 业务 接口
 * 
 * @author StarZou
 * @since 2014年7月5日 上午11:53:33
 **/
public interface UserService  {

    /**
     * 用户验证
     * 
     * @param user
     * @param pwd
     * @return
     */
    User authentication(String user, String pwd);

    /**
     * 根据用户名查询用户
     * 
     * @param username
     * @return
     */
    User selectByUsername(String username);
}
