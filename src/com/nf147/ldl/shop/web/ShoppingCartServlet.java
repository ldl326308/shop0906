package com.nf147.ldl.shop.web;

import com.google.gson.Gson;
import com.nf147.ldl.shop.dao.ShoppingCartDAO;
import com.nf147.ldl.shop.dao.TemplateDAO;
import com.nf147.ldl.shop.entity.ShoppingCart;
import com.nf147.ldl.shop.entity.User;
import util.DBUtil;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verify/shoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {

    TemplateDAO dao = new ShoppingCartDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req,resp); //设置编码格式
        String action  = req.getParameter("action");
        User user =  (User)req.getSession().getAttribute("user");
        if(user == null){  //没有登入
            resp.getWriter().print("{\"msg\":\"false\"}");
        }
        else {
            if (action.equals("add")) {
                //int c_u_id,int c_p_id,int c_count
                int c_u_id = user.getU_id();   //获得登入用户id
                int c_p_id = Integer.parseInt(req.getParameter("c_p_id"));  //获得商品id
                int c_count = Integer.parseInt(req.getParameter("c_count"));   //获得商品数量
                if (dao.add(new ShoppingCart(c_u_id, c_p_id, c_count))) {    //加入购物车成功
                    resp.getWriter().print("{\"msg\":\"成功加入购物车！\"}");
                } else {
                    resp.getWriter().print("{\"msg\":\"加入购物车失败！\"}");
                }
            }else if(action.equals("getCount")){   //获得购物车数量
                    int c_u_id = ((User) req.getSession().getAttribute("user")).getU_id();
                    resp.getWriter().print("{\"count\":\""+new ShoppingCartDAO().getCartCount(c_u_id)+"\"}");
            }
            else if(action.equals("del")){  //删除购物项
                int c_id = Integer.parseInt(req.getParameter("c_id"));
                if(dao.delete(c_id)){
                    resp.getWriter().print("{\"msg\":\"删除成功！\"}");
                }else{
                    resp.getWriter().print("{\"msg\":\"删除失败！\"}");
                }
            }
            else if(action.equals("upd_count")){   //修改数量操作
                int c_id = Integer.parseInt(req.getParameter("c_id"));
                int count = Integer.parseInt(req.getParameter("count"));
                if(new ShoppingCartDAO().update(c_id,count)){
                    resp.getWriter().print("{\"msg\":\"true\"}");
                }else{
                    resp.getWriter().print("{\"msg\":\"false\"}");
                }
            }
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
