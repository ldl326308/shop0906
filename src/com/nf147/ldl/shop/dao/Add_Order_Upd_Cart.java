package com.nf147.ldl.shop.dao;

import util.DBUtil;

import java.util.UUID;

public class Add_Order_Upd_Cart {
    /**
     *   订单编号  地址 *修改购物车中购物项的状态（c_state 1） 购物车订单号的关联
     * */
    public boolean addOrderUpdCart(int a_id,Object c_id){
        String[] c_ids = c_id.toString().split(",");

        //  String UUID.randomUUID(),int a_id,String c_id
        //修改状态  update `ShoppingCart` set `c_state` = 1 where `c_id` in (1,2,3);
        // 1、生成订单 一个商品一个订单
        boolean bool = false;


        for (int i = 0; i < c_ids.length; i++) {
            int cid = Integer.parseInt(c_ids[i]);  //当前商品的c_id
            String o_id = UUID.randomUUID().toString(); //生成一个订单号
            String sqlOrder = "insert into `Order`(o_id,o_a_id) values(?,?)";
            Object[] inOrder = new Object[]{o_id,a_id};
            if(DBUtil.executeUpdate(sqlOrder,inOrder)>0){  //添加订单成功
                bool = true;
            }else{  //添加订单失败，直接返回 false 不需要再继续执行以下操作
                return false;
            }

            //2、修改状态 关联订单编号
            String sqlUpdState = "update `ShoppingCart` set `c_state` = ?,`c_o_id`=? where `c_id`=? ;";
            Object[] inUpdState = new Object[]{1,o_id,cid};
            if(DBUtil.executeUpdate(sqlUpdState,inUpdState)>0){   //修改状态成功
                bool = true;
            }else{
                return false;
            }
        }
        return bool;
    }
}
