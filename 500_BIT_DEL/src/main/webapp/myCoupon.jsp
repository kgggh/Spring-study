<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My 쿠폰함</title>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<style>
	
	h1{
		color: #215cb5;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 0px solid black;
		margin: 0 auto;
		background-color: #215cb5;
		color : white;
		border-radius: 10px;
		width: 200px;
	
	}
	th { 
	font-size: 2em;
	font-style: italic;
	color: white;
	background-color: #215cb5;
	height: 50px;
	}
	input{
		color: #215cb5;
		border: 0px;
		background-color: white;
		font-size: 140%;
		
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
</style>
<script>

	
</script>
</head>
<body>
<%@include file="common/login.jspf" %>
<%@include file="common/menu.jspf" %>

	<p id="couponP">My 쿠폰함</p>
	<div id="coupon">
	<c:if test="${empty couponbox }">
		<p class="noEvent">사용 가능한 쿠폰이 없습니다.</p>
	</c:if>
	<c:if test="${not empty couponbox }">
		<c:forEach var="couponbox" items="${couponbox }">
			<a href="myCouponView.do?c_id=${couponbox.c_id }">
			<table>
				<tr>
					<td>쿠폰번호 : ${couponbox.c_id }</td>
				</tr>
			<tr>
			<c:choose>
			    <c:when test="${couponbox.cb_coupon_use == 0}">
						<td>적용여부 : Y<td>
			    </c:when>
			    <c:when test="${couponbox.cb_coupon_use == 1}">
						<td>적용여부 : N</td>
			    </c:when>
		    </c:choose>
		    </tr>
			</table>
			</a>
			<br>
	</c:forEach>
	</c:if>	
	</div>
<%@include file="common/footer.jspf" %>
</body>
</html>





