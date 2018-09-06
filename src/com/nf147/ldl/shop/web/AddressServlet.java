package com.nf147.ldl.shop.web;

import com.google.gson.Gson;
import com.nf147.ldl.shop.dao.AddressDAO;
import com.nf147.ldl.shop.dao.TemplateDAO;
import com.nf147.ldl.shop.entity.Address;
import com.nf147.ldl.shop.entity.User;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addressServlet")
public class AddressServlet extends HttpServlet {

    TemplateDAO dao = new AddressDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req, resp);
        String action = req.getParameter("action");
        User user = (User) req.getSession().getAttribute("user");
        if(action.equals("queryAll")){  //查询当前所有收货地址信息
            resp.getWriter().print(new Gson().toJson(new AddressDAO().listAll(user.getU_id())));
        }else if(action.equals("add")){
            int u_id = user.getU_id();
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            if(dao.add(new Address(u_id,name,phone,address))){
                resp.getWriter().print("{\"msg\":\"新增地址成功！\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"操作失败！\"}");
            }
        }else if(action.equals("all")){
            resp.getWriter().print(new Gson().toJson(dao.listAll()));
        }




    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
