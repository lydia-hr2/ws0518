<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    function readImage(input) {
        // 인풋 태그에 파일이 있는 경우
        if(input.files && input.files[0]) {

            // FileReader 인스턴스 생성
            const reader = new FileReader()
            // 이미지가 로드가 된 경우
            reader.onload = e => {
                const previewImage = document.getElementById("preview")
                previewImage.src = e.target.result
            }
            // reader가 이미지 읽도록 하기
            reader.readAsDataURL(input.files[0])
        }
    }
    $(function () {
        $('#preview').attr("src", "https://cdn-mart.baemin.com/front-end/assets/20230512084027/images/defaultEmptyImage.11f8bc33139d72b546eb54f5b89e2abf.png");
        $('#imgname').on("change", e => {
            readImage(e.target)
        })
    });
</script>
<div class="container">
    <div class="row">
        <div class="col-lg-10 col-xl-9 mx-auto">
            <form id="register_form" enctype="multipart/form-data" method="post" action="/item/registerImpl">
            <div class="card flex-row my-5 border-0 shadow rounded-3 overflow-hidden">
                <input class="d-none mt-5 ml-5" type="file" name="imgName" style="display: none" id="imgname">
                <a href="javascript:void(0);" onclick="$('#imgname').trigger('click')">
                    <img src="/uimg/${item.img}" id="preview" style="height: 500px; width: 500px">
                </a>
                <div class="card-body p-4 p-sm-5">
                    <h5 class="card-title text-center mb-5 fw-light fs-5">상품 등록</h5>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="name" id="floatingInputUsername" placeholder="myusername" required autofocus>
                            <label for="floatingInputUsername">상품명</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="number" class="form-control" name="price" id="floatingInputEmail" placeholder="name@example.com">
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
                            <button class="btn btn-lg btn-primary btn-login fw-bold text-uppercase" type="submit" id="register_btn">상품 등록</button>
                        </div>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>