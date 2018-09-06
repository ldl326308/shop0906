package com.nf147.ldl.shop.dao;

import com.nf147.ldl.shop.entity.User;
import util.DBUtil;

import javax.naming.event.ObjectChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements UserTemplateDAO<User> {
    @Override
    public List<User> listAll() {
        String sql = "select * from `User`";
        List<User> list = new ArrayList<User>();
        ResultSet rs = DBUtil.executeQuery(sql);
        //int u_id, String user_id, String user_pwd, String user_phone, String user_email
        try {
            while (rs.next()){
                list.add(new User(
                        rs.getInt("u_id"),
                        rs.getString("user_id"),
                        rs.getString("user_pwd"),
                        rs.getString("user_phone"),
                        rs.getString("user_email")
                ));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return list;
    }

    @Override
    public User getById(Object obj) {
        return null;
    }

    @Override
    public List<User> getBysId(Object obj) {
        return null;
    }

    @Override
    public List<User> getByName(Object obj) {
        return null;
    }

    @Override
    public boolean update(User model) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public User add(User model) {
        String sql = "insert into `User`(user_id,user_pwd,user_phone,user_email) values (?,?,?,?)";
        Object[] in = new Object[]{model.getUser_id(),model.getUser_pwd(),model.getUser_phone(),model.getUser_email()};
        if(DBUtil.executeUpdate(sql,in)>0){  //添加成功
            return isVerify(model.getUser_id(),model.getUser_pwd());  //返回刚刚注册的用户
        }
        return null;
    }

    @Override
    public User isVerify(String obj, String user_pwd) {
        String sql = "select * from `User` where `user_id`=? and `user_pwd` = ?  or `user_phone`=? and `user_pwd` = ?  or `user_email`=? and `user_pwd` = ? ";
        Object[] in = new Object[]{obj,user_pwd,obj,user_pwd,obj,user_pwd};
        ResultSet rs = DBUtil.executeQuery(sql,in);
        //int u_id, String user_id, String user_pwd, String user_phone, String user_email
        try {
            if(rs.next()){
                return  new User(
                        rs.getInt("u_id"),
                        rs.getString("user_id"),
                        rs.getString("user_pwd"),
                        rs.getString("user_phone"),
                        rs.getString("user_email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;  //不存在该用户
    }
}
