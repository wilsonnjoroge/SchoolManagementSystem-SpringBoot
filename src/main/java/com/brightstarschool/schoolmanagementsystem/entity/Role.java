package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "role_code")
    private long roleCode;

    @Column(name = "role_name")
    private String roleName;

    public Role() {
    }

    public Role(long id, long roleCode, String roleName) {
        this.id = id;
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public Role(long roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(long roleId) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleId=" + roleCode +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
