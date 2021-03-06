package com.neuedu.server;


import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/Login.do")
public class LoginServlet extends HttpServlet {
    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String psw = request.getParameter("psw");
        User oneUser = new User();
        oneUser.setUsername(user);
        oneUser.setPassword(psw);
        if (true == ud.login(oneUser)){
            //跳转到登录成功页面
            request.getRequestDispatcher("loginSuccess.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
