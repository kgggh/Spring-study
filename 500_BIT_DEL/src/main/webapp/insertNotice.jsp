<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link rel="stylesheet" href="css/notice.css">
<style>
</style>
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
		<h2 class="subtitle">ADDNOTICE</h2>
	</div>
	<br>

	<hr>
	
	<form action="insertNotice.do" method="post" enctype="multipart/form-data">
	<table class="bbs" border="1" cellspacing="0">
		<tr>
			<th width="100">제목</th>
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
		<%-- <tr>
			<th>업로드</th>
			<td>
				<input type="file"  accept="image/*" name="uploadFile" >
				<img src="img/${notice.n_photo }"/>
				<input type="hidden" value="${notice.n_photo }">
			</td>
		</tr> --%>
		<tr>
			<td colspan="2" class="center">
				<input type="submit" value="새글 등록">
			</td>
		</tr>
	</table>
	</form>
	<div class="center">
	<p><a href="getNoticeList.do" id="golist">글 목록 가기</a></p>
	</div>
</div>

<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>

<%@include file="common/footer.jspf" %>
</body>
</html>







