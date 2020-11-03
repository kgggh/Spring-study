<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/review.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>점포별 리뷰</title>
<style>
 .star-rating {width:304px; }
.star-rating, .star-rating span {display:inline-block; height:55px; overflow:hidden; background:url(img/star.png)no-repeat; }
.star-rating span{background-position:left bottom; line-height:0; vertical-align:top; }
</style>
</head>
<body>
<%@include file="common/menu.jspf" %>
	<div id="container">
<br>
	<div>
		<h2 class="subtitle">REVIEW</h2>
	</div>
	<br>
<%@include file="common/storemenubar.jspf" %>
	<form action="storeReview.do" method="post">
		<table id="review_logo">
			<thead>
				<tr>
					<th>리뷰보기</th>
				</tr>
				<tr>
					<td colspan="3">
					<div class="center">
						<img src="img/${svo.s_photo}" class="reviewimg">
						<p>${svo.s_name} 평점 | ${USAvg }</p>
					</div>
						<div class="wrap-star">
		   					 <div class='star-rating'>
		       				 <c:if test="${USAvg lt 1}">
		       				 	<span style ="width:0%"></span>
		       				 </c:if>
		       				 <c:if test="${USAvg lt 2}">
		       				 	<span style ="width:20%"></span>
		       				 </c:if>
		       				 <c:if test="${USAvg lt 3}">
		       				 	<span style ="width:40%"></span>
		       				 </c:if>
		       				 <c:if test="${USAvg lt 4}">
		       				 	<span style ="width:60%"></span>
		       				 </c:if>
		       				 <c:if test="${USAvg lt 5}">
		       				 	<span style ="width:80%"></span>
		       				 </c:if>
		       				 <c:if test="${USAvg eq 5}">
		       				 	<span style ="width:100%"></span>
		       				 </c:if>
		   					</div>
	   					</div> 
					</td>
				</tr>
				<tr>
					<td>
						리뷰갯수:${reviewTot }
						답글갯수:${skrReviewTot }
					</td>
				</tr>
			</thead>
			<tbody >
				<c:forEach var="review" items="${reviewList}" varStatus="status">
					<tr>
						<td>
							<p>회원 아이디: ${review.id }</p>
							<p>작성날짜: ${review.r_write_date}</p>
							<div class="wrap-star">
			   					<div class='star-rating'>
			       				 <c:if test="${review.r_avg lt 1}">
			       				 	<span style ="width:0%"></span>
			       				 </c:if>
			       				 <c:if test="${review.r_avg lt 2}">
			       				 	<span style ="width:20%"></span>
			       				 </c:if>
			       				 <c:if test="${review.r_avg lt 3}">
			       				 	<span style ="width:40%"></span>
			       				 </c:if>
			       				 <c:if test="${review.r_avg lt 4}">
			       				 	<span style ="width:60%"></span>
			       				 </c:if>
			       				 <c:if test="${review.r_avg lt 5}">
			       				 	<span style ="width:80%"></span>
			       				 </c:if>
			       				 <c:if test="${review.r_avg eq 5}">
			       				 	<span style ="width:100%"></span>
			       				 </c:if>
			   					</div>
			   				</div>
			   				<div class="center">
			   				<img src="img/${review.r_photo }"  alt="음식사진" class="reviewimg">
			   				<p>리뷰내용 : ${review.r_content}</p>
			   				<p>답글내용 : ${review.skr_content}</p>
			   				</div>
						</td>
					</tr>
				</c:forEach>		
			</tbody>
			<tfoot>
				<tr>
					<td colspan="12" >
						<ol class="paging">
						<c:choose><%--[이전으로]에 대한 사용여부처리 --%>
							<%--사용불가(disable) 또는 안보이게(hidden) : 첫번째 블록인 경우 --%>
							<c:when test="${pvo.beginPage == 1}">
								<li class="disable left"> < </li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="ReviewList.do?s_id=1&cPage=${pvo.beginPage - 1 }"> < </a>
								</li>
							</c:otherwise>
						</c:choose>
						<%-- 블록내에 표시할 페이지 태그 작성(시작페이지~끝페이지) --%>
						<c:forEach var="pageNo" begin="${pvo.beginPage }" end="${pvo.endPage }">	
						<c:choose>
							<c:when test="${pageNo == pvo.nowPage }">
							<li class="now">${pageNo }</li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="ReviewList.do?s_id=1&cPage=${pageNo }">${pageNo }</a>
								</li>
							</c:otherwise>
						</c:choose>		
						</c:forEach>	
						<c:choose><%--[다음으로]에 대한 사용여부처리 --%>
							<%--사용불가(disable) 또는 안보이게(hidden) : 마지막 블록인 경우
								endPage가 전체페이지수와 같거나 큰 경우 --%>
							<c:when test="${pvo.endPage >= pvo.totalPage }">
								<li class="disable"> > </li>
							</c:when>
							<c:otherwise>
								<li><a href="ReviewList.do?s_id=1&cPage=${pvo.endPage + 1 }"> > </a></li>
							</c:otherwise>
						</c:choose>
						</ol>
					</td>
				</tr>
			</tfoot>			
		</table>
	</form>	
	</div>
</body>
<%@include file="common/footer.jspf" %>
</html>