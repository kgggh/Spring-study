<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰등록 내역</title>
<style>
	
	h1{
		color: #215cb5;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		font-style: italic;
	}
	
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 0px solid black;
		margin: 0 auto;
		background-color: #215cb5;
		color : white;
		border-radius: 10px;
		width: 350px;
	
	}
	th { 
	font-size: 2em;
	font-style: italic;
	color: white;
	background-color: #215cb5;
	height: 50px;
	}
	#btt{
		border: 0px solid black;
		margin: 0 auto;
		background-color: #215cb5;
		color : white;
		border-radius: 10px;
		text-align: center;
		width: 300px;
	}
	#coupon{
		margin: 0 auto;
		align-items: center;
		justify-content: center;
	}
	#couponP{
	color: #215cb5;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	font-style: italic;
	text-align: center;
	font-size: 200%;
	}
	.noEvent{
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		font-style: italic;
		text-align: center;
		font-size: 170%;
	}
	.center{
	text-align:center;
	}
	.eventbutton{
	height: 30px;
    width: 100px;
    border: none;
    
    margin-right: 10px;
}
</style>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<script>

	function couponDel() {
		 location.href = "couponDelForm.do";
	}
	function eventList(){
		location.href = "event.do";
		}
	
</script>
</head>
<body>
<%@include file="common/menu.jspf" %>

	<p id="couponP">쿠폰 관리함</p>
	<div id="coupon">
	<c:if test="${empty coupon }">
		<p class="noEvent">쿠폰 등록 내역이 없습니다.</p>
	</c:if>
	<c:if test="${not empty coupon }">
		<c:forEach var="coupon" items="${coupon }">
	<a href="couponView.do?c_id=${coupon.c_id }">
	<table>
		<tr>
			<td>쿠폰번호 : ${coupon.c_id }</td>
		</tr>
		<tr>
			<td>쿠폰명 : ${coupon.c_name }</td>
		</tr>
		<tr>
			<c:choose>
			    <c:when test="${coupon.c_classification == 1}">
						<td>적용업종 : 한식</td>
			    </c:when>
			    <c:when test="${coupon.c_classification == 2}">
						<td>적용업종 : 중식</td>
			    </c:when>
			    <c:otherwise>
			        <td>적용 업종 : 일식<td>
			    </c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<td>할인금액 : ${coupon.c_salesprice }원</td>
		</tr>
		<tr>
			<td>유효일자 : ${coupon.c_period } ~  ${coupon.c_endperiod }</td>
		</tr>
	</table>
	</a>
	<br><br>
		</c:forEach>
	</c:if>
	</div>
<div class="center">
	<input type="button" value="목록" class="eventbutton" onclick="eventList()">

</div>
<%@include file="common/footer.jspf" %>
</body>
</html>





