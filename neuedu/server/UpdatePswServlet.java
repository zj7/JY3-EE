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

@WebServlet(name = "UpdatePswServlet",urlPatterns = "/UpdatePsw.do")
public class UpdatePswServlet extends HttpServlet {
    private UserDao ud;
    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String psw = request.getParameter("psw");
        String newPsw = request.getParameter("newPsw");
        User oneUser = new User();
        oneUser.setUsername(user);
        oneUser.setPassword(psw);
        if(true == ud.login(oneUser)){
            ud.updatePsw(oneUser, newPsw);
            request.getRequestDispatcher("UpdateSuccess.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("UpdatePsw.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
