package com.nf147.ldl.shop.web;

import com.google.gson.Gson;
import com.nf147.ldl.shop.dao.ShowOrderDAO;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/showOrderServlet")
public class ShowOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req,resp);
        String action = req.getParameter("action");

        if(action.equals("query")){  //查询订单
            String o_id = String.valueOf(req.getSession().getAttribute("c_id"));//获得订单号
            resp.getWriter().print(new Gson().toJson(new ShowOrderDAO().listAll(o_id)));

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
