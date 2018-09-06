package com.nf147.ldl.shop.dao;

import com.nf147.ldl.shop.entity.Product;
import com.nf147.ldl.shop.entity.Product_Cart;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Product_CartDAO implements TemplateDAO<Product_Cart> {
    @Override
    public List<Product_Cart> listAll()  {
        String sql = "select `c_id`,`p_name`,`p_price`,`p_photo`,`c_count` from `ShoppingCart` c inner join `Product` p on c.c_p_id = p.p_id";
        List<Product_Cart> list = new ArrayList<Product_Cart>();
        Product_Cart p = null;
        ResultSet rs = DBUtil.executeQuery(sql);
        //int c_id, String p_name, int c_count, BigDecimal p_price, String p_photo
        try{
            while (rs.next()){
                p = new Product_Cart(
                        rs.getInt("c_id"),
                        rs.getString("p_name"),
                        rs.getInt("c_count"),
                        rs.getBigDecimal("p_price"),
                        rs.getString("p_photo")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //通过点单号查询数据
    public List<Product_Cart> getC_idAll(String str){
        String sql = "select * from `Product` p inner join `ShoppingCart` c on p.p_id = c.c_p_id where `c_id` in ("+str+")";
        List<Product_Cart> list = new ArrayList<Product_Cart>();
        Product_Cart pro = null;
        ResultSet rs = DBUtil.executeQuery(sql);
        //   int c_id, String p_name, int c_count, BigDecimal p_price, String p_photo
        try {
            while (rs.next()){
                pro = new Product_Cart(
                        rs.getInt("c_id"),
                        rs.getString("p_name"),
                        rs.getInt("c_count"),
                        rs.getBigDecimal("p_price"),
                        rs.getString("p_photo")
                );
                list.add(pro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    //价格查询方法
    public List<Product_Cart> num_price(String str,int u_id){
        String sql = "select * from `Product` p inner join `ShoppingCart` c on p.p_id = c.c_p_id where `c_id` in ("+str+") and `c_u_id` =? ";
        List<Product_Cart> list = new ArrayList<Product_Cart>();
        Product_Cart pro = null;
        ResultSet rs = DBUtil.executeQuery(sql,new Object[]{u_id});
        //   int c_id, String p_name, int c_count, BigDecimal p_price, String p_photo
        try {
            while (rs.next()){
                 pro = new Product_Cart(
                        rs.getInt("c_id"),
                        rs.getString("p_name"),
                        rs.getInt("c_count"),
                        rs.getBigDecimal("p_price"),
                        rs.getString("p_photo")
                );
                 list.add(pro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public List<Product_Cart> listAll(int u_id)  {
        String sql = "select `c_id`,`p_name`,`p_price`,`p_photo`,`c_count` from `ShoppingCart` c inner join `Product` p on c.c_p_id = p.p_id where c_u_id = ? and `c_state`= 0 ";
        List<Product_Cart> list = new ArrayList<Product_Cart>();
        Product_Cart p = null;
        ResultSet rs = DBUtil.executeQuery(sql,new Object[]{u_id});
        //int c_id, String p_name, int c_count, BigDecimal p_price, String p_photo
        try{
            while (rs.next()){
                p = new Product_Cart(
                        rs.getInt("c_id"),
                        rs.getString("p_name"),
                        rs.getInt("c_count"),
                        rs.getBigDecimal("p_price"),
                        rs.getString("p_photo")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public Product_Cart getById(Object obj) {
        return null;
    }

    @Override
    public List<Product_Cart> getBysId(Object obj) {
        return null;
    }

    @Override
    public List<Product_Cart> getByName(Object obj) {
        return null;
    }

    @Override
    public boolean update(Product_Cart model) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean add(Product_Cart model) {
        return false;
    }

}
