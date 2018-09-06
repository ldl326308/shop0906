package com.nf147.ldl.shop.dao;

import com.nf147.ldl.shop.entity.Order;

import java.util.List;

public class OrderDAO implements TemplateDAO<Order> {
    @Override
    public List<Order> listAll() {
        return null;
    }

    @Override
    public Order getById(Object obj) {
        return null;
    }

    @Override
    public List<Order> getBysId(Object obj) {
        return null;
    }

    @Override
    public List<Order> getByName(Object obj) {
        return null;
    }

    @Override
    public boolean update(Order model) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean add(Order model) {
        return false;
    }
}
