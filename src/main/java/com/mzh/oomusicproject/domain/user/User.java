package com.mzh.oomusicproject.domain.user;

public class User {
    private Long id;
    private String username;
    private String password;
    private String userImg;
    private String ooName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getOoName() {
        return ooName;
    }

    public void setOoName(String ooName) {
        this.ooName = ooName;
    }
}
