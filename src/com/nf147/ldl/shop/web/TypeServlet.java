package com.nf147.ldl.shop.web;

import com.google.gson.Gson;
import com.nf147.ldl.shop.dao.TemplateDAO;
import com.nf147.ldl.shop.dao.TypeDAO;
import com.nf147.ldl.shop.entity.Type;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/typeServlet")
public class TypeServlet extends HttpServlet {

    TemplateDAO dao = new TypeDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req, resp);  //设置编码格式
        String action = req.getParameter("action");

        if(action.equals("queryAll")){  //查询所有
            resp.getWriter().print(new Gson().toJson(dao.listAll()));
        }else if(action.equals("info")){  //获得单个对象
            Object t_id = req.getParameter("t_id");
            resp.getWriter().print(new Gson().toJson(dao.getById(t_id)));
        }else if(action.equals("upd")){  //修改
            Type type = new Type(Integer.parseInt(req.getParameter("t_id")),req.getParameter("t_name"));
            if(dao.update(type)){
                resp.getWriter().print("{\"msg\":\"修改成功！\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"修改失败！\"}");
            }

        }else if(action.equals("add")){
             String t_name = req.getParameter("t_name");
            if(dao.add(new Type(t_name))){
                resp.getWriter().print("{\"msg\":\"添加成功！\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"添加失败！\"}");
            }

        }else if(action.equals("del")){
            Object t_id = req.getParameter("t_id");
            if(dao.delete(t_id)){
                resp.getWriter().print("{\"msg\":\"删除成功！\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"删除失败！\"}");
            }

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
