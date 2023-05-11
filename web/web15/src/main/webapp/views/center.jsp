<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--아래 태그 추가. 다국어 처리 위한 스프링 태그 라이브러리--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<style>
    #w2 {
        width: 500px;
        border: 2px solid blue;
    }
</style>


<script>
let center = {
init:function(){
$.ajax({
url:'/weather2',
success:function(data){
center.display(data);
}
});
}, display:function(data){
var result = data.response.body.items.item;
var txt = '';
$(result).each(function(index,item){
txt += '<h5>';
txt += item.tm+''+item.ta;
txt += '</h5>';
});
$('#w2').html(txt);
}
};
 $(function(){
 center.init();
 });

</script>

<%-- Main Center Start --%>
<div class="col-sm-8 text-left">
    <h1><spring:message code="site.title"/></h1>
    <h5><spring:message code="site.content"/> </h5>
    <hr>
    <textarea id="w1" cols="80" rows="10">${weatherinfo}</textarea>
    <hr>
    <div id="w2"></div>
</div>
<%-- Main Center End --%>