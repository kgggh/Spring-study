<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/login.css">
<meta charset="UTF-8">
<title>아이디/패스워드찾기</title>
<style>
	.container, #class1, #class2 {
		width: 700px;
		margin: 0 auto;
		text-align: center;
	}
	searchI-1
	h3 { text-align: center; }
</style>
<script>
if("${msg}" != ""){
	alert("${msg}");
}
if("${msg1}" != ""){
	alert("${msg1}");
}
//체크 버튼에 따라 아이디/비밀번호 기능이 달라진다
function search_check(num) {
	if (num == '1') {
		document.getElementById("searchP").style.display = "none";
		document.getElementById("searchI").style.display = "inline";	
	} else {
		document.getElementById("searchI").style.display = "none";
		document.getElementById("searchP").style.display = "inline";
	}
}

function nameM_phone() {
	var firstForm = document.forms[0];
	   for (var i=0; i<firstForm.elements.length; i++) {
	      if (firstForm.elements[i].value.trim() == "") {
	         alert(firstForm.elements[i].title + " 입력하세요");
	         firstForm.elements[i].focus();
	         return;
	      }
	   }
	   var name = firstForm.elements[0].value;
	   location.href="userIdSearch.do?name=" + name;
	   var m_phone = firstForm.elements[1].value;
	   location.href="userIdSearch.do?m_phone=" + m_phone;
	   firstForm.submit();
}
function idM_phone() {
	var firstForm = document.forms[1];
	   for (var i=0; i<firstForm.elements.length; i++) {
	      if (firstForm.elements[i].value.trim() == "") {
	         alert(firstForm.elements[i].title + " 입력하세요");
	         firstForm.elements[i].focus();
	         return;
	      }
	   }
	   var id = firstForm.elements[0].value;
	   location.href="userPwSearch.do?id=" + id;
	   var m_phone = firstForm.elements[1].value;
	   location.href="userPwSearch.do?m_phone=" + m_phone;
	   firstForm.submit();
}
</script>
<style>
	#searchP {
	display: none;}
</style>
</head>
<body>
<%@include file="common/menu.jspf" %>
			<div class="container">
				<div class="class0">
					<h3>아이디/비밀번호 찾기</h3>
				</div>
				<div class="class1">
					<input type="radio" id="search_1" name="search_total" onclick="search_check(1)" checked="checked">
					<label for="search_1">아이디 찾기</label>
				</div>
				<div class="class2">
					<input type="radio" id="search_2" name="search_total" onclick="search_check(2)"> 
					<label for="search_2">비밀번호 찾기</label>
				</div>
				
				
				
				
			<form action="userIdSearch.do" method="post">	
				<div id="searchI">
					<div class="searchI-1">
						<label for="name">이름</label>
						<div>
							<input type="text" name="name" placeholder="ex) 고광렬" value="${name }" title="이름을">
						</div>
					</div>
					<div class="searchI-2">
						<label for="m_phone">휴대폰번호</label>
						<div>
							<input type="text" name="m_phone" placeholder="ex) 01011112222" value="${m_phone }"title="연락처를">
						</div>
					</div>
					<div class="searchI-3">
						<input type="button" value="확인" onclick="nameM_phone()">
						<input type="button" value="취소" onclick="history.back(-1);">
					</div>
				</div>
			</form>
			
			
			
			
			<form action="userPwSearch.do" method="post">
				<div id="searchP">
					<div class="searchP-1">
						<label for="inputId">아이디</label>
						<div>
							<input type="text" id="id" name="id" placeholder="ex) mr.go" value="${id }" title="아이디를">
						</div>
					</div>
					<div class="searchP-2">
						<label for="inputPhone_2">휴대폰번호</label>
						<div>
							<input type="text" id="m_phone" name="m_phone" placeholder="ex) 01011112222" value="${m_phone }" title="연락처를">
						</div>
					</div>
					<div class="searchP-3">
						<input type="button" value="확인" onclick="idM_phone()">
						<input type="button" value="취소" onclick="history.back(-1);">
					</div>
				</div>
			</form>
		</div>

<%@include file="common/footer.jspf" %>
</body>
</html>