<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/review.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>리뷰</title>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
function click_go(){
	$('.reviewWrite').click(function(){  //메뉴 구분별로 메뉴 List 호출
		var s_id = $(this).next('.s_id').val();
		var menu_name = $(this).nextAll('.menu_name').first().val();
		var sco_num = $(this).prev('.sco_num').val();
		location.href="reviewWrite.do?s_id="+s_id+"&sco_num="+sco_num+"&menu_name="+menu_name;
	});
	$('.reviewDel').click(function(){  //메뉴 구분별로 메뉴 List 호출
		var r_id = $(this).next('.r_id').val();
		location.href="reviewDelete.do?r_id="+r_id;
	});
}
$().ready(function(){

	 click_go();
});
function reviewDel(){
	location.href="reviewDel.do";
}
</script>
<style>
#page {
        width: 80%; margin: auto;
        /* border: 1px solid black; */
   	}
   	
#container{
	text-align: center;
	}
table {
        width: 100%;
        border-collapse: collapse;
        caption-side: bottom; /* 캡션 위치 조정 */
    	border: 2px solid lightgray;
		}
th{
        border: 2px solid lightgray;
        text-align: left; 
    }
</style>
</head>
<%@include file="common/menu.jspf" %>
<body>
	<div id="container">
<br>
	<div>
		<h2 class="subtitle">ADMINREVIEW</h2>
	</div>
	<br>
	<form action="userReviewShow.do" method="post">
		<table id="tb1">
		<!-- 작성 가능한 리뷰 -->
			<tr>
				<th colspan="3"> 작성 가능한 리뷰</th> 
			</tr>
			<c:forEach var="write" items="${writeList}" varStatus="status">
			
			<tr>
				<td rowspan="2"> 그림</td> 
				<td><p>${write.s_name }</p></td> 
				<td rowspan="2"> 
					<input type="hidden" class="sco_num" value="${write.sco_num}">
					<input type="button" class="reviewWrite" value="리뷰쓰기" onclick="goReviewWrite()">
					<input type="hidden" class="s_id" value="${write.s_id}">
					<input type="hidden" class="menu_name" value="${write.menu_name}">
				</td> 
			</tr>
			<tr>
				<td>${write.menu_name } </td>
			</tr>
		</c:forEach>
	
		</table>	
		<br>
		<!-- 작성한 리뷰 -->	
		<table>
			<tbody>
			<tr> 
				<th colspan="3">작성한 리뷰 </th>
			</tr>
			
			<c:forEach var="review" items="${reviewList}" varStatus="status">
			<tr>
				<td rowspan="2"> 그림</td>
			<td>${review.s_name }</td>
				<td rowspan="4"> 
					<input type="button" value="삭제" class="reviewDel">
					<input type="hidden" value="${review.r_id }" class="r_id">
				
				</td>
			</tr>
			<tr>
			 <td>${review.r_write_date }</td>
			</tr>
			<tr>
			 <td>${review.menu_name }</td>
			 <td >${review.r_avg }</td>
			</tr>
			<tr>
			 <td colspan="3">${review.r_content } </td>
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
								<li class="disable"> < </li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="reviewAdministrate.do?cPage=${pvo.beginPage - 1 }"> < </a>
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
									<a href="reviewAdministrate.do?cPage=${pageNo }">${pageNo }</a>
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
								<li><a href="reviewAdministrate.do?cPage=${pvo.endPage + 1 }"> > </a></li>
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

<script>
	$('.starRev span').click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  return false;
	});
</script>
</html>















