package com.nf147.ldl.shop.dao;

import java.util.List;

public interface TemplateDAO<T> {
    List<T> listAll();  //获得所有数据
    T getById(Object obj);  //条件查询
    List<T> getBysId(Object obj);
    List<T> getByName(Object obj);  //模糊查询
    boolean update(T model);  //修改
    boolean delete(Object obj);  //删除
    boolean add(T model);  //添加
}
