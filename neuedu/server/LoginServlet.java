package com.neuedu.server;


import com.neuedu.dao.LoginDao;
import com.neuedu.dao.LoginDaoImpl;
import com.neuedu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/Login.do")
public class LoginServlet extends HttpServlet {
    private LoginDao ld;
    @Override
    public void init() throws ServletException {
        ld = new LoginDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String psw = request.getParameter("psw");
        User oneUser = new User();
        oneUser.setUsername(user);
        oneUser.setPassword(psw);
//        System.out.println(ld.login(oneUser));
        if (true == ld.login(oneUser)){
            //跳转到登录成功页面
            request.getRequestDispatcher("loginSuccess.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
