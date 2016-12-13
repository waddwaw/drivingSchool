package com.yoflying.drivingschool.domain.dao;


import com.yoflying.drivingschool.domain.model.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


/**
 * 角色 Dao 接口
 *
 * @author liliqiang
 * @since 2016年11月12日 上午11:59:03
 **/
@MapperScan
public interface RoleMapper {

    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    @Select("SELECT role.id,role.role_name,role.role_sign,role.description FROM role, user_role " +
            "WHERE user_role.user_id = #{userId} and role.id = user_role.user_id ")
    List<Role> selectRolesByUserId(@Param("userId") Long userId);
}