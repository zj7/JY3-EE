package com.shop.controller;

import com.shop.dao.ProductDao;
import com.shop.dao.ProductDaoImpl;
import com.shop.pojo.Product;
import com.shop.util.ProUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "AddProductServlet",urlPatterns = "/add.do")
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    private ProductDao pd;
    @Override
    public void init() throws ServletException {
        pd = new ProductDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String proName = request.getParameter("proName");
        String proPrice = request.getParameter("proPrice");
        //拿到图片
        Part file1 = request.getPart("file1");
        String fileName = ProUtils.getFileName(file1);
        String proDes = request.getParameter("proDes");
        String proStock = request.getParameter("proStock");
        String proDate = request.getParameter("proDate");
        String proCategoryId = request.getParameter("pro_category_id");
        String proFactory = request.getParameter("pro_factory");

        Product product = new Product(ProUtils.getId(),proName,Double.parseDouble(proPrice),fileName,proDes,Short.parseShort(proStock),ProUtils.converseStringToDate(proDate),Short.parseShort(proCategoryId),proFactory);
        pd.addPro(product);
        response.sendRedirect("main.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
