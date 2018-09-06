package com.nf147.ldl.shop.web;

import com.google.gson.Gson;
import com.nf147.ldl.shop.dao.ProductDAO;
import com.nf147.ldl.shop.dao.Product_CartDAO;
import com.nf147.ldl.shop.dao.ShoppingCartDAO;
import com.nf147.ldl.shop.dao.TemplateDAO;
import util.DBUtilEncoded;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {

    TemplateDAO dao = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtilEncoded.setEncoded(req, resp);  //设置编码格式
        String action = req.getParameter("action");

        if(action.equals("queryAll")){  //查询所有
            String term = req.getParameter("term");
            if(term.equals("term")) {
                resp.getWriter().print(new Gson().toJson(dao.listAll()));
            }else{
                resp.getWriter().print(new Gson().toJson(dao.getByName(term)));
            }
        }else if(action.equals("queryByT_Id")){   //通过类型id查询
            resp.getWriter().print(new Gson().toJson(dao.getBysId(req.getParameter("p_t_id"))));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
