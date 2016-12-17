package com.yoflying.drivingschool.domain.model;

/**
 * 权限模型
 * 
 * @author StarZou
 * @since 2014年7月17日 下午1:02:55
 **/
public class Permission extends BaseModel {
    private Long id;

    private String permission_name;

    private String permission_sign;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public String getPermission_sign() {
        return permission_sign;
    }

    public void setPermission_sign(String permission_sign) {
        this.permission_sign = permission_sign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permission_name='" + permission_name + '\'' +
                ", permission_sign='" + permission_sign + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}