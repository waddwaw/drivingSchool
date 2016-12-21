package com.yoflying.drivingschool.domain.service;

import com.yoflying.drivingschool.domain.model.ManageUser;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员 业务接口
 * Created by liqiang on 16/12/13.
 */
public interface ManageUserService {

    /**
     * 验证用户密码是否正确
     * 并且数据status 字段为 1
     * @param user
     * @param pwd
     * @return
     */
    ManageUser authentication (String user, String pwd);

    ManageUser findOneByManageId(long id);

    int insertManage(ManageUser manageUser);
}
