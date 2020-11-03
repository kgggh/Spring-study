<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비트딜리버리</title>

<link rel="stylesheet" href="css/menu.css">
<!-- <link rel="stylesheet" href="css/newMenu.css"> -->
<link rel="stylesheet" href="css/slide.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="css/slide.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<script>
if("${msg}" != ""){
	alert("${msg}");
}
if("${msgD}" != ""){
	alert("${msgD}");
}
</script>
<style>
        table {
            text-align: center; 
            width: 70%;
            margin: 30px 20% 0 0; /* 상 좌우 하 */
            border-collapse: collapse;
            font-size: 0.5em;
        }
</style>
</head>
<body>
<%@include file="common/menu.jspf" %>
<%-- <%@include file="common/ad.jspf" %> --%>
<div id="container">
	<h1>게시판 프로그램</h1>
	<hr>
	<p><a href="signupAgree.jsp">회원가입</a></p>
	<p><a href="login.do">로그인(GET)</a></p>
	<p><a href="getMenuList.do?s_id=1">점포선택</a></p>
	<p><a href="setMenuList.do?s_id=1">메뉴관리</a></p>
	<p><a href="event.do">이벤트</a></p>
	<p><a href="eventInsForm.do">이벤트 작성</a></p>
	<p><a href="myCoupon.do">My 쿠폰함</a></p>
	<p><a href="m_mypage.do?m_id=1">마이페이지</a></p>
	<p><a href="storeInfo.do?s_id=1">점포정보</a></p>
	<p><a href="storeList.do?s_classification=0">점포목록</a></p>
	<p><a href="ReviewList.do?s_id=1">리뷰목록</a></p>
	<p><a href="getCartList.do?m_id=1">장바구니</a></p>
	<p><a href="Skr_Review.jsp">사장님리뷰</a></p>
	<p><a href="myPage.jsp?m_id=${loginMember.m_id }">마이페이지</a></p>
	<p><a href="reviewAdministrate.jsp">리뷰쓰기</a></p>
	<p><a href="main.jsp">메인</a></p>

	<hr><hr>

	<c:if test="${loginMember.id == 'admin'}">
		<p><a href="eventInsForm.do">이벤트 작성</a></p>
		<p><a href="couponList.do">쿠폰 등록관리함(관리자)</a></p>
		<p><a href="couponInsForm.do">쿠폰등록</a></p>
	</c:if>
	
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>