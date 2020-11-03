<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>

<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="css/skrmain.css">
<!-- <link rel="stylesheet" href="css/newMenu.css"> -->

</head>
<script>
$().ready(function(){
	 click_go();
});
function click_go(){
	 $("#menu").click(function(){
		 location.href="setMenuList.do?s_id="+${svo.s_id };
	 });
	$("#close").click(function(){
		$('.modal').show();
		 
	});
	$("#review").click(function(){
		location.href="skr_review_null.do?s_id="+${svo.s_id }+"&s_classification="+${svo.s_classification};
		 
	});
}
</script>
<%@include file="common/skr_menu.jspf" %>
<body>
<div id="container">
<br>
	<div>
		<h2 class="subtitle">MYSTORE</h2>
	</div>
	<br>
	<h2>${loginMember.name } 님 환영합니다!</h2>
	<h3>${svo.s_name }</h3>
	<c:if test="${svo.s_closed eq '예'}">
	<div class="center">
	<h2>현재 고객님의 점포는 휴업상태입니다. </h2>
		<h2>영업을 시작하겠습니까?</h2>
			<form action="Resumption_Yes.do" method="post">
				<input type="hidden" name="s_id" value="${svo.s_id }">
				<input type="hidden" name="m_id" value="${svo.m_id }">
				<input type="submit" class="pageButton"  value="영업신청">
			</form>	
	
		
	</div>
	</c:if>
	<c:if test="${svo.s_closed eq '아니요'}">
	<h3>오늘의 매출액은 ${orderprice } 입니다.</h3>
	<h3>우리 점포를 ${favoritecount }명이 좋아합니다.</h3>
			
		<div class="center">
			<input type="button" class="pageButton" id="menu" name="c_s" value="메뉴 관리 ">
			<input type="button" class="pageButton"  id="store"name="c_s" value="점포 관리">
			<input type="button" class="pageButton" id="close"name="c_s" value="휴업 신청 ">
			<input type="button" class="pageButton" name="c_s" value="매출 현황 ">
			<input type="button" class="pageButton" name="c_s" value="광고">
			<input type="button" class="pageButton" name="c_s" value="쿠폰 등록 ">
			<input type="button" class="pageButton" id="review" name="c_s" value="리뷰 관리">
			<input type="hidden" name="s_id"  value="${svo.s_id}">
			<input type="hidden" name="s_classification" value="${svo.s_classification}">
		</div>
		<br>
		<div class="modal center">
			<h2>휴업신청을 하시겠습니까?</h2>
			<form action="Closing_Apply.do" method="post">	
				<input type="submit" class="pageButton" id="" value="휴업신청">
				<input type="hidden" name="s_id" value="${svo.s_id}">
				<input type="hidden" name="m_id" value="${svo.m_id }">
			</form>
		</div>
	
	</c:if>
</div>


</body>
<%@include file="common/footer.jspf" %>
</html>











