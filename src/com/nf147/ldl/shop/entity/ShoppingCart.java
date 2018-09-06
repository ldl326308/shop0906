package com.nf147.ldl.shop.entity;

import java.math.BigDecimal;

public class ShoppingCart {
    int c_id;  // 购物车id
    int c_u_id;   //用户id
    int c_p_id;  //商品id(唯一约束)
    String c_o_id;  //订单id
    int c_count;   //数量
    int c_state;  //状态 0  为提价订单，1 已提交订单

    public ShoppingCart() {
    }

    public ShoppingCart(int c_id, int c_u_id, int c_p_id, String c_o_id, int c_count, int c_state) {
        this.c_id = c_id;
        this.c_u_id = c_u_id;
        this.c_p_id = c_p_id;
        this.c_o_id = c_o_id;
        this.c_count = c_count;
        this.c_state = c_state;
    }

    //添加到购物车
    public ShoppingCart(int c_u_id,int c_p_id,int c_count ){
        this.c_u_id=c_u_id;
        this.c_p_id=c_p_id;
        this.c_count=c_count;
    }


    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getC_u_id() {
        return c_u_id;
    }

    public void setC_u_id(int c_u_id) {
        this.c_u_id = c_u_id;
    }

    public int getC_p_id() {
        return c_p_id;
    }

    public void setC_p_id(int c_p_id) {
        this.c_p_id = c_p_id;
    }

    public String getC_o_id() {
        return c_o_id;
    }

    public void setC_o_id(String c_o_id) {
        this.c_o_id = c_o_id;
    }

    public int getC_count() {
        return c_count;
    }

    public void setC_count(int c_count) {
        this.c_count = c_count;
    }

    public int getC_state() {
        return c_state;
    }

    public void setC_state(int c_state) {
        this.c_state = c_state;
    }
}
