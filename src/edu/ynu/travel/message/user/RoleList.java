package edu.ynu.travel.message.user;

import edu.ynu.travel.entity.user.RoleEntity;

import java.util.List;

public class RoleList {
    private List<RoleEntity> roles;
    private int count;

    public RoleList(List<RoleEntity> roles, int count) {
        this.roles = roles;
        this.count = count;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
