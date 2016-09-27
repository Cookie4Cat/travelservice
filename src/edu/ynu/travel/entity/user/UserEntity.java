package edu.ynu.travel.entity.user;


import org.codehaus.jackson.annotate.JsonIgnore;


public class UserEntity {


    private Integer id;


    private String username;


    private String passwordHash;


    private String email;


    private Short status;


    private Integer createdAt;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @JsonIgnore
    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash == null ? null : passwordHash.trim();
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }


    public Short getStatus() {
        return status;
    }


    public void setStatus(Short status) {
        this.status = status;
    }


    public Integer getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }
}