<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Error</title>
  <style>
    body {
      background-color: #f8f9fa;
      padding-top: 40px;
      font-family: Arial, sans-serif;
    }
    .error-container {
      max-width: 700px;
      margin: 0 auto;
      background-color: #ffffff;
      border: 1px solid #ccc;
      border-radius: 4px;
      padding: 20px;
      text-align: center;
    }
    .error-container h1 {
      font-size: 30px;
      margin-bottom: 20px;
      color: #cc0000;
    }
    .error-container h3 {
      font-size: 18px;
      margin-bottom: 10px;
      color: #cc0000;
    }
    .error-container hr {
      margin-top: 20px;
      margin-bottom: 20px;
      border: 0;
      border-top: 1px solid #ccc;
    }
  </style>
</head>
<body>
<div class="error-container">
  <h1>오류가 발생했습니다.</h1>
  <hr>
  <h3>${msg}</h3>
</div>
</body>
</html>
