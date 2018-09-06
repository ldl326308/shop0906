package com.nf147.ldl.shop.entity;

import java.math.BigDecimal;
import java.util.Date;

//订单信息显示
public class ShowOrder {
    String o_id;  //订单号
    String p_name;  //商品名称
    BigDecimal p_price; // 商品单价
    int c_count;  //数量
    Date o_time;  //下单时间
    String a_address; //收货地址

    public ShowOrder() {
    }

    public ShowOrder(String o_id, String p_name, BigDecimal p_price, int c_count, Date o_time, String a_address) {
        this.o_id = o_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.c_count = c_count;
        this.o_time = o_time;
        this.a_address = a_address;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
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

    public int getC_count() {
        return c_count;
    }

    public void setC_count(int c_count) {
        this.c_count = c_count;
    }

    public Date getO_time() {
        return o_time;
    }

    public void setO_time(Date o_time) {
        this.o_time = o_time;
    }

    public String getA_address() {
        return a_address;
    }

    public void setA_address(String a_address) {
        this.a_address = a_address;
    }


    @Override
    public String toString() {
        return "ShowOrder{" +
                "o_id='" + o_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", p_price=" + p_price +
                ", c_count=" + c_count +
                ", o_time=" + o_time +
                ", a_address='" + a_address + '\'' +
                '}';
    }
}
