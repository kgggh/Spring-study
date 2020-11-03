<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 작성</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<script>
	function eventList(){
		location.href = "event.do";
		}
	
	function checkInputNum(){
	      if ((event.keyCode < 48) || (event.keyCode > 57)){
	          event.returnValue = false;
	      }
	  }
	function eventIns(){
		var check = confirm("이벤트를 등록 하시겠습니까?");
			if(check){
				alert("등록 완료");
				location.href ="eventIns.do";
			    frm.submit();
			}else{	
				return;
		}
	}
</script>
<style>
#event{
		display : flex;
		align-items: center;
		justify-content: center;
	}
	#eventP{
		color: #215cb5;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		font-style: italic;
		text-align: center;
		font-size: 200%;
	}
</style>
</head>
<body>
<%@include file="common/menu.jspf" %>
<br>
	<div>
		<h2 class="subtitle">ADDEVENT</h2>
	</div>
	<br>
<div id="container">
<form action="eventIns.do" method="post" name="frm">
	<table>
		<tr>
			<th width="100">이벤트명</th>
			<td>
				<input type="text" name="e_title" size="30" style="width: 98%;">
			</td>
		</tr>
		<tr>
			<th>이벤트 내용</th>
			<td>
				<textarea name="e_content" rows="10" cols="40" ></textarea>
			</td>
		</tr>
		<tr>
			<th>쿠폰 선택</th>
			<td>
			<c:if test="${empty coupon}">
				사용가능한 쿠폰이 없습니다.
			</c:if>
			<c:if test="${not empty coupon}">
			<select name="c_id">
			  <c:forEach var="coupon" items="${coupon }">
			    <option value="${coupon.c_id}">${coupon.c_name } </option>
			  </c:forEach>
			</select>
			</c:if>
			 </td>
		</tr>
		<tr>
			<td colspan="2" >
				<input type="button" value="이벤트 등록" onclick="eventIns()">
				<input type="button" value="목록" onclick="eventList()">				
			</td>
		</tr>
	</table>
	</form>
	</div>

<%@include file="common/footer.jspf" %>
</body>
</html>





