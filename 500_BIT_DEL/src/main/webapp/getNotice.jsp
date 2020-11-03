<%@page import="com.spring.delivery.notice.service.NoticeVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달받은 데이터를 화면에 표시 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항(상세보기)</title>
<link rel="stylesheet" href="css/slide.css">
<link rel="stylesheet" href="css/footer.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<link rel="stylesheet" href="css/notice.css">
<style>
</style>
<script>
	//공지사항 목록
	function noticeList() {
		 location.href = "getNoticeList.do";
	}
	//공지사항 삭제
	function noticeDel() {
		var n_id = $('#n_id').val();
		var result = confirm("목록에서 삭제하시겠습니까?");
		if(result){
		 location.href = "deleteNotice.do?n_id="+n_id;
		}
	}
	//공지사항 수정
	function noticeMod() {
		
		 location.href = "updateNoticeForm.do";
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
		<h2 class="subtitle">NOTICE</h2>
	</div>
	<br>
	<hr>
		<input type="hidden" id="n_id" name="n_id" value="${notice.n_id }">
	<table class="bbs" border="1" >
		<caption>공지사항(상세보기)</caption>
					<tr>
						<th width="100">제목</th>
						<td>
							<input type="text" class="input" name="n_title"
								value="${notice.n_title }" readonly="readonly">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea class="input" name="n_content" readonly="readonly">${notice.n_content }</textarea>
						</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>${notice.n_date }</td>
					</tr>
					<tr>
						<th>조회수</th>
						<td>${notice.n_hit }</td>
					</tr>
	</table>
	<br><br>
	<div class="center">
		<c:if test="${loginMember.id == 'admin'}">
			<input type="button" id="upbutton" value="수정" onclick="noticeMod()">
			<input type="button" id="delbutton" value="삭제" onclick="noticeDel()">
			<input type="button" id="listbutton" value="목록" onclick="noticeList()">
		</c:if>
		<c:if test="${loginMember.id != 'admin'}">
			<input type="button" id="golist" value="목록" onclick="noticeList()">
		</c:if>
	</div>
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>






