<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<style>
/* 	
	h1{
		color: #215cb5;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		font-style: italic;
	}
	#container {
		width: 1100px;
		margin: 0 auto;
		text-align: center;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 0px solid black;
		margin: 0 auto;
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
	td{
	text-align: left;
	}
	#number, #date, #hit{
		text-align: right;
	} 
	#td{
		border-bottom: 2px solid black;
	}
	#eventP{
		color: #215cb5;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		font-style: italic;
		text-align: center;
		font-size: 150%;
	}
	.noEvent{
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		font-style: italic;
		text-align: center;
		font-size: 170%;
	} */
</style>
<script>

	//이벤트 작성
	function eventIns() {
		 location.href = "eventInsForm.do";
	}
	function couponList() {
		 location.href = "couponList.do";
	}
	function couponInsForm() {
		 location.href = "couponInsForm.do";
	}
</script>
</head>
<c:if test="${loginMember.c_s != 0 }">
	<%@include file="common/menu.jspf" %>
</c:if>
<c:if test="${loginMember.c_s == 0 }">
	<%@include file="common/skr_menu.jspf" %>
</c:if>
<body>

<div id="container">
<br>
	<div>
		<h2 class="subtitle">EVENT</h2>
	</div>
	<br>
	<c:if test="${not empty event }">
	<p>다양한 이벤트를 통해 할인도 받자!</p>
	</c:if>
	<c:if test="${empty event }">
		<p class="noEvent">아쉽게도 현재 진행중인 이벤트가 없습니다.</p>
	</c:if>
	<table>
	<c:if test="${not empty event }">
	<tr>
		<th colspan="3" >진행중 이벤트</th>
	</tr>
		<c:forEach var="event" items="${event }">
		<tr>
			<td colspan="3" id="date"> 
			&emsp;날짜 : ${event.e_date }&emsp;조회수 : ${event.e_hit }</td>
		</tr>
		<tr>
			<td colspan="3" id="td" >
				<a href="eventView.do?e_id=${event.e_id }"><img src="img/event${event.e_id }.jpg" id="eventImg"></a>
			</td>
		</tr>
		</c:forEach>
	</c:if>	
</table>
<br><br>
	
<c:if test="${loginMember.id == 'admin'}">
<div class="center">
	<input type="button" class="eventbutton" id ="eventbutton"  value="이벤트 등록" onclick="eventIns()">
	<input type="button" class="eventbutton" value="쿠폰 등록" onclick="couponList()">
	<input type="button" class="eventbutton" value="쿠폰 관리 "onclick="couponInsForm()">
</div>
</c:if>
<c:if test="${loginMember.id != 'admin'}">
	
</c:if>

</div>
<br><br><br>

</body>
<%@include file="common/footer.jspf" %>
</html>





