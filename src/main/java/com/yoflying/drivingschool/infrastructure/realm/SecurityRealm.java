package com.yoflying.drivingschool.infrastructure.realm;

import com.yoflying.drivingschool.domain.model.*;
import com.yoflying.drivingschool.domain.service.CoachStudentService;
import com.yoflying.drivingschool.domain.service.ManageUserService;
import com.yoflying.drivingschool.domain.service.PermissionService;
import com.yoflying.drivingschool.domain.service.RoleService;
import com.yoflying.drivingschool.infrastructure.token.ManageToken;
import com.yoflying.drivingschool.infrastructure.token.RestAccessToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(SecurityRealm.class);

    @Autowired
    private ManageUserService manageUserService;

    @Autowired
    private CoachStudentService coachStudentService;

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

        //学员or教练 权限验证逻辑
        if (principals.getPrimaryPrincipal() instanceof CoachStudentUser) {
            CoachStudentUser coachStudentUser = (CoachStudentUser) principals.getPrimaryPrincipal();
            if (coachStudentUser.getDiscern() == CoachStudentUser.COACH) {
                authorizationInfo.addRole(RoleSign.COACH);
            }else if (coachStudentUser.getDiscern() == CoachStudentUser.STUDENT) {
                authorizationInfo.addRole(RoleSign.STUDENT);
            }
            return authorizationInfo;
        }

        ManageUser user = (ManageUser) principals.getPrimaryPrincipal();
        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getId());
        for (Role role : roleInfos) {
            // 添加角色
            logger.debug("secruity" + role.toString());
            authorizationInfo.addRole(role.getRole_sign());

            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
            for (Permission permission : permissions) {
                // 添加权限
                logger.debug("secruity" + permission.toString());
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

        //APP Restful
        if (token instanceof RestAccessToken) {
           RestAccessToken restAccessToken =  ((RestAccessToken) token);
            if (restAccessToken.getCategory() == 1) {
                ManageUser manageUser = manageUserService.findOneByManageId(restAccessToken.getUserId());
                if (Objects.isNull(manageUser)){
                    return null;
                }else {
                    return new SimpleAuthenticationInfo(manageUser, restAccessToken.getTokenCode(), this.getName());
                }
            }
            if (restAccessToken.getCategory() == 2) {
                CoachStudentUser coachStudentUser = coachStudentService.findOneByCoachStID(restAccessToken.getUserId());
                if (Objects.isNull(coachStudentUser)){
                    return null;
                }else {
                    return new SimpleAuthenticationInfo(coachStudentUser, restAccessToken.getTokenCode(), this.getName());
                }
            }
        }

        //学员or教练
        if (token instanceof ManageToken) {
            ManageToken restAccessToken = (ManageToken) token;
            String password = new String(((UsernamePasswordToken) token).getPassword());
             CoachStudentUser coachStudent = coachStudentService.authentication(restAccessToken.getUsername(),
                     password);

            if (Objects.isNull(coachStudent)) {
                return null;
            } else {
                return new SimpleAuthenticationInfo(coachStudent, coachStudent.getPassword(), this.getName());
            }
        }

        //管理平台登录
        if (token instanceof UsernamePasswordToken) {
            UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
            String password = new String(((UsernamePasswordToken) token).getPassword());
            ManageUser manageUser = manageUserService.authentication(usernamePasswordToken.getUsername(),
                    password );

            if (Objects.isNull(manageUser)) {
                return null;
            } else {
                return new SimpleAuthenticationInfo(manageUser, manageUser.getPassword(), this.getName());
            }
        }

        return null;
    }

}
