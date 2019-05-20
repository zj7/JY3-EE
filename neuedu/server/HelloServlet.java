package com.neuedu.server;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet",urlPatterns = "/Hello.do")
public class HelloServlet extends HttpServlet {
    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String psw = req.getParameter("psw");
        ud.register(user,psw);
        //跳转到登录页面
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
