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

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username1 = request.getParameter("username1");
        String password1 = request.getParameter("password1");
        User oneUser = new User(username1,password1);
        if (true == ud.login(oneUser)){
            request.getRequestDispatcher("main.jsp").forward(request,response);
        }
//        else{
//            request.getRequestDispatcher("index.html").forward(request,response);
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
