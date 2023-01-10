<%--
  Created by IntelliJ IDEA.
  User: batur
  Date: 9.01.2023
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%--taglib--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="js/login.js"></script>
    <title>Register</title>
</head>

<body>
<div class="container mt-5">
    <h1>Login</h1>
    <form id="login" method="post">
        <div class="form-group">
            <label for="email">E-posta</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="E-posta adresinizi girin">
        </div>
        <div class="form-group">
            <label for="password">Şifre</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Şifrenizi girin">
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
    </form>
</div>
</body>

</html>
