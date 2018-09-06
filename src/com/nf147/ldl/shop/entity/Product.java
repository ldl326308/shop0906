package com.nf147.ldl.shop.entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {
    	int p_id;    // 商品id
    	int p_t_id; //商品类型
        String p_name;   //商品名称
        BigDecimal p_price;  //商品价格
        String p_photo;   //图片路径
        int p_state;   //状态  0 上架 1 下架

    public Product() {
    }

    public Product(int p_id, int p_t_id, String p_name, BigDecimal p_price, String p_photo, int p_state) {
        this.p_id = p_id;
        this.p_t_id = p_t_id;
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

    public int getP_t_id() {
        return p_t_id;
    }

    public void setP_t_id(int p_t_id) {
        this.p_t_id = p_t_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public BigDecimal getP_price() {  return this.p_price; }

    public void setP_price(BigDecimal p_price) { this.p_price = p_price; }

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

//    public static void main(String[] args) {
//        //  int p_id, int p_t_id, String p_name, BigDecimal p_price, String p_photo, int p_state
//        Product p = new Product(1,1,"dsf",new BigDecimal(120.99),"dsfs",9);
//        System.out.println(p.getP_price());
////        BigDecimal t1 = new BigDecimal("3.00");
////        BigDecimal newt1 = BigDecimal.ZERO;
////        BigDecimal newt2 = BigDecimal.ZERO;
////        newt1 = newt1.add(t1.setScale(2, RoundingMode.FLOOR));
////        System.out.println(newt1);
////        System.out.println(newt2);
//    }

}
