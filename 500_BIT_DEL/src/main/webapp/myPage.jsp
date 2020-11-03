<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/menuList.css">
<meta charset="UTF-8">
<title>마이페이지</title>
<style>

</style>
<script>
</script>
</head>
<body>
<%@include file="common/menu.jspf" %>

<div id="container">
<br>
	<div>
		<h2 class="subtitle">MYPAGE</h2>
	</div>
	<br>
	<hr>
	<form action="" method="post">
	<table class=mypage>
		<tr>
			<th><a href="">쿠폰함</a></th>
			<th><a href="userInfoChange.jsp?m_id=${loginMember.m_id }">정보수정</a></th>
			<th><a href="reviewAdministrate.do">리뷰관리</a></th>
		</tr>
		<tr>	
			<td colspan = "3">이벤트 및 공지사항</td>
		</tr>
		<tr>	
			<td colspan = "3">BIT_DELIVERY 안내</td>
		</tr>
		<tr>	
			<td colspan = "3">주문 내역! </td>
		</tr>
	</table>
	<br>

	</form>
		
</div>
<<br><br><br>
<%@include file="common/footer.jspf" %>
</body>
</html>











