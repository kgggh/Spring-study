<%@page import="com.spring.delivery.notice.service.NoticeVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- DB데이터 조회하고 조회된 데이터 화면 출력 --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>
<link rel="stylesheet" href="css/slide.css">
<link rel="stylesheet" href="css/footer.css">
<link rel="stylesheet" href="css/notice.css">
	
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script src="js/menu.js"></script>
<script src="js/slide.js"></script>

<script>
	function insertNotice() {
		location.href = "insertNoticeForm.do";
		}
</script>
</head>
<c:if test="${loginMember.c_s != 0 }">
	<%@include file="common/menu.jspf" %>
</c:if>
<c:if test="${loginMember.c_s == 0 }">
	<%@include file="common/skr_menu.jspf" %>
</c:if>
<body>
<div id="container">
	<br>
	<div>
		<h2 class="subtitle">NOTICE</h2>
	</div>
	<br>
	<!-- 검색을 위한 폼 -->
	<form action="getSearchNoticeList.do" method="post">
	<table class="border-none">
		<tr>
			<td>
				<select name="searchCondition" id="searchCondition">
				<c:forEach var="option" items="${conditionMap }">
					<option value="${option.value }">${option.key }</option>
				</c:forEach>
				</select>
				<input type="text" name="searchKeyword" id="searchKeyword" value="${searchKeyword }">
				<input type="submit" id="searchbutton" value="검색">
			<td>
		</tr>
	</table>
	</form> 
	<br>
	
	<!-- 데이터 표시 영역 -->
	<table class="bbs" border="1" >
		<caption>공지사항 리스트</caption>
			<colgroup>
				<col width="100">
				<col>
				<col width="110">
				<col width="100">
				<col width="80">
			</colgroup>
			<thead>
				<tr>
					<th width="col">번호</th>
					<th width="col">제목</th>
					<th width="col">작성일</th>
					<th width="col">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty noticeList }">
					<tr><td colspan="5" class="center">공지사항이 없습니다</td></tr>
				</c:if>
				<c:if test="${not empty noticeList }">
					<c:forEach var="notice" items="${noticeList }">
					<tr>
						<td class="idx">${notice.r_num }</td>
						<td class="title">
							<a href="getNotice.do?n_id=${notice.n_id }">${notice.n_title }</a>
						</td>
						<td class="date">${notice.n_date  }</td>
						<td class="hit">${notice.n_hit }</td>
					</tr>
					</c:forEach>
				</c:if>
			</tbody>
			</table>
			
				<table>
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
										<a href="getNoticeList.do?&cPage=${pvo.beginPage - 1 }"> < </a>
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
										<a href="getNoticeList.do?&cPage=${pageNo }">${pageNo }</a>
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
									<li><a href="getNoticeList.do?&cPage=${pvo.endPage + 1}"> > </a></li>
								</c:otherwise>
							</c:choose>
							</ol>
						</td>
					</tr>
				</table>

	<div class="center">			
	<c:if test="${loginMember.id == 'admin' }">			
		<input type="button" id="golist" value="공지사항 등록" onclick="insertNotice()">
	</c:if>

	</div>
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>







