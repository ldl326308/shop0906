package com.nf147.ldl.shop.entity;

import java.math.BigDecimal;

//商品信息显示
public class Type_Product {
    // 商品id 类型id 商品名称 商品价格 图片 状态
    int p_id;
    int t_id;
    String t_name;
    String p_name;
    BigDecimal p_price;
    String p_photo;
    int p_state;

    public Type_Product() {
    }

    public Type_Product(int p_id,int t_id, String t_name, String p_name, BigDecimal p_price, String p_photo, int p_state) {
        this.p_id = p_id;
        this.t_id=t_id;
        this.t_name = t_name;
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_photo = p_photo;
        this.p_state = p_state;
    }

    public Type_Product(int p_id, int t_id, String p_name, BigDecimal p_price, String p_photo, int p_state) {
        this.p_id = p_id;
        this.t_id = t_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_photo = p_photo;
        this.p_state = p_state;
    }

    public Type_Product(int t_id, String p_name, BigDecimal p_price, String p_photo, int p_state) {
        this.t_id = t_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.p_photo = p_photo;
        this.p_state = p_state;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getT_name() {
        return t_name;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public BigDecimal getP_price() {
        return p_price;
    }

    public void setP_price(BigDecimal p_price) {
        this.p_price = p_price;
    }

    public String getP_photo() {
        return p_photo;
    }

    public void setP_photo(String p_photo) {
        this.p_photo = p_photo;
    }

    public int getP_state() {
        return p_state;
    }

    public void setP_state(int p_state) {
        this.p_state = p_state;
    }

    @Override
    public String toString() {
        return "Type_Product{" +
                "p_id=" + p_id +
                ", t_name='" + t_name + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_price=" + p_price +
                ", p_phone='" + p_photo + '\'' +
                ", p_state=" + p_state +
                '}';
    }
}
