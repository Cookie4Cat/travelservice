package edu.ynu.travel.message.user;


import edu.ynu.travel.entity.user.UserEntity;

import java.util.List;

public class UserList {

    private List<UserEntity> users;

    private int count;

    public UserList(int count, List<UserEntity> users) {
        this.count = count;
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
