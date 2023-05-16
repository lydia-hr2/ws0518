<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let register_form={
        init:function (){
            $('#register_btn').click(function(){
                register_form.send();
            });
        },
        send:function (){
            $('#register_form').attr({
                'action':'/registerimpl',      //MainController에 보내는 Action
                'method':'post'
            });
            $('#register_form').submit();
        }
    };  // 아이디체크 기능은 뺀 상태
    $(function (){
        register_form.init();
    });
</script>

<main>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-7">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                    <div class="card-body">
                        <form id="register_form">
                            <div class="form-group">
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="adminId" id="adminId" type="text"
                                                   placeholder="Create a adminId"/>
                                            <label for="adminId">관리자 ID:</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="pwd" id="pwd" type="password"
                                                   placeholder="Create a password"/>
                                            <label for="pwd">Password:</label>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" id="inputPasswordConfirm" type="password"
                                                   placeholder="Confirm password"/>
                                            <label for="inputPasswordConfirm">Confirm Password:</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="row mb-3">
                                    <div class="col-md-6">
                                        <div class="form-floating mb-3 mb-md-0">
                                            <input class="form-control" name="lev" id="lev" type="text"
                                                   placeholder="Input lev (1~5)"/>
                                            <label for="lev">Level:</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="d-flex justify-content-end mt-4 mb-0">
                                    <button id="register_btn" class="btn btn-primary">Register</button>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="card-footer text-center py-3">
                        <div class="small"><a href="login">Have an account? Go to login</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

