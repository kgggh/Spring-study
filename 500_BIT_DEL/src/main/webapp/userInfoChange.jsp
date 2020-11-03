<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/menuList.css">
<meta charset="UTF-8">
<title>회원정보 수정</title>

<script>
function userInfoDel(){
	location.href = "userInfoDel.do";
}
function pwChk() {
	var firstForm = document.forms[0];
	   for (var i=0; i<firstForm.elements.length; i++) {
	      if (firstForm.elements[i].value.trim() == "") {
	         alert(firstForm.elements[i].title + " 입력하세요");
	         firstForm.elements[i].focus();
	         return;
	      }
	   }
	   var pwd1 = firstForm.elements[2].value; //새로 입력한 암호
	   //var pwd1 = document.myform.pwd.value; //새로 입력한 암호 form 태그에 네임을 붙여 속성에 접근
	   var pwd2 = firstForm.elements[3].value;
	   if (pwd1 != pwd2) {
	      alert("비밀번호가 일치하지 않습니다.");
	      firstForm.elements[2].value = "";
	      firstForm.elements[3].value = "";
	      firstForm.elements[2].focus();
	      return false;
	   }else{
	      firstForm.submit();
	   }
}
</script>
</head>
<body>
<%@include file="common/menu.jspf" %>

<div id="container">
<br>
	<div>
		<h2 class="subtitle">MODIFY</h2>
	</div>
	<br>
	<hr>
	<h3>PROFILE</h3>
	<form action="userInfoChange.do" method="post">
		<table style="height: 500px;">
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
				<td>
					<input type="password" name="password" size="30" value="${loginMember.password }" title="비밀번호를 ">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password" name="password-1" size="30" value="${loginMember.password }" title="비밀번호를 ">
				</td>
			</tr>
			<tr>
				<th width="130" class="border">고객점주 구분(0-점주, 1-고객)</th>
				<td >
					<input type="number" name="c_s" size="30" value="${loginMember.c_s }" title="고객,점주 구분을 ">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="address" size="30" value="${loginMember.address }" title="주소를 ">
				</td>
			</tr>
			<tr>
				<th>성별(0-남, 1-여)</th>
				<td>
					<input type="number" name="gender" size="30" value="${loginMember.gender }"title="성별을 ">
				</td>
			</tr>
			<tr>
				<th>생년월일</th>
				<td>
					<input type="number" name="birthday" size="30" value="${loginMember.birthday }"title="생년월일을 ">
				</td>
			</tr>
			<tr>
				<th>성명</th>
				<td>
					<input type="text" name="name" size="30" value="${loginMember.name }" title="성함을 ">
				</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>
					<input type="number" name="m_phone" size="30" value="${loginMember.m_phone }" title="연락처를 ">
				</td>
			</tr>
		
		</table>
		<br>
		
		<input type="button" id="modify" value="회원정보수정" onclick="pwChk()">
	</form>
	<form action="userInfoDel.do" method="post">
		<input type="submit" id="modifydel" value="회원탈퇴">
		<input type="hidden" name="m_id" value="${loginMember.m_id }">
	</form>	
		<input type="button" id="modifycancle" value="취소" onclick="history.back(-1);">
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>











