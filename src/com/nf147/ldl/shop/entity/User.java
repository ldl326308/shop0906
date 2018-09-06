package com.nf147.ldl.shop.entity;

public class User {
    int u_id; //用户id
    String user_id;  //登入账号
    String user_pwd;   //登入密码
    String user_phone;  //联系电话
    String user_email;   //用户邮箱

    public User(){}

    public User(String user_id, String user_pwd, String user_phone, String user_email) {
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.user_phone = user_phone;
        this.user_email = user_email;
    }

    public User(int u_id, String user_id, String user_pwd, String user_phone, String user_email) {
        this.u_id = u_id;
        this.user_id = user_id;
        this.user_pwd = user_pwd;
        this.user_phone = user_phone;
        this.user_email = user_email;
    }


    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
