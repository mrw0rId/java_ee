<%--
  Created by IntelliJ IDEA.
  User: mrw0r
  Date: 10.11.2020
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"/>
    <style>
        <%@include file="/style.css"%>
    </style>
</head>
<body>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/first_java_ee_webapp/style.css"/>
    <c:url value="http://localhost:8080/first_java_ee_webapp/home" var="homeUrl"/>
    <c:url value="http://localhost:8080/first_java_ee_webapp/catalog" var="catalogUrl"/>
    <c:url value="http://localhost:8080/first_java_ee_webapp/product" var="productUrl"/>
    <c:url value="http://localhost:8080/first_java_ee_webapp/cart" var="cartUrl"/>
    <c:url value="http://localhost:8080/first_java_ee_webapp/orders" var="ordersUrl"/>
    <ul>
        <li><a href="${homeUrl}">Home</a></li>
        <li><a href="${catalogUrl}">Catalog</a></li>
        <li><a href="${productUrl}">Product</a></li>
        <li><a href="${cartUrl}">Cart</a></li>
        <li><a href="${ordersUrl}">Orders</a></li>
    </ul>
</body>
</html>
