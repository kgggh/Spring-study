<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/login.css">
<meta charset="UTF-8">
<title>회원가입성공</title>
<style>
	#container {
		width: 1000px;
		margin: 0 auto;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: gray; }
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }
</style>
</head>
<body>
<%@include file="common/menu.jspf" %>

<div id="container">
	<h1>회원가입성공.</h1>
	<hr>
	<h3>회원정보</h3>
	
	<table>
		<tr>
			<th>회원번호</th>
			<td>
				<input type="text" name="m_id" value="${singupSuccess.m_id }" >
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="id" size="30" value="${singupSuccess.id }">
			</td>
		</tr>
		
		<tr>
			<th>암호</th>
			<td>
				<input type="password" name="password" value="${singupSuccess.password }">
			</td>
		</tr>
		<tr>
			<th width="130">고객점주 구분(0-점주, 1-고객)</th>
			<td>
				<input type="text" name="c_s" value="${singupSuccess.c_s }">
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="address" value="${singupSuccess.address }">
			</td>
		</tr>
		<tr>
			<th>성별(0-남, 1-여)</th>
			<td>
				<input type="text" name="gender" value="${singupSuccess.gender }">
			</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>
				<input type="text" name="gender" value="${singupSuccess.gender }">
			</td>
		</tr>
		<tr>
			<th>성명</th>
			<td>
				<input type="text" name="name" value="${singupSuccess.name }">
			</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>
				<input type="text" name="m_phone" value="${singupSuccess.m_phone }">
			</td>
		</tr>
	</table>
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>