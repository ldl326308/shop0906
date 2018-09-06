package com.nf147.ldl.shop.dao;

import com.nf147.ldl.shop.entity.Product;
import util.DBUtil;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigDecimal.ROUND_DOWN;

public class ProductDAO implements TemplateDAO<Product> {
    @Override
    public List<Product> listAll() {
        String sql = "select * from `Product`where`p_state`=0 ";
        List<Product> list = new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while (rs.next()){
                list.add(new Product(
                      rs.getInt("p_id"),
                      rs.getInt("p_t_id"),
                      rs.getString("p_name"),
                      rs.getBigDecimal("p_price"),
                      rs.getString("p_photo"),
                      rs.getInt("p_state")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product getById(Object obj) {
        String sql = "select * from `Product` where `p_id` = ?";
        Object[] in = new Object[]{obj};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        Product product = null;
        //int p_id, int p_t_id, String p_name, BigDecimal p_price, String p_photo, int p_state
        try {
            if(rs.next()){
                product = new Product(
                        rs.getInt("p_id"),
                        rs.getInt("p_t_id"),
                        rs.getString("p_name"),
                        rs.getBigDecimal("p_price"),
                        rs.getString("p_photo"),
                        rs.getInt("p_state")
                );
            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //查类型id
    @Override
    public List<Product> getBysId(Object obj) {
        String sql = "select * from `Product` where `p_t_id`=? ";
        List<Product> list = new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql,new Object[]{obj});
        try {
            while (rs.next()){
                list.add(new Product(
                        rs.getInt("p_id"),
                        rs.getInt("p_t_id"),
                        rs.getString("p_name"),
                        rs.getBigDecimal("p_price"),
                        rs.getString("p_photo"),
                        rs.getInt("p_state")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> getByName(Object obj) {
        String sql = "select * from `Product` where `p_name` like '%"+obj+"%';";
        List<Product> list = new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while (rs.next()){
                list.add(new Product(
                        rs.getInt("p_id"),
                        rs.getInt("p_t_id"),
                        rs.getString("p_name"),
                        rs.getBigDecimal("p_price"),
                        rs.getString("p_photo"),
                        rs.getInt("p_state")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(Product model) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean add(Product model) {
        return false;
    }


}
