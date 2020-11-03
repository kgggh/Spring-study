<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="css/review.css" rel="stylesheet" type="text/css">
<head>
<meta charset="UTF-8">
<title>쿠폰등록</title>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>
<script>

$(document).ready(function(){
	$("#cpSave").click(function(){
		
		var c_name = $("#c_name").val();
		var c_classification = $("#c_classification").val();
		var c_salesprice = $("#c_salesprice").val();
		var c_endperiod = $("#c_period").val();
		var c_endperiod = $("#c_endperiod").val();
		
		
		if(c_name == ""){
			alert("쿠폰명을 입력하세요");
			document.cpform.c_name.focus();
			return;
		}
		
		
		if(c_salesprice == ""){
			alert("원을 제외한 금액 예)3000");
			document.cpform.c_salesprice.focus();
			return;
		}
		
		if(c_endperiod ==""){
			alert("잘못입력하셨습니다.");
			document.cpform.c_endperiod.focus();
			return;
		}
		alert("쿠폰등록완료!!");
		document.cpform.submit();
		
		});
	});
	
	function checkInputNum(){
	      if ((event.keyCode < 48) || (event.keyCode > 57)){
	          event.returnValue = false;
	      }
	  }
	
</script>
<style>
	p{
		
	}
	#coupon{
		display : flex;
		align-items: center;
		justify-content: center;
		
	}
	#couponP{
	color: #215cb5;
	font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
	font-style: italic;
	text-align: center;
	font-size: 200%;
	}
	.subtitle{
	clear: both;
    width: 218px;
    margin: auto;
    text-align: center;
    border: 1px solid #e5e5e5;
    height: 30px;
    line-height: 30px;
    font-size: 1em;
}
</style>
</head>
<%@include file="common/menu.jspf" %>

<body>
<br>
	<div>
		<h2 class="subtitle">ADDCOUPON</h2>
	</div>
	<br>
<div id="coupon">
<form name="cpform" action="couponIns.do" method="post">
	<p>쿠폰명 : <input type="text" id="c_name" name="c_name" placeholder="쿠폰명을 입력해주세요." ></p>
	<p>쿠폰업종구분
	<select name="c_classification">
	   		 <option value="1">한식 </option>
	   		 <option value="2">중식 </option>
	   		 <option value="3">양식 </option>
	</select>
	</p>
	<p>할인가 : <input type="number" id="c_salesprice" name="c_salesprice" placeholder="할인가를 입력해주세요." onkeyPress="javascript:checkInputNum();"></p>
	<p>쿠폰 유효기간 : <input type=date id="c_period"  name="c_period"  readonly="readonly">~<input type="date" id="c_endperiod" name="c_endperiod" max="9999-12-31" ></p>
	<div class="center">
	<button type="button" id="cpSave">쿠폰등록</button>
	</div>
</form>

<br><br>
</div>

<%@include file="common/footer.jspf" %>
</body>
<script>


document.getElementById('c_period').value = new Date().toISOString().substring(0, 10);
document.getElementById('c_endperiod').value = new Date().toISOString().substring(0, 10);

</script>
</html>







