<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let member_add={
        init: function(){
            $('#register_btn').click(function(){
                member_add.send();
            });
        },
        send: function(){
            $('#register_form').attr({
                method:'post',
                action:'/member/addimpl'
            });
            $('#register_form').submit();
        }
    };
    $(function (){
        member_add.init();
    });
</script>

    <div class="container-fluid">

        <!-- Page Heading -->
        <h1 class="h3 mb-2 text-gray-800">회원 등록</h1>

        <!-- DataTales Example -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">회원을 등록하는 페이지입니다.</h6>
            </div>
            <div class="card-body">
                    <form id="register_form" class="form-horizontal well">
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="memberId">회원 ID::</label>
                            <div class="col-sm-10">
                                <input type="text" name="memberId" class="form-control" id="memberId" placeholder="Enter member_id">
                            </div>
                            <div class="col-sm-10">
                                <span id="check_id" class="bg-danger"></span>
                            </div>
                        </div><br>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="password">Password:</label>
                            <div class="col-sm-10">
                                <input type="password" name="password" class="form-control" id="password" placeholder="Enter password">
                            </div>
                        </div><br>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="name">회원명:</label>
                            <div class="col-sm-10">
                                <input type="text" name="name" class="form-control" id="name" placeholder="Enter name">
                            </div>
                        </div><br>
                        <div class="form-group">
                            <label class="control-label col-sm-2" for="valid">Valid:</label>
                            <div class="col-sm-10">
                                <input type="text" name="valid" class="form-control" id="valid" placeholder="Enter 1 or 0">
                            </div>
                        </div><br>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button class="btn btn-sm btn-primary btn-login fw-bold text-uppercase" id="register_btn" type="button" class="btn btn-default">Register</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container-fluid -->
</div>