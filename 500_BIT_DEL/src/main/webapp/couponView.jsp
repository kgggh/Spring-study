<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 상세페이지</title>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<script>
	//쿠폰 리스트
	function couponList() {
		 location.href = "couponList.do";
	}
	//쿠폰 삭제
	function couponDel() {
		 location.href = "couponDelForm.do";
	}
	
	
    
</script>
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
	input{
		color: #215cb5;
		border: 0px;
		background-color: white;
		font-size: 100%;
		
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
	#del{
		text-align: center;
		margin: 0 auto;
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
</style>

</head>
<body>
<%@include file="common/login.jspf" %>
<%@include file="common/menu.jspf" %>

	<p id="couponP">쿠폰 상세</p>
	<div id="coupon">
	<table>
	<tr>
		<td colspan="3">쿠폰번호 : ${coupon.c_id }</td>
	</tr>
	<tr>
		<td>쿠폰명 : ${coupon.c_name }</td>
	</tr>
	<tr>
	<c:choose>
	    <c:when test="${coupon.c_classification == 1}">
				<td colspan="3">적용업종 : 한식</td>
	    </c:when>
	    <c:when test="${coupon.c_classification == 2}">
				<td colspan="3">적용업종 : 중식</td>
	    </c:when>
	    <c:otherwise>
	        <td colspan="3">적용 업종 : 일식<td>
	    </c:otherwise>
	</c:choose>
	</tr>
	<tr>
		<td colspan="3">할인금액 : ${coupon.c_salesprice }원</td>
	</tr>
	<tr>
		<td colspan="3">유효일자 : ${coupon.c_period } ~  ${coupon.c_endperiod }</td>
	</tr>
</table>
</div>
<br>
<div id="del">
	<c:if test="${loginMember.id == 'admin'}">
		<input type="button" value="삭제" onclick="couponDel()">
	</c:if>	
		<input type="button" value="목록" onclick="couponList()">
</div>

<%@include file="common/footer.jspf" %>
</body>
<script>



</script>
</html>





