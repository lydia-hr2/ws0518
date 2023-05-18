<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">상품정보 관리</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">전체 상품정보입니다.</h6>
        </div>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                상품목록
            </div>
            <div class="card-body">
                <table id="datatablesSimple">
                    <thead>
                    <tr>
                        <th>상품ID</th>
                        <th>상품명</th>
                        <th>가격</th>
                        <th>상품 사이즈</th>
                        <th>색깔</th>
                        <th>상품 등록일시</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>상품ID</th>
                        <th>상품명</th>
                        <th>가격</th>
                        <th>상품 사이즈</th>
                        <th>색깔</th>
                        <th>상품 등록일시</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td><a href="/item/${item.id}">${item.id}</a></td>
                            <td>${item.name}</td>
                            <td>${item.price}</td>
                            <td>${item.itemSize}</td>
                            <td>${item.color}</td>
                            <td>${item.rdate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>