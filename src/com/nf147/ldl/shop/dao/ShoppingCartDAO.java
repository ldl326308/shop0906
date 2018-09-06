package com.nf147.ldl.shop.dao;

import com.nf147.ldl.shop.entity.Product_Cart;
import com.nf147.ldl.shop.entity.ShoppingCart;
import util.DBUtil;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO implements TemplateDAO<ShoppingCart> {
    @Override
    public List<ShoppingCart> listAll() {
        return null;
    }

    @Override
    public ShoppingCart getById(Object obj) {
        return null;
    }

    @Override
    public List<ShoppingCart> getBysId(Object obj) {
        return null;
    }

    @Override
    public List<ShoppingCart> getByName(Object obj) {
        return null;
    }

    @Override
    public boolean update(ShoppingCart model) {
        return false;
    }

    //数量修改
    public boolean update(int c_id,int count){
        String sql = "update `ShoppingCart` set `c_count` = ? where `c_id` = ? ";
        Object[] in = new Object[]{count,c_id};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        String sql = "delete from `ShoppingCart` where `c_id` = ? ";
        Object[] in =  new Object[]{obj};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(ShoppingCart model) {  //购物车购物项添加
        //判断购物车是否存在该商品,存在则修改数量即可
        //int c_u_id,int c_p_id,int c_count
        String sqlIs = "select * from `ShoppingCart` s inner join `Product` p on s.c_p_id = p.p_id   where `c_p_id` =? and `c_u_id`=? and `c_state` = 0 ";
        ResultSet rs = DBUtil.executeQuery(sqlIs,new Object[]{model.getC_p_id(),model.getC_u_id()});
        int count = -1;
        try {
            if(rs.next()){  //存在该商品记录，获得数量、单价
                count = rs.getInt("c_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //如果c_count 为 -1 则说明没有改商品记录，进行添加操作
        if(count == -1){
            String sql = "insert into `ShoppingCart`(c_u_id,c_p_id,c_count) values(?,?,?)";
            if(DBUtil.executeUpdate(sql,new Object[]{model.getC_u_id(),model.getC_p_id(),1})>0){  //添加成功
                return true;
            }else{
                return false;
            }
        }
        else{  //如果不为-1则有改商品记录，进行修改操作
            String sql = "update `ShoppingCart` set `c_count`= ? where `c_u_id` = ?  and  `c_p_id` = ? ";
            count = model.getC_count()+count;
            Object[] in = new Object[]{count,model.getC_u_id(),model.getC_p_id()};
            if(DBUtil.executeUpdate(sql,in)>0){
                return true;
            }else{
                return false;
            }

        }
    }

    public int getCartCount(int c_u_id){
        String sql = "select sum(`c_count`) from `ShoppingCart` where `c_u_id` = ?  and  `c_state` = 0;";
        ResultSet rs = DBUtil.executeQuery(sql,new Object[]{c_u_id});
        int count = 0;
        try {
            if(rs.next()){  //获得数据
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
