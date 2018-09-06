package com.nf147.ldl.shop.entity;

import java.util.Date;

public class Order {
	String o_id;    //订单id  #UUID 生成
    String o_a_id;   //收货地址id
    Date o_time;  //订单时间

    public Order() {
    }

    public Order(String o_id, String o_a_id) {
        this.o_id = o_id;
        this.o_a_id = o_a_id;
    }

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getO_a_id() {
        return o_a_id;
    }

    public void setO_a_id(String o_a_id) {
        this.o_a_id = o_a_id;
    }

    public Date getO_time() {
        return o_time;
    }

    public void setO_time(Date o_time) {
        this.o_time = o_time;
    }
}
