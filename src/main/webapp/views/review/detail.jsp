<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    let review_detail={
        init: function(){
            $('#delete_btn').click(function(){
                var c = confirm("삭제 하시겠습니까?");   //confirm창 호출
                if(c == true){
                    location.href="/review/deleteimpl?id=${reviewinfo.id}";
                }
            });
        }
    };
    $(function (){
        review_detail.init();
    });
</script>

<div class="container">
    <div class="row">
        <table class="table table-striped" style="text-align: left; border: 1px solid #dddddd">
            <thead>
            <tr>
                <th colspan="3" style="background-color: #eeeeee; text-align: center;">게시판 글보기</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>리뷰 번호</td>
                <td colspan="2">${reviewinfo.id}</td>
            </tr>
            <tr>
                <td>작성자 회원번호</td>
                <td colspan="2">${reviewinfo.userId}</td>
            </tr>
            <tr>
                <td style="width: 20%;">글제목</td>
                <td colspan="2">${reviewinfo.title}</td>
            </tr>
            <tr>
                <td>작성일자</td>
                <td colspan="1">${reviewinfo.rate}</td>
            </tr>
            <tr>
                <td>내용</td>
                <td colspan="2" style="min-height: 200px; text-align: left;">${reviewinfo.review}</td>
            </tr>
            </tbody>
        </table>
        <div class="form-group" style="text-align: right;">
            <button class="btn btn-sm btn-primary btn-login fw-bold text-uppercase" id="delete_btn" type="button" class="btn btn-default">Delete</button>
        </div>
    </div>
</div>
