package com.nf147.ldl.shop.web;

import com.google.gson.Gson;
import com.nf147.ldl.shop.dao.UserDAO;
import com.nf147.ldl.shop.dao.UserTemplateDAO;
import com.nf147.ldl.shop.entity.User;
import util.DBUtil;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    UserTemplateDAO dao = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req,resp);
        String action = req.getParameter("action");
        if(action.equals("verify")){  //用户验证
            String user_id = req.getParameter("user_id");
            String user_pwd = req.getParameter("user_pwd");
            User user = (User) dao.isVerify(user_id,user_pwd);
            if(user!=null){  //验证成功
                req.getSession().setAttribute("user",user);//保存用户细信息
                resp.getWriter().print("{\"msg\":\""+user.getUser_id()+"已登入\"}");
            }else{  //验证失败
                resp.getWriter().print("{\"msg\":\"登入失败！\"}");
            }
        }else if(action.equals("register")){  //用户注册
            String user_id  = req.getParameter("user_id");
            String user_pwd = req.getParameter("user_pwd");
            String user_phone =  req.getParameter("user_phone");
            String user_email = req.getParameter("user_email");

            User user = (User) dao.add(new User(user_id,user_pwd,user_phone,user_email));
            if(user!=null){  //成功注册
                req.getSession().setAttribute("user",user);
                resp.getWriter().print("{\"msg\":\""+user.getUser_id()+"已登入\"}");
            }else{   //注册失败
                resp.getWriter().print("{\"msg\":\"注册失败！\"}");
            }
        }else if(action.equals("select")){  //获得用户的信息
            User user = (User)req.getSession().getAttribute("user");
            if(user != null){
                resp.getWriter().print("{\"msg\":\""+user.getUser_id()+"已登入\"}");
            }else{
                resp.getWriter().print("{\"msg\":\"false\"}");
            }
        }else if(action.equals("queryAll")){   //查询所有用户
            resp.getWriter().print(new Gson().toJson(dao.listAll()));
        }


    }
}
