<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>

</style>
<link rel="stylesheet" href="css/login.css">
<script>
	if("${msg}" != ""){
		alert("${msg}");
	}	
	function userIdpwSearch(){
		location.href = "userIdpwSearch.jsp";
	}
	function signupAgree(){
		location.href = "signupAgree.jsp";
	}
	
</script>
</head>

	<%@include file="common/menu.jspf" %>


<body>

<div id="container">
<br>
	<div>
		<h2 class="subtitle">LOGIN</h2>
	</div>
	<br><br><br>
	<form action="login.do" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><input type="password" name="password"></td>
		</tr>
	</table>
	<br>
		<input type="submit" class="submit" value="로그인">
	</form>
	<br>
	<div>
		<input type="button" class="loginbutton" id="idcheck"value="아이디/비밀번호 찾기" onclick="userIdpwSearch()">
		<input type="submit" class="loginbutton" value="회원가입" onclick="signupAgree()">
	</div>
</div>
<br><br><br><br>
</body>
<%@include file="common/footer.jspf" %>
</html>











