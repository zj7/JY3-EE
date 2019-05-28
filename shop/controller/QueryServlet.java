package com.shop.controller;

import com.shop.dao.ProductDao;
import com.shop.dao.ProductDaoImpl;
import com.shop.pojo.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryServlet",urlPatterns = "/query.do")
public class QueryServlet extends HttpServlet {

    private ProductDao pd;

    @Override
    public void init() throws ServletException {
        pd = new ProductDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> allProducts = pd.getAllProducts();
        request.setAttribute("products",allProducts);
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
}
