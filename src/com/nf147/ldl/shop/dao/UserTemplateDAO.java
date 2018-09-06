package com.nf147.ldl.shop.dao;

import java.util.List;

public interface UserTemplateDAO<T> {
    List<T> listAll();  //获得所有数据
    T getById(Object obj);  //条件查询
    List<T> getBysId(Object obj);
    List<T> getByName(Object obj);  //模糊查询
    boolean update(T model);  //修改
    boolean delete(Object obj);  //删除
    T add(T model);  //添加
    T isVerify(String obj,String user_pwd);  //用户验证
}
