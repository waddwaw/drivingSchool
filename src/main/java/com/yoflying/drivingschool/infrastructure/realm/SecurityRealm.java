package com.yoflying.drivingschool.infrastructure.realm;

import com.yoflying.drivingschool.domain.model.ManageUser;
import com.yoflying.drivingschool.domain.model.Permission;
import com.yoflying.drivingschool.domain.model.Role;
import com.yoflying.drivingschool.domain.model.User;
import com.yoflying.drivingschool.domain.service.ManageUserService;
import com.yoflying.drivingschool.domain.service.PermissionService;
import com.yoflying.drivingschool.domain.service.RoleService;
import com.yoflying.drivingschool.domain.service.impl.PermissionServiceImpl;
import com.yoflying.drivingschool.domain.service.impl.RoleServiceImpl;
import com.yoflying.drivingschool.domain.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


/**
 * 用户身份验证,授权 Realm 组件
 * 
 * @author StarZou
 * @since 2014年6月11日 上午11:35:28
 **/
@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

    @Autowired
    private ManageUserService manageUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;


    /**
     * 权限检查
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();

        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getId());
        for (Role role : roleInfos) {
            // 添加角色
            System.err.println(role);
            authorizationInfo.addRole(role.getRole_sign());

            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
            for (Permission permission : permissions) {
                // 添加权限
                System.err.println(permission);
                authorizationInfo.addStringPermission(permission.getPermission_sign());
            }
        }
        return authorizationInfo;
    }

    /**
     * 登录验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        //管理平台登录
        if (token instanceof UsernamePasswordToken) {

            UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

            //默认账户为手机号码
            ManageUser manageUser = manageUserService.authentication(usernamePasswordToken.getUsername(),
                    usernamePasswordToken.getUsername());

            if (Objects.isNull(manageUser)) {

                return null;

            } else {

                return new SimpleAuthenticationInfo(manageUser, manageUser.getPassword(), this.getName());
            }

        }

        return null;
    }

}
