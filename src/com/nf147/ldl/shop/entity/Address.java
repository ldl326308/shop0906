package com.nf147.ldl.shop.entity;

public class Address {
    int a_id;   //id
    int a_u_id;  //用户id
    String a_name;   //收货人姓名
    String a_phone;   //收货人联系电话
    String a_address;   //收货地址

    public Address() {
    }

    public Address(int a_id, int a_u_id, String a_name, String a_phone, String a_address) {
        this.a_id = a_id;
        this.a_u_id = a_u_id;
        this.a_name = a_name;
        this.a_phone = a_phone;
        this.a_address = a_address;
    }

    public Address(int a_u_id, String a_name, String a_phone, String a_address) {
        this.a_u_id = a_u_id;
        this.a_name = a_name;
        this.a_phone = a_phone;
        this.a_address = a_address;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getA_u_id() {
        return a_u_id;
    }

    public void setA_u_id(int a_u_id) {
        this.a_u_id = a_u_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_phone() {
        return a_phone;
    }

    public void setA_phone(String a_phone) {
        this.a_phone = a_phone;
    }

    public String getA_address() {
        return a_address;
    }

    public void setA_address(String a_address) {
        this.a_address = a_address;
    }
}
