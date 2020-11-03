<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/menuList.css">
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$().ready(function(){
		 click_go();
	});
	function click_go(){
	    //next 버튼 : 맨 앞의 이미지를 맨 뒤로 보내기(append() 사용)
	    $(".nextbutton").click(function(){
	        var className = $(this).parent().prev().children().attr("class");
	        var $firstImg = $('.'+className + ' td.imgUl').first();
	        var $firstName = $('.'+className + ' td.name').first();
	        var $firstReference = $('.'+className + ' td.reference').first();
	        
	        $('.'+className + ' tr.imgUl').append($firstImg);
	        $('.'+className + ' tr.name').append($firstName);
	        $('.'+className + ' tr.reference').append($firstReference);
	    });
	    
	    //(실습) prev버튼 : 맨뒤의 이미지를 맨 앞으로 보내기
	    $(".prevbutton").click(function(){
	        var className = $(this).parent().next().children().attr("class");
	        var $lastImg = $('.'+className + ' td.imgUl').last();
	        var $lastName = $('.'+className + ' td.name').last();
	        var $lastReference = $('.'+className + ' td.reference').last();
	        
	        $('.'+className + ' tr.imgUl').prepend($lastImg);
	        $('.'+className + ' tr.name').prepend($lastName);
	        $('.'+className + ' tr.reference').prepend($lastReference);       
	    });
	}
</script>
<meta charset="UTF-8">
<title>메뉴목록</title>
<style>
	
    		
</style>

</head>
<body>
<%@include file="common/menu.jspf" %>

<div id="container">
<br>
	<div>
		<h2 class="subtitle">MENU</h2>
	</div>
	<br>
<%@include file="common/storemenubar.jspf" %>
	<br>	
	<form>
	<h3>대표 메뉴</h3>
	<div class="page">
		<table >
		<c:if test="${empty menuBestList }">
			<tr><td colspan="3" class="center">준비된 상품이 없습니다.</td></tr>
		</c:if>
		</table>
		<c:if test="${not empty menuBestList }">
		<div class="prevBest">
			<a class="prevbutton">이전</a>
		</div>
		<div class="size">
		<table class="best">
			<tr class="imgUl">
			<c:forEach var="menuBest" items="${menuBestList}" varStatus="status"> <!-- 화면에 보여지는 열 갯수  -->
				<td class="imgUl">
					<a href="getMenuOptionList.do?menu_id=${menuBest.menu_id }"><img src="img/${menuBest.menu_photo }" class="listimg" /></a>
				</td>
			</c:forEach>
			</tr>
			<tr class="name">
				<c:forEach var="menuBest" items="${menuBestList}" varStatus="status"> <!-- 화면에 보여지는 열 갯수  -->
					 	<td class="name">
							${menuBest.menu_name }
						</td>
				</c:forEach>
			</tr >
			<tr class="reference">	
			<c:forEach var="menuBest" items="${menuBestList}" varStatus="status"> <!-- 화면에 보여지는 열 갯수  -->
				 <td class="reference">
						${menuBest.menu_reference }
					</td>
			</c:forEach>						
			</tr>
		</table>
		</div>
		<div class="nextBest">
			<a class="nextbutton">다음</a>
		</div>
	</c:if>
	</div>
	<hr>
	<!-- 일반 메뉴 -->
	<c:if test="${empty menuSortList }">  <!-- 메뉴가 없을 때 -->
		<tr><td colspan="3" class="center">준비된 상품이 없습니다.</td></tr>
	</c:if>
	<c:if test="${not empty menuSortList }">
		<c:forEach var="menuSortList" items="${menuSortList }" varStatus="sort"> <!-- 테이블이 만들어지는 갯수 메뉴구분이 3개면 3번 반복 -->
		<%-- <c:forEach var="h" begin="1" end="3" step="1">  --%>
			
			<div class="page"><h3>${menuSortList.m_s_name }</h3>
			<div class="prev">
				<a class="prevbutton">이전</a>
			</div>
			<div class="size">
				<table class="${sort.count }" style="table-layout: fixed">
					<tbody class="simgs">
						<tr class="imgUl">
						<c:forEach var="menu" items="${menuList}" varStatus="status"> <!-- 화면에 보여지는 열 갯수  -->
							<c:if test= '${menuSortList.m_sort_id == menu.m_sort_id }'>  <!-- 메뉴구분에 해당하는 메뉴만 보이기 -->
						 		<td class="imgUl">
									<a href="getMenuOptionList.do?menu_id=${menu.menu_id }"><img src="img/${menu.menu_photo }" class="listimg" /></a>
								</td>
							</c:if>
						</c:forEach>
						</tr>
						<tr class="name">
						<c:forEach var="menu" items="${menuList}" varStatus="status"> <!-- 화면에 보여지는 열 갯수  -->
							<c:if test= '${menuSortList.m_sort_id == menu.m_sort_id }'>  <!-- 메뉴구분에 해당하는 메뉴만 보이기 -->
						 		<td class="name">
									${menu.menu_name }
								</td>
							</c:if>
						</c:forEach>
						</tr >
						<tr class="reference">	
						<c:forEach var="menu" items="${menuList}" varStatus="status"> <!-- 화면에 보여지는 열 갯수  -->
							<c:if test= '${menuSortList.m_sort_id == menu.m_sort_id }'>  <!-- 메뉴구분에 해당하는 메뉴만 보이기 -->
						 		<td class="reference">
									${menu.menu_reference }
								</td>
							</c:if>
						</c:forEach>						
						</tr>
					</tbody>	
				</table>
			</div>
			<div class="next">
				<a class="nextbutton">다음</a>
			</div>
		</div>	
		</c:forEach>
	</c:if>
	</form>

<%@include file="common/footer.jspf" %>
</div>
</body>
</html>