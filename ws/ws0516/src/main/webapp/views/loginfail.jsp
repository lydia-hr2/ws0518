<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Fail</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h3 {
            color: #333;
            font-size: 24px;
            margin-top: 0;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Login Fail</h3>
        <h3>아이디 또는 패스워드가 틀렸습니다</h3>
        <p><a href="/login">Login Page</a></p>
    </div>
</div>
</body>
</html>