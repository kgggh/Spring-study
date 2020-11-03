<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function pwdcheck(){
		document.getElementById("pwdCheck").style.display ='inline';
	}
	
	function check(){
		var firstForm = document.forms[3];
		if (confirm("정말로 휴업신청을 하시겠습니까?") == true){    //확인
			firstForm.submit();
		}else{   //취소
		    return;
		}
	}
	
	function modifyData(){
		var firstForm = document.forms[0];
		
			if (firstForm.elements[0].value.trim() == "") {
				alert(firstForm.elements[0].title + " 입력하세요");
				firstForm.elements[0].focus();
				return false;
			}

		var pwd1 = firstForm.elements[0].value; //새로 입력한 암호
		
		var pwd2 = "${loginMember.password}";
		if (pwd1 != pwd2) {
			alert("비밀번호가 일치하지 않습니다.");
			firstForm.elements[0].value = "";
			firstForm.elements[0].focus();
			return false;
		}else{
			firstForm.submit();
		}
	}
	//닫기 클릭
	function close(frm) {
		document.getElementById("pwdCheck").style.display = 'none';
		
	}
</script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점주페이지</title>
<link rel="stylesheet" href="css/S_MyPage.css" type="text/css">
</head>
<body>
<%@include file="common/skr_menu.jspf" %>

<div id="pwdCheck">
		<a href="javascript:close(this.form);"><img alt="닫기버튼" src="img/close.png" class="close"></a>
		<form action="s_mypage_modify.do" method="post">
			<p class="wpass">패스워드를 입력하세요</p>
			<input type="password" class="password" name="password" value="" title="비밀번호"> </input><br>
			<input type="button" class="bnt" value="확인" onclick="modifyData()"></input>
		</form>
</div>

<c:if test="${svo.s_closed eq '아니요'}">
<div class="sidebanner">
	<ul>
		<li class="banner">${loginMember.name}님 환영합니다.(${svo.s_name})</li>
		<li>
			<input type="button" class="banner" value="정보 수정" onclick="pwdcheck()">
		</li>
		<li>
			<form action="Menu_Management.do" method="post">
				<input type="submit" class="banner" value="메뉴관리">
				<input type="hidden" value="">
			</form>	
		</li>
	
		<li>
			<form action="Store_Management.do" method="post">
				<input type="hidden" value="">
				<input type="submit" class="banner" value="점포관리">
			</form>	
		</li>
		
		<li>
			<form action="Closing_Apply.do" method="post">
				<input type="hidden" name="s_id" value="${svo.s_id}">
				<input type="hidden" name="m_id" value="${svo.m_id }">
				<input type="button" class="banner" value="휴업신청" onclick="check()">
			</form>	
		</li>
		
		<li>
			<form action="salse_Management.do" method="post">
				<input type="hidden" name="s_id" value="${svo.s_id}">
				<input type="submit" class="banner" value="매출관리">
			</form>	
		</li>
		
		<li>
			<form action="Ad.do" method="post">
				<input type="hidden" value="">
				<input type="submit" class="banner" value="광고">
			</form>	
		</li>
		
		
		<li>
			<form action="skr_review_null.do" method="post">
				<input type="hidden" name="s_id" value="${svo.s_id}">
				<input type="hidden" name="s_classification" value="${svo.s_classification}">
				<input type="submit" class="banner" value="리뷰관리">
			</form>	
		</li>
	</ul>
</div>
</c:if>
<c:if test="${svo.s_closed eq '예'}">
	<div class="">
		<h2>영업을 시작하겠습니까?</h2>
		
			<form action="Resumption_Yes.do" method="post">
				<input type="hidden" name="s_id" value="${svo.s_id }">
				<input type="hidden" name="m_id" value="${svo.m_id }">
				<input type="submit" value="YES">
			</form>	
	
		
	</div>
</c:if>

<%@include file="common/footer.jspf" %>
</body>
</html>











