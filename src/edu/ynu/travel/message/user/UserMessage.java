package edu.ynu.travel.message.user;


import edu.ynu.travel.entity.user.RoleEntity;
import edu.ynu.travel.entity.user.UserEntity;


import java.util.List;

public class UserMessage extends UserEntity {
    private List<RoleEntity> roles;

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
