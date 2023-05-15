<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Sign In</h4>
                        <div class="breadcrumb__links">
                            <a href="/">Home</a>
                            <span>Sign In</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            <div class="checkout__form">
                <form action="#">
                    <div class="row">
                        <div class="col-lg-8 col-md-10">
                            <h6 class="coupon__code"><span class="icon_tag_alt"></span> Have no ID? <a href="#">Click
                            here</a> to join us</h6>
                            <h6 class="checkout__title">Register Form</h6>
                            <form id="register_form" name="register_form" enctype="multipart/form-data" action="/signinimpl" method="POST">
                            <div class="row">
                                <div class="col-lg-10">
                                    <div class="checkout__input" >
                                        <p>Email<span>*</span></p>
                                        <input type="text" id="email" name="email">
                                    </div>
                                    <div class="checkout__input" >
                                        <p>Account Password<span>*</span></p>
                                        <input type="text" id="password" name="password">
                                    </div>
                                    <div class="checkout__input" >
                                        <p>Name<span>*</span></p>
                                        <input type="text" id="name" name="name">
                                    </div>
<%--                                    <div class="checkout__input" id="address" name="address">--%>
<%--                                        <p>Address<span>*</span></p>--%>
<%--                                        <input type="text" placeholder="Street Address" class="checkout__input__add">--%>
<%--                                        <input type="text" placeholder="Apartment, suite, unite ect (optinal)">--%>
<%--                                    </div>--%>
                                    <div class="checkout__input" >
                                        <p>Tel<span>*</span></p>
                                        <input type="text" id="tel" name="tel">
                                    </div>
                                    <div class="checkout__input" >
                                        <p>Birth Date<span>*</span></p>
                                        <input type="text" id="birth" name="birth">
                                    </div>
                                </div>
                            </div>
                                <div class="checkout__input__checkbox">
                                    <button type="submit" class="btn btn-primary" id="signin_btn">Sign In</button>
                                </div>
                            </form>


                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->