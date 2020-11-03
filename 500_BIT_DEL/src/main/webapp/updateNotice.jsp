<%@page import="com.spring.delivery.notice.service.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 화면에 표시 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항(수정하기)</title>
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
<script>
	function noticeList(){
		location.href = "getNoticeList.do";
		}
</script>
</head>
<body>
<div id="container">
	<h1>공지사항 수정</h1>
	<p><a href="logout.do">Log-out</a></p>
	<hr>
	
	<form action="updateNotice.do" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th width="70">제목</th>
			<td>
				<input type="text" name="n_title"  value="${notice.n_title }">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="n_content">${notice.n_content }</textarea>
			</td>
		</tr>
		<tr>
			<th>사진</th>
			<td>
				<textarea name="n_photo">${notice.n_photo }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="center">
				<input type="submit" value="공지사항 수정">
				<input type="hidden" name="n_id" value="${notice.n_id }">
				<input type="button" value="목록" onclick="noticeList()">			
			</td>
		</tr>
	</table>
	</form>
	
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>

