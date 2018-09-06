package com.nf147.ldl.shop.entity;

import java.math.BigDecimal;

public class Product_Cart {
    int c_id;  //购物车id
    String p_name;   //简介
    int c_count;  //数量
    BigDecimal p_price;  //单价
    String p_photo;  //路径

    public Product_Cart() {
    }

    public Product_Cart(int c_id, String p_name, int c_count, BigDecimal p_price, String p_photo) {
        this.c_id = c_id;
        this.p_name = p_name;
        this.c_count = c_count;
        this.p_price = p_price;
        this.p_photo = p_photo;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getC_count() {
        return c_count;
    }

    public void setC_count(int c_count) {
        this.c_count = c_count;
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

    @Override
    public String toString() {
        return "Product_Cart{" +
                "c_id=" + c_id +
                ", p_name='" + p_name + '\'' +
                ", c_count=" + c_count +
                ", p_price=" + p_price +
                ", p_photo='" + p_photo + '\'' +
                '}';
    }
}
