package com.nf147.ldl.shop.dao;

import com.nf147.ldl.shop.entity.Type;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO implements TemplateDAO<Type>{


    @Override
    public List<Type> listAll() {
        String sql = "select * from `Type`";
        List<Type> list = new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while (rs.next()){
                    list.add(new Type(rs.getInt("t_id"),rs.getString("t_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Type getById(Object obj) {
        String sql = "select * from `type` where t_id = ?";
        ResultSet rs = DBUtil.executeQuery(sql,new Object[]{obj});
        Type type = null;
        try {
            if(rs.next()){
                type = new Type(rs.getInt("t_id"),rs.getString("t_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public List<Type> getBysId(Object obj) {
        return null;
    }

    @Override
    public List<Type> getByName(Object obj) {
        String sql = "select * from `Type` where `t_name` like '%"+obj+"%' ";
        List<Type> list = new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql);
        try {
            while (rs.next()){
                list.add(new Type(rs.getInt("t_id"),rs.getString("t_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public boolean update(Type model) {
        String sql = "update `Type` set `t_name`=? where `t_id`=? ";
        Object[] in = new Object[]{model.getT_name(),model.getT_id()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        String sql = "delete from `Type` where `t_id`=? ";
        if(DBUtil.executeUpdate(sql,new Object[]{obj})>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean add(Type model) {
        String sql = " insert into `Type`(t_name) values (?) ";
        if(DBUtil.executeUpdate(sql,new Object[]{model.getT_name()})>0){
            return true;
        }
        return false;
    }
}
