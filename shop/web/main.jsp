<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/25
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>睿乐购手机商城</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <style>
        body{
            background-image: url("images/bg.jpg");
        }

        h1{
            color: coral;
            display: inline-block;
        }
        h2{
            color: wheat;
            display: inline-block;
        }
        @-webkit-keyframes myfirst {
            0%{-webkit-transform: rotateY(0deg);}
            50%{-webkit-transform: rotateY(180deg);}
            100%{-webkit-transform: rotateY(360deg);}
        }
        #div02{
            animation: myfirst 3s infinite;
        }
        #dis{
            margin-left: 20px;
        }
    </style>
</head>
<body>
    <h1>睿乐购</h1><h2 id="dis">乐在</h2><h2><div id="div02">GO</div></h2><h2>中</h2>
    <div style="display: flex;width: 500px;height: 200px;align-items: start;justify-content: start;flex-direction: column">
        <a href="addProduct.jsp"><button type="button" class="btn btn-primary">添加商品</button></a>
        <a href="query.do"><button type="button" class="btn btn-primary">查询商品</button></a>
    </div>
</body>
</html>
