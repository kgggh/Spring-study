<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 수정</title>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<style>
	#event{
		display : flex;
		align-items: center;
		justify-content: center;
		width: 900px;
		margin: 0 auto;
		text-align: center;
	}
	#eventP{
		color: #215cb5;
		font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
		font-style: italic;
		text-align: center;
		font-size: 200%;
	}
	.e_content{
		font-size: 110%;
		border: 0px solid white;
		font-style: italic;
		text-align: center;
		resize: none;	
	}
	td { 
	font-size: 1.5em;
	font-style: italic;
	height: 50px;
	width: 700px;
	}
 	#list {
 	 width: 
 	 
 	}
</style>
<script>
	function eventList(){
		location.href = "event.do";
		}

	function eventMod(){
		var check = confirm("이벤트를 수정 하시겠습니까?");
			if(check){
				alert("수정 완료");
				location.href ="eventMod.do";
			    frm.submit();
			}else{	
				return;
		}
	}
</script>
</head>
<body>
<%@include file="common/login.jspf" %>
<%@include file="common/menu.jspf" %>
<p id="eventP">이벤트수정</p>
<div id="event">
<form action="eventMod.do" method="post" name="frm">
	<table>
		<tr>
			<th width="100">이벤트명</th>
			<td>
				<input type="text" name="e_title" size="30" value="${event.e_title }">
			</td>
			<td id="list"> <input type="button" value="목록" onclick="eventList()"> </td>
		</tr>
		<tr>
			<th>이벤트 내용</th>
			<td>
				<textarea class="e_content" name="e_content" rows="10" cols="40">${event.e_content }</textarea>
			</td>
		</tr>
		<tr>
			<th>쿠폰 선택</th>
			<td>
			<select name="c_id">
			  <c:forEach var="coupon" items="${coupon }">
			    <option value="${coupon.c_id }">${coupon.c_name } </option>
			  </c:forEach>
			</select>
			 </td>
		</tr>
		<tr>
			<td colspan="2" >
			</td>
		</tr>
	</table>
				<input type="button" value="이벤트 수정" onclick="eventMod()">
				<input type="hidden" name="e_id" value="${event.e_id }">
								
	</form>
</div>
<%@include file="common/footer.jspf" %>	

</body>
</html>





