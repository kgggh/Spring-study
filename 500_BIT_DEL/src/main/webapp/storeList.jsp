<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$().ready(function(){
		click_go();
	});	
	
	function click_go(){
		$(".inputAdd").click(function(){
			var writeAdd = $(".writeAdd").val();
			var s_classification = $(".s_classification").val();
			$(".add").val(writeAdd);
			var dong = $(".add").val();
			location.href="storeList.do?dong="+dong+"&s_classification="+s_classification; 
			 
		});
		$(".openPopup").click(function(){
			$('.modal').show();
			 
		});
		
	}
</script>
<meta charset="UTF-8">
<title>점포목록</title>
<style>


		
</style>

</head>
<link href="css/style.css" rel="stylesheet" type="text/css">
<body>
<%@include file="common/menu.jspf" %>

<div id="container">
<br>
	<div>
		<h2 class="subtitle">STORE</h2>
	</div>
	<br>
	<div id="drop">
	<!-- 찜하기 체크 -->
	<br>
        <ul id="nav">
            <li><a href="storeList.do?s_classification=0" class="active" style=" width:100px;"><span>전체</span></a></li>
        	<li><a href="storeList.do?s_classification=1" style="width:100px;"><span>한식</span></a>
        	<li><a href="storeList.do?s_classification=2" style="width:100px;"><span>양식</span></a>
        	<li><a href="storeList.do?s_classification=3" style="width:100px;"><span>중식</span></a>
        	<li><a href="storeList.do?s_classification=4" style="width:100px;"><span>치킨</span></a>
        	<li><a href="storeList.do?s_classification=5" style="width:100px;"><span>피자</span></a>
        </ul>
	</div>
	<br>
	<div dir="rtl">
	<select  id="pack" name="pack" >
		<option value="1">포장/배달</option>
		<option value="2">포장가능</option>
	</select>
	
	<select id="sort" name="sort" >
		<option value="1">별점순</option>
		<option value="2">주문수</option>
		<option value="3">배달팁(낮은순)</option>
	</select>
	</div>
	<br>
	<input type="hidden" class="s_classification" value="${s_classification }">
	<div class="modal">
    	<div class="layerpop">
				 <input type="text" class="writeAdd" value="">
      			<button type="button" class="inputAdd" >입력</button>
  		</div>
	</div>

	<div class="popup" >
	  <p >배달지명 <input type="text" class="add" name="dong" value="${dong }" disabled>
	  		<input type="button" value="배달지 변경" class="openPopup" /></p>
	</div>
	
	
	<!-- 광고구간 -->
	<c:if test= "${nullcheck ==1 }">
		<p>현재 배송가능한 점포가 없습니다.</p>
	</c:if>
	<c:if test= "${nullcheck ==0 }">
	<p>울트라콜 광고</p>
	<table class="border">
		<tr>
			<td colspan = '3'><a href="#"><img src="img/${storeList.get(0).s_photo }" class="listimg" /></a></td>
			<td colspan = '3'><a href="#"><img src="img/${storeList.get(0).s_photo }" class="listimg" /></a></td>
			<td colspan = '3'><a href="#"><img src="img/${storeList.get(0).s_photo }" class="listimg" /></a></td>
			<td colspan = '3'><a href="#"><img src="img/${storeList.get(0).s_photo }" class="listimg" /></a></td>
		</tr>
		<tr>
			<td><a href="setFavorite.do?s_classification=${s_classification }&s_id=${storeList.get(i).s_id}"><img src="img/heart2.PNG" class="photo" /></a></td>
			<td>${storeList.get(0).s_name }</td>
			<td><img src="img/pack.PNG" class="photo" /></td>
			<td><a href="setFavorite.do?s_classification=${s_classification }&s_id=${storeList.get(i).s_id}"><img src="img/heart.PNG" class="photo" /></a></td>
			<td>${storeList.get(2).s_name }</td>
			<td></td>
			<td><a href="setFavorite.do?s_classification=${s_classification }&s_id=${storeList.get(i).s_id}"><img src="img/heart2.PNG" class="photo" /></a></td>
			<td>${storeList.get(4).s_name }</td>
			<td></td>
			<td><a href="setFavorite.do?s_classification=${s_classification }&s_id=${storeList.get(i).s_id}"><img src="img/heart2.PNG" class="photo" /></a></td>
			<td>${storeList.get(5).s_name }</td>
			<td></td>
		</tr>
	</table>
	<hr>
	<!-- 광고X-->
		<!-- 열 수 정하기  -->
		<c:if test= "${storeListsize <= 4 }">
			<c:set var="finish" value="0"/> 
		</c:if>
		<c:if test= "${storeListsize >= 5 && storeListsize <= 8  }">
			<c:set var="finish" value="1"/> 
		</c:if>		
		<c:if test= "${storeListsize >= 9 && storeListsize <= 12 }">
			<c:set var="finish" value="2"/> 
		</c:if>		
	<table class="border">
		<c:set var="start" value="0"/> 
		<c:forEach var="j" begin="0" end="${finish }"> <!-- 열 반복 -->
			<c:if test= "${j == 0 }">
				<c:set var="size" value="3"/> 
			</c:if>
			<c:if test= "${storeListsize < 4 }">
				<c:set var="size" value="${storeListsize -1}"/>  
			</c:if>	
			<tr>
			<c:forEach var="i" begin="${start }" end="${size }" varStatus="status"> <!-- 행 갯수 -->
				<td colspan = '3'><a href="getMenuList.do?s_classification=${s_classification }&s_id=${storeList.get(i).s_id}"><img src="img/${storeList.get(i).s_photo }" class="listimg" /></a></td>
			</c:forEach>
			</tr>
			<tr>
			<c:forEach var="i" begin="${start }" end="${size }">
				<c:set var="favoriteTrue" value="0"/> <!-- 찜있는지 체크 -->
				<c:forEach var="favorite" items="${favoriteList }" varStatus="">
					<c:if test= "${storeList.get(i).s_id == favorite.s_id }">  <!-- 찜 눌렀으면  -->
						<td><a href="delFavorite.do?s_classification=${s_classification }&s_id=${favorite.s_id}"><img src="img/heart.PNG" class="photo" /></a></td>
						<c:set var="favoriteTrue" value="1"/>  
					</c:if>
				</c:forEach>
					<c:if test= "${favoriteTrue != 1 }">  <!-- 찜 안눌렀으면 -->
						<td><a href="setFavorite.do?s_classification=${s_classification }&s_id=${storeList.get(i).s_id}"><img src="img/heart2.PNG" class="photo" /></a></td>
					</c:if>
				<td>${storeList.get(i).s_name }</td>
				<c:if test= "${storeList.get(i).s_pack == 1 }">  <!-- 포장이 가능하면 -->
					<td><img src="img/pack.PNG" class="photo" /></td>
				</c:if>
				<c:if test= "${storeList.get(i).s_pack == 0 }">  <!-- 포장이 불가능하면 -->
					<td></td>
				</c:if>
				<c:if test= "${i == 3 }">  <!-- 1행이 완료되면 -->
					<c:set var="check" value="3"/> 
				</c:if>
				<c:if test= "${i == 7 }">  <!-- 1행이 완료되면 -->
					<c:set var="check" value="7"/> 
				</c:if>
			</c:forEach>
			</tr>
			<c:if test= "${check == 3 }">  <!-- 1행이 완료되면 -->
				<c:set var="size" value="7"/>
				<c:set var="start" value="4"/> 
				<c:if test= "${storeListsize < 8 }">
					<c:set var="size" value="${storeListsize -1}"/> 
				</c:if>								
			</c:if>

			<c:if test= "${check == 7 }">  <!-- 2행이 완료되면 -->
				<c:set var="size" value="11"/>
				<c:set var="start" value="8"/>  
				<c:if test= "${storeListsize < 12 }">
					<c:set var="size" value="${storeListsize -1}"/> 
				</c:if>			
			</c:if>	
		</c:forEach>
		
		<!-- 페이지 처리구간 -->
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
							<li class="left">
								<a href="storeList.do?s_classification=${s_classification }&cPage=${pvo.beginPage - 1 }"> < </a>
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
								<a href="storeList.do?s_classification=${s_classification }&cPage=${pageNo }">${pageNo }</a>
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
							<li><a href="storeList.do?s_classification=${s_classification }&cPage=${pvo.endPage + 1 }"> > </a></li>
						</c:otherwise>
					</c:choose>
					</ol>
				</td>
			</tr>

		</tfoot>	
	</table>
	</c:if>
	
	

<%@include file="common/footer.jspf" %>
</div>
</body>
</html>