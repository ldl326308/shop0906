package com.nf147.ldl.shop.dao;

import com.nf147.ldl.shop.entity.ShowOrder;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowOrderDAO {
    /**
     * 订单信息查询
     * */
    public List<ShowOrder> listAll(String c_id){
        String sql = "select * from `Product` p inner join `ShoppingCart` c on c.c_p_id = p.p_id inner join `Order` o on o.o_id = c.c_o_id inner join `Address` a on a.a_id = o.o_a_id where `c_id` in ("+c_id+")";
        List<ShowOrder> list = new ArrayList<>();
        ResultSet rs = DBUtil.executeQuery(sql);
        //String o_id, String p_name, BigDecimal p_price, int c_count,
        // BigDecimal price_num, Date o_time, String a_address
        try {
            while (rs.next()) {
                list.add(new ShowOrder(
                        rs.getString("o_id"),
                        rs.getString("p_name"),
                        rs.getBigDecimal("p_price"),
                        rs.getInt("c_count"),
                        rs.getTime("o_time"),
                        rs.getString("a_address")
                ));
            }
        }catch (SQLException e){
            e.getMessage();
        }
        return list;
    }
}
