package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.ManageUserMapper;
import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.domain.service.ManageUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 管理 Service 实现类
 * Created by liqiang on 16/12/13.
 */
@Repository
public class ManageUserImpl implements ManageUserService{

    @Resource
    ManageUserMapper manageUserMapper;

    public ManageUser authentication(String user, String pwd) {
        return manageUserMapper.findOneByManageAndStatusAvailable(user, pwd);
    }

    public int insertManage(ManageUser manageUser) {
        return manageUserMapper.insertManage(manageUser);
    }
}
