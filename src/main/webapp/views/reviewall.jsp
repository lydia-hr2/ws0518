<div class="container-fluid">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Reviews</h1>
    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
        For more information about DataTables, please visit the
        <a target="_blank" href="https://datatables.net">official DataTables documentation</a>.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Review List</h6>
            <form action="/reviewsearch"id="search_form" name="search_form" class="form-inline well">

                <div class="form-group">
                    <label class="control-label col-sm-2" for="itemId">Product:</label>
                    <div class="col-sm-10">
                        <input type="text" name="itemId" class="form-control" id="itemId" placeholder="Enter itemId"
                               value="${rs.itemId}"
                        >
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="rate">Rate: </label>
                    <div class="col-sm-10">
                        <input type="number" name="rate" class="form-control" id="rate" placeholder="Enter rate"
                               value="${rs.rate}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-2">
                        <button id="search_btn" type="submit" class="btn btn-info">Search</button>
                        <%--                        폼과 폼 사이를 할 땐 submit--%>
                    </div>
                </div>
            </form>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
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
                            <td>${obj.id}</td>
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
</div>
<!-- /.container-fluid -->
