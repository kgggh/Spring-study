<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	form {display:inline}
	#container {
		width: 700px;
		margin: 0 auto;
		text-align: center;
	}
	h1 { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: gray; }
	.center { text-align: center; }
</style>
<script>
	function findIdPw(){
		location.href = "findIdPw.do";
	}
</script>
</head>
<body>
<%@include file="common/menu.jspf" %>

<div id="container">
	<h1>로그인</h1>
	<hr>
	<form action="login.do" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><input type="text" name="password"></td>
		</tr>
	</table>
	<br>
		<input type="submit" value="로그인">
	</form>
		<input type="button" value="아이디/비밀번호 찾기" onclick="findIdPw()">
	<form action="signup.do" method="get">
		<input type="submit" value="회원가입">
	</form>
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>











