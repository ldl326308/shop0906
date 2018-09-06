package com.nf147.ldl.shop.dao;

import com.nf147.ldl.shop.entity.Type_Product;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Type_ProductDAO implements  TemplateDAO<Type_Product> {


    @Override
    public List<Type_Product> listAll() {
        String sql = "select * from `Type` t inner join `Product` p on t.t_id = p.p_t_id";
        List<Type_Product> list = new ArrayList<Type_Product>();
        Type_Product type_product = null;
        ResultSet rs = DBUtil.executeQuery(sql);
        //   int p_id,int t_id, String t_name, String p_name, BigDecimal p_price, String p_photo, int p_state
        try {
            while (rs.next()) {
                type_product = new Type_Product(
                        rs.getInt("p_id"),
                        rs.getInt("t_id"),
                        rs.getString("t_name"),
                        rs.getString("p_name"),
                        rs.getBigDecimal("p_price"),
                        rs.getString("p_photo"),
                        rs.getInt("p_state")
                );
                list.add(type_product);
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    @Override
    public Type_Product getById(Object obj) {
        String sql = "select * from `Type` t inner join `Product` p on t.t_id = p.p_t_id where p.p_id = ? ";
        Object[] in = new Object[]{obj};
        Type_Product type_product = null;
        ResultSet rs = DBUtil.executeQuery(sql,in);
        try {
            if(rs.next()){
                type_product = new Type_Product(
                        rs.getInt("p_id"),
                        rs.getInt("t_id"),
                        rs.getString("t_name"),
                        rs.getString("p_name"),
                        rs.getBigDecimal("p_price"),
                        rs.getString("p_photo"),
                        rs.getInt("p_state")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type_product;
    }

    @Override
    public List<Type_Product> getBysId(Object obj) {
        return null;
    }

    @Override
    public List<Type_Product> getByName(Object obj) {
        return null;
    }

    @Override
    public boolean update(Type_Product model) {
        //int p_id,int t_id, String t_name, String p_name, BigDecimal p_price, String p_photo, int p_state
        String sql = "update `Product` set `p_name` =?,`p_t_id`=?,`p_price`=?,`p_photo`=?,`p_state`=? where p_id = ? ;";
        Object[] in = new Object[]{model.getP_name(),model.getT_id(),model.getP_price(),model.getP_photo(),model.getP_state(),model.getP_id()};
       if(DBUtil.executeUpdate(sql,in)>0){
           return true;
       }
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean add(Type_Product model) {
        String sql = "insert into `product`(p_t_id,p_name,p_price,p_photo,p_state) values (?,?,?,?,?);";
        Object[] in = new Object[]{model.getT_id(),model.getP_name(),model.getP_price(),model.getP_photo(),model.getP_state()};
        if(DBUtil.executeUpdate(sql,in)>0)
            return true;
        return false;
    }
}
