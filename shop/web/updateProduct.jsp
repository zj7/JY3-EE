<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/25
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改商品信息</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <style>
        body{
            background-image: url("images/bg.jpg");
        }
        label{
            color: wheat;
        }

    </style>
</head>
<body>
    <form enctype="multipart/form-data" action="update.do" method="post">
        <div class="form-group">
            <input type="hidden" value="${product.pro_id}" name="pro_id">
            <label for="proName">商品名称</label>
            <input type="text" class="form-control" id="proName" placeholder="请输入新的商品名称" name="pro_name" value="${product.pro_name}">
        </div>
        <div class="form-group">
            <label for="proPrice">商品价格</label>
            <input type="number" class="form-control" id="proPrice" placeholder="请输入新的商品价格" min="1" max="999999" name="pro_price" value="${product.pro_price}">
        </div>
        <div class="form-group">
            <label for="exampleInputFile">选择文件</label>
            <input type="file" id="exampleInputFile" name="file1" value="${product.pro_image}">
            <p class="help-block">请选择要上传的图片</p>
        </div>
        <div class="form-group">
            <label for="proDes">商品详情</label>
            <br />
            <textarea id="proDes" placeholder="请输入新的商品详情" style="width: 100%" name="pro_des" ></textarea>
        </div>
        <div class="form-group">
            <label for="proStock">商品库存</label>
            <input type="number" class="form-control" id="proStock" placeholder="请输入新的商品库存" min="0" max="99999" name="pro_stock" value="${product.pro_stock}">
        </div>
        <div class="form-group">
            <label for="proDate">上架日期</label>
            <input type="date" class="form-control" id="proDate" placeholder="请输入新的上架日期" name="pro_date" value="${product.pro_date}">
        </div>
        <div class="form-group">
            <label for="proCategoryId">商品类别ID</label>
            <input type="number" class="form-control" id="proCategoryId" placeholder="请输入新的商品类别ID" min="1" max="999" name="pro_category_id" value="${product.pro_category_id}">
        </div>
        <div class="form-group">
            <label for="proFactory">生产厂家</label>
            <input type="text" class="form-control" id="proFactory" placeholder="请输入新的生产厂家" name="pro_factory" value="${product.pro_factory}">
        </div>
        <button type="submit" class="btn btn-default">确认修改</button>
    </form>
</body>
</html>
