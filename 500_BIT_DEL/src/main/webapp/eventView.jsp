<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 상세페이지</title>
<!-- <link href="css/style.css" rel="stylesheet" type="text/css"> -->
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<script>

	//이벤트 목록
	function eventList() {
		 location.href = "event.do";
	}
	//이벤트 삭제
	function eventDel() {
		 location.href = "eventDelForm.do";
	}
	//이벤트 수정
	function eventMod() {
		 location.href = "eventModForm.do";
	}

	function coupon_Issuance() {
		var result = confirm("쿠폰을 발급 받으시겠습니까?");
		var frm = document.frm;
		var m_id = $("loginMember.m_id").val();
		if(result){
		    alert("발급 완료");
		    location.href ="couponIssuance.do";
		    frm.submit();
		}
	}
	
	
    
</script>
<style>
	
	h1{
		color: #215cb5;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		font-style: italic;
	}
	#container {
		width: 900px;
		margin: 0 auto;
		text-align: center;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 0px solid black;
		margin: 0 auto;
	}
	td{
	text-align: center;
	font-size: 120%;
	}
	th { 
	font-size: 1.5em;
	font-style: italic;
	color: white;
	background-color: #215cb5;
	height: 50px;
	width: 700px;
	}
	input{
		color: #215cb5;
		border: 0px;
		background-color: white;
		font-size: 100%;		
	}
	#coupon{
		font-size: 140%;
	}
	#eventP{
		color: #215cb5;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		font-style: italic;
		text-align: center;
		font-size: 200%;
	}
	.e_content{
		font-size: 110%;
		border: 0px solid white;
		font-style: italic;
		text-align: center;	
		resize: none;
	}
	#sub{
		text-align: center;
	}
	.subtitle{
	clear: both;
    width: 218px;
    margin: auto;
    text-align: center;
    border: 1px solid #e5e5e5;
    height: 30px;
    line-height: 30px;
    font-size: 1em;
}
</style>

</head>
<c:if test="${loginMember.c_s != 0 }">
	<%@include file="common/menu.jspf" %>
</c:if>
<c:if test="${loginMember.c_s == 0 }">
	<%@include file="common/skr_menu.jspf" %>
</c:if>
<body>

<br>
	<div>
		<h2 class="subtitle">EVENT</h2>
	</div>
	<br>
	<p id="sub">다양한 이벤트를 통해 할인도 받자!</p>
<div id="container">
	<table>
	<tr>
		<th>${event.e_title }</th>
		<c:if test="${loginMember.id == 'admin'}">
			<td><input type="button" value="수정" onclick="eventMod()"></td>
			<td><input type="button" value="삭제" onclick="eventDel()"></td>
			<td><input type="button" value="목록" onclick="eventList()"></td>
		</c:if>
		<c:if test="${loginMember.id != 'admin'}">
			<td colspan="3"><input type="button" value="목록" onclick="eventList()"></td>
		</c:if>
	</tr>
	<tr>
		<td colspan="4"> 
		<br><br>
			<textarea class="e_content" name="e_content" rows="40" cols="90" readonly="readonly">${event.e_content }</textarea>
		</td>
	</tr>	
</table>
<form name ="frm" action="couponIssuance.do" method="post">
	<input type="button" id="coupon"onclick="coupon_Issuance()" value="쿠폰발급">
	<input type="hidden" name="m_id" value="${loginMember.m_id}">
	<input type="hidden" name="c_id" value="${event.c_id }">
</form>
<br><br>
</div>

<%@include file="common/footer.jspf" %>
</body>
<script>



</script>
</html>





