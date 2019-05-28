package com.shop.controller;

import com.shop.dao.UserDao;
import com.shop.dao.UserDaoImpl;
import com.shop.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {
    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Date date = new Date(new java.util.Date().getTime());
        ud.addUser(new User(username,password,date));
        //跳转到登录页面
        request.getRequestDispatcher("index.html").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
