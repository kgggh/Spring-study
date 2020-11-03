<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/login.css">
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	/* form {display:inline}
	#container {
		width: 1000px;
		margin: 0 auto;
		text-align: center;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: #215cb5; }
	.center { text-align: center; }
	.border-none, .border-none td { border: none; } */
</style>
<script>
if("${msg}" != ""){
	alert("${msg}");
}

	function idChk() {
		var firstForm = document.forms[0];
		   if (firstForm.elements[0].value.trim() == "") {
		      alert(firstForm.elements[0].title + " 입력하세요");
		      firstForm.elements[0].focus();
		      return;
		   }
		   var id = firstForm.elements[0].value;
		   location.href="idChk.do?id=" + id;
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
		<h2 class="subtitle">JOIN</h2>
	</div>
	<br>
	<form action="signup.do" method="post">
	<table>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="id" size="30" placeholder="아이디를 입력하세요." value="${id }" title="아이디를">
			</td>
			<td>
				<input type="button" id="check" value="중복확인"  onclick="idChk()">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="password" size="30" placeholder="비밀번호를 입력하세요." title="비밀번호를">
			</td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td>
				<input type="password" name="password-1" size="30" placeholder="동일한 비밀번호를 입력하세요." title="비밀번호를">
			</td>
		</tr>
		<tr>
			<th width="130">고객, 점주 구분</th>
			<td>
				<input type="text" name="c_s" size="30" placeholder="점주=0, 고객=1" title="고객, 점주 구분을">
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="address" size="30" placeholder="주소를 입력하세요." title="주소를">
			</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="text" name="gender" size="30"placeholder="남성=0, 여성=1." title="성별을">
			</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>
				<input type="text" name="birthday" size="30" placeholder="주민번호 앞 여섯자리를 입력하세요." title="생년월일을">
			</td>
		</tr>
		<tr>
			<th>성명</th>
			<td>
				<input type="text" name="name" size="30" placeholder="성명을 입력하세요." title="성명을">
			</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>
				<input type="text" name="m_phone" size="30" placeholder="연락처를 입력하세요." title="연락처를">
			</td>
		</tr>
	</table>
	<br>
	<div class="center">
		<input type="button" id="joinbutton" value="회원가입" onclick="pwChk()">
		<input type="button" id="cancle"value="취소" onclick="history.back(-1);">
	</div>
	</form>
		
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>











