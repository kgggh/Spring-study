<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰삭제</title>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<script>
	function check(){
		var pwd1 = "삭제";
		var pwd2 = $("#pwd2").val();
		var check = confirm("삭제 하시겠습니까?");
		
		if(pwd1 === pwd2){
			if(check){
				alert("삭제 완료");
				location.href ="couponDel.do";
			    frm.submit();
			}			
			}else if(pwd1 != pwd2){
				alert("다시 입력해주세요.");
				return;
		}
	}
</script>

<style>
	#coupon{
		display : flex;
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
	<p id="couponP">쿠폰 삭제</p>
<div id="coupon">
	삭제하시려면 "삭제"라고 적어주세요.
	<form action="couponDel.do" name="frm" method="post" >
		<input type="text" id="pwd2">
		<input type="hidden" name="c_id" value="${coupon.c_id }">
		<input type="button" value="삭제" onclick="check()">
	</form>
</div>
<%@include file="common/footer.jspf" %>
</body>
</html>





