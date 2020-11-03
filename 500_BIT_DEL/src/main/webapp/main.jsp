<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<link rel="stylesheet" href="css/main.css">
<!-- <link rel="stylesheet" href="css/newMenu.css"> -->

</head>
<body>

<div id="main">
	<form action="login.jsp" method="post">
		<h1 id="title">BITDELIVERY</h1>
		<div class="center">
		<input type="submit" class="pageButton" name="c_s" value="점주 페이지 ">
		<input type="submit" class="pageButton" name="c_s" value="고객 페이지 ">
		</div>
	</form>	
</div>


</body>
<%@include file="common/footer.jspf" %>
</html>











