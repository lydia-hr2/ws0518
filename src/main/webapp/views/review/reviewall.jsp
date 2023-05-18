<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">후기 관리</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">회원들의 후기 게시판 관리페이지입니다.</h6>
        </div>
        <div class="card-body">
            <table id="datatablesSimple">
                <thead>
                <tr>
                    <th>no.</th>
                    <th>Writer</th>
                    <th>Product</th>
                    <th>Title</th>
                    <th>Review</th>
                    <th>Rate</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>no.</th>
                    <th>Writer</th>
                    <th>Product</th>
                    <th>Title</th>
                    <th>Review</th>
                    <th>Rate</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="obj" items="${reviewlist}">
                    <tr>
                        <td><a href="/review/detail?id=${obj.id}">${obj.id}</a></td>
                        <td>${obj.userId}</td>
                        <td>${obj.itemId}</td>
                        <td>${obj.title}</td>
                        <td>${obj.review}</td>
                        <td>${obj.rate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>

</script>