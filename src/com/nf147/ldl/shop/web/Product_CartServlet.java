package com.nf147.ldl.shop.web;

import com.google.gson.Gson;
import com.nf147.ldl.shop.dao.Product_CartDAO;
import com.nf147.ldl.shop.dao.ShoppingCartDAO;
import com.nf147.ldl.shop.dao.TemplateDAO;
import com.nf147.ldl.shop.entity.User;
import util.DBUtil;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/product_CartServlet")
public class Product_CartServlet extends HttpServlet {
    TemplateDAO dao = new Product_CartDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req,resp);
        String action = req.getParameter("action");
        User user = (User) req.getSession().getAttribute("user");
        if(action.equals("queryAll")) {
            resp.getWriter().print(new Gson().toJson(new Product_CartDAO().listAll(user.getU_id())));
        }else if(action.equals("price_num")){   //计算价格总和的数据
            String term = req.getParameter("condition");
            resp.getWriter().print(new Gson().toJson(new Product_CartDAO().num_price(term,user.getU_id())));
        }else if(action.equals("order")){  //请求要提交的订单信息
            String c_ids = String.valueOf(req.getSession().getAttribute("c_id"));
            resp.getWriter().print(new Gson().toJson(new Product_CartDAO().getC_idAll(c_ids)));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
