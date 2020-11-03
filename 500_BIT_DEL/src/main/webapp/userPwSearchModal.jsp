<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/login.css">
<title>아이디/패스워드찾기</title>
<script>
function goMain(){
	location.href = "index.jsp";
}
</script>
</head>
<body>
<%@include file="common/menu.jspf" %>
<div id="background_modal" class="container">
	<div class="modal_contents">
			<h4>
				<b>고객님이 찾으시는 비밀번호는</b>
				<input type="text" name="password" value="${userPwSearch.password }">
				<b>입니다.</b>
			</h4>
		<input type="button" value="메인으로" onclick="goMain()">
		<input type="button" value="이전" onclick="history.back(-1);">
	</div>
</div>
<%@include file="common/footer.jspf" %>
</body>
</html>