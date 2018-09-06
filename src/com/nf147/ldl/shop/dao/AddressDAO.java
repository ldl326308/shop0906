package com.nf147.ldl.shop.dao;

import com.nf147.ldl.shop.entity.Address;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements TemplateDAO<Address> {

    @Override
    public List<Address> listAll() {
        String sql = "select * from `Address`";
        ResultSet rs = DBUtil.executeQuery(sql);
        List<Address> list = new ArrayList<Address>();
        // int a_id, int a_u_id, String a_name, String a_phone, String a_address
        try {
            while (rs.next()) {
                    list.add(
                       new Address(
                            rs.getInt("a_id"),
                            rs.getInt("a_u_id"),
                            rs.getString("a_name"),
                            rs.getString("a_phone"),
                            rs.getString("a_address")
                       )
                    );
            }
        }catch (SQLException e){
            e.getMessage();
        }

        return list;
    }

    public List<Address> listAll(int u_id) {
        String sql = "select * from `Address` where `a_u_id`=? ";
        Object[] in = new Object[]{u_id};
        Address a = null;
        List<Address> list = new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql,in);
        //   int a_id, int a_u_id, String a_name, String a_phone, String a_address
        try {
            while (rs.next()) {
                a = new Address(
                        rs.getInt("a_id"),
                        rs.getInt("a_u_id"),
                        rs.getString("a_name"),
                        rs.getString("a_phone"),
                        rs.getString("a_address")
                );
                list.add(a);
            }
        }catch(SQLException e){
            e.getSuppressed();
        }
        return list;
    }

    @Override
    public Address getById(Object obj) {
        return null;
    }

    @Override
    public List<Address> getBysId(Object obj) {
        return null;
    }

    @Override
    public List<Address> getByName(Object obj) {
        return null;
    }

    @Override
    public boolean update(Address model) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean add(Address model) {
        String sql = "insert into `Address`(a_u_id,a_name,a_phone,a_address) values(?,?,?,?)";
        Object[] in = new Object[]{model.getA_u_id(),model.getA_name(),model.getA_phone(),model.getA_address()};
        if(DBUtil.executeUpdate(sql,in)>0){
            return true;
        }
        return false;
    }
}
