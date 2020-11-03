<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>매출관리</title>

</head>
<body>
<%@include file="common/menu.jspf" %>
<div id="salse_management">
	<h1>${loginMember.name} 고객님 환영합니다.</h1>
	<h2>${svo.s_name }</h2> <button>수정</button>
	<h3>매출현황입니다.</h3>
</div>
<div>
	<table border="1">
		<tr>
			<th>날 짜</th>
			<th>요 일</th>
			<th>매 출 액</th>
		</tr>
		<c:forEach var="salseList" items="${salseList }">
		<tr>

			<td>${salseList.dt }</td>
			<td></td>
			<td>${salseList.dayTotal }</td>
		</tr>
		</c:forEach>
		<c:forEach var="salseList" items="${salseList }">
		<c:if test="${salselist.dt eq '합계' }">
		<tr>
			<td colspan="2">${salseList.dt }</td>
			<td>${salseList.dayTotal }</td>
		</tr>
		</c:if>
		</c:forEach>

	</table>
</div>
<form action="m_mypage.do" method="post">
		<input type="hidden" name='m_id' value="1">
		<input type="submit" value="뒤로가기">
	</form>	

<%@include file="common/footer.jspf" %>
</body>
</html>











