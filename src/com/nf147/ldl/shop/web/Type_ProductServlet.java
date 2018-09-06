package com.nf147.ldl.shop.web;

import com.google.gson.Gson;
import com.nf147.ldl.shop.dao.TemplateDAO;
import com.nf147.ldl.shop.dao.Type_ProductDAO;
import com.nf147.ldl.shop.entity.Type_Product;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/type_productServlet")
public class Type_ProductServlet extends HttpServlet {
    TemplateDAO dao = new Type_ProductDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req,resp);
        String action = req.getParameter("action");

        if(action.equals("queryAll")){
            resp.getWriter().print(new Gson().toJson(dao.listAll()));
        }else if(action.equals("add")){
            //p_name,t_id,p_photo,p_price,p_state
            String p_name = req.getParameter("p_name");
            int t_id = Integer.parseInt(req.getParameter("t_id"));
            String p_photo = req.getParameter("p_photo");
            BigDecimal p_price = new BigDecimal(req.getParameter("p_price"));
            int p_state = Integer.parseInt(req.getParameter("p_state"));
            Type_Product type_product = new Type_Product(t_id, p_name,p_price,p_photo,p_state);
            if(dao.add(type_product)){
                resp.getWriter().print("{\"msg\":\"添加成功！\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"添加失败！\"}");
            }

        }else if(action.equals("info")){  //查询单个对象
            Object p_id = req.getParameter("p_id");
            resp.getWriter().print(new Gson().toJson(dao.getById(p_id)));

        }else if("upd".equals(action)){//修改
            int p_id = Integer.parseInt(req.getParameter("p_id"));
            String p_name =  req.getParameter("p_name");
            int t_id = Integer.parseInt(req.getParameter("t_id"));
            BigDecimal p_price = new BigDecimal(req.getParameter("p_price"));
            String p_photo = req.getParameter("p_photo");
            int p_state = Integer.parseInt(req.getParameter("p_state"));
            if(dao.update(new Type_Product(p_id,t_id,p_name,p_price,p_photo,p_state))){
                resp.getWriter().print("{\"msg\":\"修改成功！\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"修改失败！\"}");
            }

        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
