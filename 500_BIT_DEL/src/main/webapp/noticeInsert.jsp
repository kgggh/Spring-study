<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>글등록</title>
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
	th { background-color: orange; }
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }
</style>
</head>
<body>

<div id="container">
	<h1>공지사항 등록</h1>
	<p><a href="logout.do">Log-out</a></p>
	<hr>
	
	<form action="insertNotice.do" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<th width="70">제목</th>
			<td>
				<input type="text" name="n_title" size="30">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="n_content" rows="10" cols="40"></textarea>
			</td>
		</tr>
		<tr>
			<th>업로드</th>
			<td>
				<input type="file" name="uploadFile" >
			</td>
		</tr>
		<tr>
			<td colspan="2" class="center">
				<input type="submit" value="새글 등록">
			</td>
		</tr>
	</table>
	</form>
	
	<p><a href="getNoticeList.do">글 목록 가기</a></p>
</div>

<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>

<%@include file="common/footer.jspf" %>
</body>
</html>







