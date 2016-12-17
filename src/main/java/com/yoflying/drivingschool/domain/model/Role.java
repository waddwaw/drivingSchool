package com.yoflying.drivingschool.domain.model;

/**
 * 角色模型
 * 
 * @author StarZou
 * @since 2014年7月17日 下午1:02:25
 **/
public class Role extends BaseModel {
    private Long id;

    private String role_name;

    private String role_sign;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_sign() {
        return role_sign;
    }

    public void setRole_sign(String role_sign) {
        this.role_sign = role_sign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", role_sign='" + role_sign + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}