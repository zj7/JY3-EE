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
import java.util.List;

@WebServlet(name = "QueryAllServlet",urlPatterns = "/queryAll.do")
public class QueryAllServlet extends HttpServlet {
    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = ud.queryAll();
        request.setAttribute("username",users);
//        request.setAttribute("password",users);
        request.getRequestDispatcher("allMsg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
