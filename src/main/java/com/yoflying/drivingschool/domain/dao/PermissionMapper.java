package com.yoflying.drivingschool.domain.dao;


import com.yoflying.drivingschool.domain.model.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 权限 Dao 接口
 * 
 * @author liliqiang
 * @since 2016年11月12日 上午11:59:03
 **/
@MapperScan
public interface PermissionMapper {

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    @Select("SELECT permission.id,permission.permission_name,permission.permission_sign,permission.description " +
            "FROM permission, role_permission " +
            "WHERE role_permission.role_id = #{roleId} and role_permission.permission_id = permission.id ")
    List<Permission> selectPermissionsByRoleId(@Param("roleId") Long roleId);
}