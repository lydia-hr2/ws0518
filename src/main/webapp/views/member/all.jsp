<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">회원정보 관리</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">전체 회원정보입니다.</h6>
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
                        <th>회원번호</th>
                        <th>회원 ID</th>
                        <th>이름</th>
                        <th>등록일</th>
                        <th>Valid(1, 0)</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>회원번호</th>
                        <th>회원 ID</th>
                        <th>이름</th>
                        <th>등록일</th>
                        <th>Valid(1, 0)</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="obj" items="${mlist}">
                        <tr>
                            <td><a href="/member/detail?id=${obj.id}">${obj.id}</a></td>
                            <td>${obj.memberId}</td>
                            <td>${obj.name}</td>
                            <td><fmt:formatDate value="${obj.rdate}" pattern="yyyy-MM-dd"/></td>
                            <td>${obj.valid}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>