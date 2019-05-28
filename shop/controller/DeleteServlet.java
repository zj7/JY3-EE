package com.shop.controller;

import com.shop.dao.ProductDao;
import com.shop.dao.ProductDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete.do")
public class DeleteServlet extends HttpServlet {
    private ProductDao pd;

    @Override
    public void init() throws ServletException {
        pd = new ProductDaoImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pro_id = request.getParameter("pro_id");
        pd.deletePro(pro_id);
        request.getRequestDispatcher("main.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
