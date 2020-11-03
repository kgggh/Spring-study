<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점주페이지</title>

</head>
<body>
<%@include file="common/menu.jspf" %>

<h1>${vo.name}님 환영합니다.</h1>
<h2>${svo.s_name}  </h2>
<form action="s_mypage_modify.do" method="post">
			<input type="hidden" value="${svo.s_id }">
			<input type="submit" value="정보수정">
</form>	
<c:if test="${svo.s_closed eq '아니요'}">
<div class="Menu">
	<div id="Menu_Management">
		<form action="Menu_Management.do" method="post">
			<input type="hidden" value="">
			<input type="submit" value="메뉴관리">
		</form>	
	</div>
	
	<div id="Store_Management">
		<form action="Store_Management.do" method="post">
			<input type="hidden" value="">
			<input type="submit" value="점포관리">
		</form>	
	</div>
	
	<div id="Closing_Apply">
		<form action="Closing_Apply.do" method="post">
			<input type="hidden" name="s_id" value="${svo.s_id}">
			<input type="hidden" name="m_id" value="${svo.m_id }">
			<input type="submit" value="휴업신청">
		</form>	
	</div>
	
	<div id="salse_Management">
		<form action="salse_Management.do" method="post">
			<input type="hidden" name="s_id" value="${svo.s_id}">
			<input type="submit" value="매출관리">
		</form>	
	</div>
	
	<div id="Ad">
		<form action="Ad.do" method="post">
			<input type="hidden" value="">
			<input type="submit" value="광고">
		</form>	
	</div>
	
	<div id="skr_review">
		<form action="skr_review.do" method="post">
			<input type="hidden" value=" ">
			<input type="submit" value="리뷰관리">
		</form>	
	</div>
</div>
</c:if>
<c:if test="${svo.s_closed eq '예'}">
	<div class="Menu">
		<h2>영업을 시작하겠습니까?</h2>
		<div id="skr_review">
			<form action="Resumption_Yes.do" method="post">
				<input type="hidden" name="s_id" value="${svo.s_id }">
				<input type="hidden" name="m_id" value="${svo.m_id }">
				<input type="submit" value="YES">
			</form>	
	</div>
		
	</div>
</c:if>
<%@include file="common/footer.jspf" %>
</body>
</html>











