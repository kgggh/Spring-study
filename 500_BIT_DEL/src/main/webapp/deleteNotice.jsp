<%@page import="com.spring.delivery.notice.service.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 화면에 표시 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항(삭제하기)</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/slide.css">
<link rel="stylesheet" href="css/footer.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="css/slide.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<style>
	#container {
		width: 700px;
		margin: 0 auto;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: #215cb5; }
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }
</style>

<body>
<%@include file="common/login.jspf" %>
<%@include file="common/menu.jspf" %>

<form action="deleteNotice.do" method="post">
		<input type="hidden" name="n_id" value="${notice.n_id }">
		<input type="submit" value="사라져!!!">
	</form>

<%@include file="common/footer.jspf" %>
</body>
</html>