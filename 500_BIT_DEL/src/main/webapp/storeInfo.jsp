<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>

</head>
<style>
	
    		
</style>
<link href="css/style.css" rel="stylesheet" type="text/css">
<body>
<%@include file="common/menu.jspf" %>
<div id="container">
<br>
	<div>
		<h2 class="subtitle">INFO</h2>
	</div>
	<br>
<%@include file="common/storemenubar.jspf" %>
<h2>가계 통계</h2>
<p>최근 주문 수 &nbsp; ${orderCount }</p>	
<p>전체 리뷰 수 &nbsp; </p>	
<p>찜 &nbsp; 1개</p>	
<br>
<h2>영업 정보</h2>
<p>운영 시간 &nbsp; ${store.s_open_t}시 ~ ${store.s_close_t}시</p>	
<p>휴무일 &nbsp; ${mon } ${tue } ${wed } ${thu } ${fri } ${sat } ${sun } ${holiday }</p>	
<p>전화번호 &nbsp; ${member.m_phone }</p>	
<p>배달지역 &nbsp; 
	<c:forEach var="tip" items="${tipList}" varStatus="status">
		${tip.dong }
	</c:forEach>
</p>	
<br>
<h2>배달팁</h2>
<p>○ 배달팁은 가게로 전달되며, BITDELIVERY가 수취하는 비용이 아닙니다. </p>
<p>○ 배달팁은 가게 사장님이 정합니다. </p>
<p>○ 주문금액과 배달지역, 주문시각 등에 다라 달라질 수 있습니다. </p>
<br>
<h2>지역별 배달팁</h2>
<table>
<c:if test="${not empty tipList}">
	<c:forEach var="tip" items="${tipList}" varStatus="status">
		<tr>
			<td>${tip.dong }</td>
			<td>${tip.tip_price }</td>
		</tr>
	</c:forEach>
</c:if>
</table>
<c:if test="${empty tipList}">
	해당 점포는 배달팁이 없습니다.
</c:if>
<br>
<h2>사업자 정보</h2>
<p>대표자명 &nbsp; ${member.name }</p>	
<p>상호명 &nbsp; ${store.s_name }</p>	
<p>사업자주소 &nbsp; ${member.address }</p>	

	
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>















