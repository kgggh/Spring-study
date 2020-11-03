<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/menuList.css">
<meta charset="UTF-8">
<title>회원정보 수정</title>
<style>

</style>
<script>
if("${msg}" != ""){
	alert("${msg}");
}
function goMain(){
	location.href = "index.jsp";
}
</script>
</head>
<body>
<%@include file="common/menu.jspf" %>

<div id="container">
<br>
	<div>
		<h2 class="subtitle">PROFILE</h2>
	</div>
	<br>
	<hr>
	<h3>MODIFY</h3>
		<table style="height: 500px; border:#111 1px">
			<tr>
				<th style="width: 250px;">회원번호</th>
				<td class="border">
					<input type="number" name="m_id" size="30" value="${loginMember.m_id }" readonly>
				</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td class="border">
					<input type="text" name="id" size="30" value="${loginMember.id }" readonly>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td class="border">
					<input type="password" name="password" size="30" value="${loginMember.password }" readonly>
				</td>
			</tr>

			<tr>
				<th width="130">고객점주 구분(0-점주, 1-고객)</th>
				<td class="border">
					<input type="number" name="c_s" size="30" value="${loginMember.c_s }" readonly>
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td class="border">
					<input type="text" name="address" size="30" value="${loginMember.address }" readonly>
				</td>
			</tr>
			<tr>
				<th>성별(0-남, 1-여)</th>
				<td class="border">
					<input type="number" name="gender" size="30" value="${loginMember.gender }" readonly>
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td class="border">
					<input type="number" name="birthday" size="30" value="${loginMember.birthday }" readonly>
				</td>
			</tr>
			<tr>
				<th>성명</th>
				<td class="border">
					<input type="text" name="name" size="30" value="${loginMember.name }" readonly>
				</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td class="border">
					<input type="number" name="m_phone" size="30" value="${loginMember.m_phone }" readonly>
				</td>
			</tr>
		</table>
		<br>

</div>

<%@include file="common/footer.jspf" %>
</body>
</html>











