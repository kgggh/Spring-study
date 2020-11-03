<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/review.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>리뷰관리</title>

</head>
<script>


</script>
<style>

.star-rating {width:304px; }
.star-rating,.star-rating span {display:inline-block; height:55px; overflow:hidden; background:url(img/star.png)no-repeat; }
.star-rating span{background-position:left bottom; line-height:0; vertical-align:top; }
</style>
<%@include file="common/skr_menu.jspf" %>
<body>
	<div id="container">
<br>
	<div>
		<h2 class="subtitle">REVIEW</h2>
	</div>
	<br>

	<div id="review_logo">
		<table border="1">
			<tr>
				<td rowspan="3">
					<img src="img/${svo.s_photo}">
				</td>
				<td>
					${svo.s_name}
				</td>
				<td>
					평점
				</td>
				<td>
					<div class="wrap-star">
	   					 <div class='star-rating'>
	       				 <c:if test="${s_avg lt 1}">
	       				 	<span style ="width:0%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg lt 2}">
	       				 	<span style ="width:20%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg lt 3}">
	       				 	<span style ="width:40%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg lt 4}">
	       				 	<span style ="width:60%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg lt 5}">
	       				 	<span style ="width:80%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg eq 5}">
	       				 	<span style ="width:100%"></span>
	       				 </c:if>
	   					</div>
	   				</div>
				</td>
				<td>
					${s_avg}
				</td>
			</tr>
			<tr>
				<td>
					같은업종(${s_classification})
				</td>
				<td>
					평점
				</td>
				<td>
					<div class="wrap-star">
	   					 <div class='star-rating'>
	       				 <c:if test="${s_avg lt 1}">
	       				 	<span style ="width:0%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg lt 2}">
	       				 	<span style ="width:20%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg lt 3}">
	       				 	<span style ="width:40%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg lt 4}">
	       				 	<span style ="width:60%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg lt 5}">
	       				 	<span style ="width:80%"></span>
	       				 </c:if>
	       				 <c:if test="${s_avg eq 5}">
	       				 	<span style ="width:100%"></span>
	       				 </c:if>
	   					</div>
	   				</div>
				</td>
				<td>
					${c_avg}
				</td>
			</tr>
			<tr>
				<td colspan="5">
					우리가게는 같은 업종에 비해 평점 높음!!!
				</td>
			</tr>
		</table>
	</div>
	<div id="review_C" class="center">
		<form action="skr_review_null.do" method="POST">
			<input type="hidden" name="s_id" value="${svo.s_id}">
			<input type="hidden" name="s_classification" value="${svo.s_classification}">
			<input type="submit"  class="review_C" id="review_C1" value="사장님 답글이 필요해요">
		</form>
		<form action="skr_review_notnull.do" method="POST">
			<input type="hidden" name="s_id" value="${svo.s_id}">
			<input type="hidden" name="s_classification" value="${svo.s_classification}">
			<input type="submit" class="review_C"  value="사장님 답글이 달렸어요">
		</form>
	</div>
	<div>
		<table>
			<c:forEach var="srvolist" items="${srvo}">
			<from action="" method="POST">
			<tr>
				<td>${srvolist.id }</td>
				<td>${srvolist.r_write_date}</td>
				<td>
						 <div class="wrap-star">
	   					 <div class='star-rating'>
	       				 <c:if test="${srvolist.r_avg lt 1}">
	       				 	<span style ="width:0%"></span>
	       				 </c:if>
	       				 <c:if test="${srvolist.r_avg lt 2}">
	       				 	<span style ="width:20%"></span>
	       				 </c:if>
	       				 <c:if test="${srvolist.r_avg lt 3}">
	       				 	<span style ="width:40%"></span>
	       				 </c:if>
	       				 <c:if test="${srvolist.r_avg lt 4}">
	       				 	<span style ="width:60%"></span>
	       				 </c:if>
	       				 <c:if test="${srvolist.r_avg lt 5}">
	       				 	<span style ="width:80%"></span>
	       				 </c:if>
	       				 <c:if test="${srvolist.r_avg eq 5}">
	       				 	<span style ="width:100%"></span>
	       				 </c:if>
	   					</div>
	   				</div>
	   			</td>
	   			<td>${srvolist.r_avg}</td>
			</tr>
			<tr>
				<td colspan="4" class="center">
				 <img src="img/${srvolist.r_photo }" class="reviewimg">
				</td>
			</tr>
			<tr>
				<td colspan="4" style=" height: 120px;">
					${srvolist.r_content}
				</td>
			</tr>
			<tr>
				<td colspan="4" style=" height: 120px;" class="center">
				<form action="skr_content.do" method="POST">
					<input type="hidden" name="s_id" value="${svo.s_id}">
					<input type="hidden" name="s_classification" value="${svo.s_classification}">
					<input type="hidden" name="r_id" value="${srvolist.r_id }">
					<input type="text" id="skr_content"  name="skr_content" >
					<input type="submit" id="reviewbutton" value="답글달기">
				</form>
				</td>
			</tr>
			</from>
			</c:forEach>
		</table>
	</div>
</div>
</body>
<%@include file="common/footer.jspf" %>
</html>











