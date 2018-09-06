package com.nf147.ldl.shop.web;

import com.nf147.ldl.shop.entity.User;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/verifyLoginServlet")
public class VerifyLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req,resp);
        String action = req.getParameter("action");

        if(action.equals("verifyLogin")){
            User user = (User)req.getSession().getAttribute("user");
            if(user != null){
                resp.getWriter().print("{\"msg\":\"true\"}");
            }else{  //未登入
                resp.getWriter().print("{\"msg\":\"false\"}");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
