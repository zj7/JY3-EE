<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/27
  Time: 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有商品</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <style>
        body{
            background-image: url("images/bg.jpg");
        }
        table{
            color: sandybrown;
            text-align: center;
        }

    </style>
</head>
<body>
    <table border="1px" class="table table-hover">
        <thead>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品图片</th>
        <th>商品描述</th>
        <th>商品库存</th>
        <th>上架日期</th>
        <th>类别ID</th>
        <th>生产厂家</th>
        <th>操作</th>
        </thead>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.pro_id}</td>
                <td>${product.pro_name}</td>
                <td>${product.pro_price}</td>
                <td><img src="/imgs/${product.pro_image}" style="width: 80px;height: 90px"></td>
                <td>${product.pro_des}</td>
                <td>${product.pro_stock}</td>
                <td>${product.pro_date}</td>
                <td>${product.pro_category_id}</td>
                <td>${product.pro_factory}</td>
<%--                    pro_id=${product.pro_id}&pro_name=${product.pro_name}&pro_price=${product.pro_price}&pro_image=${product.pro_image}&pro_stock=${product.pro_stock}&pro_date=${product.pro_date}&pro_category_id=${product.pro_category_id}&pro_factory=${product.pro_factory}--%>
                <td><a href="updateProduct.jsp"><button type="button" class="btn btn-primary">修改</button></a>
                    <a href="delete.do?pro_id=${product.pro_id}"><button type="button" class="btn btn-danger">删除</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
