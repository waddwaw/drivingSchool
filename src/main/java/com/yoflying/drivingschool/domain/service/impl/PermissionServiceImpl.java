package com.yoflying.drivingschool.domain.service.impl;

import com.yoflying.drivingschool.domain.dao.PermissionMapper;
import com.yoflying.drivingschool.domain.model.Permission;
import com.yoflying.drivingschool.domain.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 权限Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午12:05:03
 */
@Service
public class PermissionServiceImpl  implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    public List<Permission> selectPermissionsByRoleId(Long roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }
}
