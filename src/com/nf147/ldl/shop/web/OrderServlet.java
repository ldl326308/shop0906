package com.nf147.ldl.shop.web;

import com.nf147.ldl.shop.dao.Add_Order_Upd_Cart;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req,resp);
        String action = req.getParameter("action");

        if(action.equals("storage")){
            String message = req.getParameter("message");  //保存到Session
            req.getSession().setAttribute("c_id",message); //c_id保存
            resp.getWriter().print("{\"msg\":\"true\"}");
        }else if(action.equals("add")){   //添加一个订单
            //订单编号  地址 *修改购物车中购物项的状态（c_state 1） 购物车订单号的关联
          // String UUID.randomUUID(),int a_id,String c_id
            int a_id = Integer.parseInt(req.getParameter("a_id"));
            Object c_id = req.getSession().getAttribute("c_id");
            Add_Order_Upd_Cart add = new Add_Order_Upd_Cart();
            if(add.addOrderUpdCart(a_id,c_id)){  //成功
                resp.getWriter().print("{\"msg\":\"订单提交成功！\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"订单提交失败！\"}");
            }

        }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
