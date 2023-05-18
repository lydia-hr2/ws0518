<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<main>
    <div class="container-fluid px-4">
        <h1 class="mt-4">Dashboard</h1>
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item active">Male Fashion 관리자 화면입니다.</li>
        </ol>
        <div class="row">
            <div class="col-xl-6">
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-chart-area me-1"></i>
                        Cart Chart (Live)
                    </div>
                    <div class="card-body">
                        <div id="container"></div>
                        <div class="ld-row">
                            <input type="hidden" checked="checked" id="enablePolling"/>
                        </div>
                        <div class="ld-row">
                            <input class="ld-time-input" type="hidden" value="2" id="pollingTime"/>
                        </div>
                        <div class="ld-row">
                            <input class="ld-url-input" type="hidden" id="fetchURL"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6">
                <div class="card mb-4">
                    <div class="card-header">
                        <i class="fas fa-chart-bar me-1"></i>
                        Monthly Sales (Live)
                    </div>
                    <div class="card-body"><canvas id="myBarChart" width="100%" height="40"></canvas></div>
                </div>
            </div>
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
</main>

<script>
    let sumcartchart = {
        init:function (){
            var defaultData = '${adminserver}/logs/sumcart.log';
            var urlInput = document.getElementById('fetchURL');
            var pollingCheckbox = document.getElementById('enablePolling');
            var pollingInput = document.getElementById('pollingTime');

            function createChart() {
                Highcharts.chart('container', {
                    chart: {
                        type: 'spline'
                    },
                    title: {
                        text: ''
                    },
                    accessibility: {
                        announceNewData: {
                            enabled: true,
                            minAnnounceInterval: 15000,
                            announcementFormatter: function (allSeries, newSeries, newPoint) {
                                if (newPoint) {
                                    return 'New data point added.';
                                }
                                return false;
                            }
                        }
                    },
                    data: {
                        csvURL: urlInput.value,
                        enablePolling: pollingCheckbox.checked === true,
                        dataRefreshRate: parseInt(pollingInput.value, 10)
                    },
                    legend: {
                        enabled: false
                    },
                    yAxis: {
                        title: {
                            text: '총금액(원)'
                        }
                    },
                    xAxis: {
                        title: {
                            text: '실시간 장바구니 현황'
                        }
                    }
                });
                if (pollingInput.value < 1 || !pollingInput.value) {
                    pollingInput.value = 1;
                }
            }
            urlInput.value = defaultData;
            pollingCheckbox.onchange = urlInput.onchange = pollingInput.onchange = createChart;
            createChart();
        }
    };

    $(function (){
        sumcartchart.init();
    })

</script>