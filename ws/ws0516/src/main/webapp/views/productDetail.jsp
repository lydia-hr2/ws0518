<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="container">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <form id="register_form">
            <div class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
                <input class="card-img-left d-none d-md-flex" type="file" name="imgName" style="display: none" id="preview">
                <div class="card-body p-4 p-sm-5">
                    <h5 class="card-title text-center mb-5 fw-light fs-5">상품 등록</h5>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="name" id="floatingInputUsername"  value="${item.name}" placeholder="myusername" required autofocus>
                            <label for="floatingInputUsername">상품명</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="number" class="form-control" name="price" id="floatingInputEmail" value="${item.price}" placeholder="name@example.com">
                            <label for="floatingInputEmail">상품가격</label>
                        </div>
                    <select name="color" class="form-select mb-3" aria-label="Default select example">
                        <option selected>상품색</option>
                        <option value="red">RED</option>
                        <option value="blue">BLUE</option>
                        <option value="green">GREEN</option>
                    </select>

                    <select name="itemSize" class="form-select mb-3" aria-label="Default select example">
                        <option selected>사이즈</option>
                        <option value="L">L</option>
                        <option value="M">M</option>
                        <option value="S">S</option>
                    </select>

                        <div class="d-grid mb-2">
                            <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="button" id="register_btn">상품 등록</button>
                        </div>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>