<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	function click_go(){
		var s_id = $('.s_id').val();
		$('.option').click(function(){   //Option 추가 페이지로 이동
			var menu_id = $(this).next('.menu_id').val();
			var menu_name = $(this).nextAll('.menu_name').val();
			location.href="optionAdd.do?menu_id="+menu_id +"&menu_name="+menu_name+"&s_id="+s_id;
		});
		$('.goList').click(function(){  //메뉴 구분별로 메뉴 List 호출
			var m_sort_id = $(this).next('.m_sort_id').val();
			location.href="menuSortList.do?m_sort_id="+m_sort_id+"&s_id="+s_id;
		});
		$('.add_file').change(function(){
			var fileName = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출
			$(this).next('.fileName').val(fileName);
		});
		$(document).on("change",".add_file",function(){  //추가 이벤트에서 사진 변경했을 때
			var fileName = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출
			$(this).next('.fileName').val(fileName);
		});
		$('.sortAdd').click(function(){  //메뉴 구분명 추가하기
			var sortName = $(this).prev('.sortName').val();
			location.href="addSort.do?m_s_name="+sortName+"&s_id="+s_id;
		});
        $('.menuDelete').click(function(){ //메뉴 삭제
        	var result = confirm("목록에서 삭제하시겠습니까?");
			if(result){
	        	var menu_id = $(this).next('.menu_id').val();
	        	location.href="disableMenu.do?menu_id="+menu_id+"&s_id="+s_id;
			}
        });
        $('.sortDelete').click(function(){ //메뉴구분 삭제
        	var result = confirm("항목을 삭제하시면 등록된 메뉴도 함께 삭제됩니다. \n정말 삭제하시겠습니까?");
			if(result){
	        	var m_sort_id = $(this).next('.m_sort_id').val();
	        	location.href="disableMenuSort.do?m_sort_id="+m_sort_id+"&s_id="+s_id;
			}
        });
        $("#click_Menu").click(function(){  //추가버튼 클릭시
	        var addNum = $(".addNum").last().val();  //마지막번호 값 가져오기
	        var num = parseInt(addNum);
	        if($('.addMenu').attr("class") == 'addMenu onoff'){
	        	num = parseInt(num) - 1;
	        }
	        var bestName = "list[" + num + "].menu_best";
	        var name = "list[" + num + "].menu_name";
	        var price = "list[" + num + "].menu_price";
	        var photo = "list[" + num + "].menu_photo";
	        var reference = "list[" + num + "].menu_reference";
	        var lastItemNo = $(".addMenu tr:last").attr("class").replace("item", "");
        	if($('.addMenu').attr("class") == 'addMenu onoff'){
	        	$(".addMenu").removeClass('onoff');  //
	        	$('.item1').find('#best').attr('name', bestName);
	        	$('.item1').find('#m_name').attr('name', name);
	        	$('.item1').find('#menu_price').attr('name', price);
	        	$('.item1').find('#fileName').attr('name', photo);
	        	$('.item1').find('#menu_reference').attr('name', reference);
        	}else{
	            var newitem = $(".addMenu tr:eq(0)").clone();  // tr복제
	            var newitem2 = $(".addMenu tr:eq(1)").clone();
	            newitem.removeClass();  //tr 클래스를 지우고
	            newitem2.removeClass(); 
	            newitem.find(".addNum").val(parseInt(addNum)+1);
	            newitem.find('#best').attr('name', bestName);
	            newitem.find('#m_name').attr('name', name);
	            newitem.find('#menu_price').attr('name', price);
	            newitem.find('#fileName').attr('name', photo);
	            newitem2.find('#menu_reference').attr('name', reference);
	            newitem.addClass("item"+(parseInt(lastItemNo)+1));  //새로운 클래스명으로 기존클래스명 +1 을 줌
	            newitem2.addClass("item"+(parseInt(lastItemNo)+1));
	
	            $(".addMenu").append(newitem).append(newitem2);  //addMenu 마지막에 tr 추가	
        	}
        });

        //추가 후 삭제버튼 클릭시
        $(document).on("click",".delBtn",function(){
        	var result = confirm("입력된 정보가 삭제됩니다. \n정말 삭제하시겠습니까?");
            var clickedRow = $(this).parent().parent();
            var cls = clickedRow.attr("class");
            var lastItemNo = $(".addMenu tr:last").attr("class").replace("item", "");
            if(result){
	            if(lastItemNo == '1'){
	            	$(".addMenu").addClass('onoff');
	            }else{
	            	$('.'+cls+'').remove();
	            }
            }
        });


	}

	 $().ready(function(){

		 click_go();
	 });
 
</script>

<meta charset="UTF-8">
<title>메뉴목록</title>
<style>
	#container {
		width: 700px;
		margin: 0 auto;
	}
	h1, h3, p { text-align: center; }
	table { border-collapse: collapse; }
	table, th, td {
		border: 1px solid black;
		margin: 0 auto;
	}
	th { background-color: orange; }
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }
	
</style>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="common/skr_menu.jspf" %>

<div id="container">
<br>
	<div>
		<h2 class="subtitle">ADDMENU</h2>
	</div>
	<input type="hidden" class="s_id" id="s_id" value="${s_id }">
	<form action="getUpdateMenu.do" method="post">
	<h3>CLASSIFICATION</h3>
	<div class="menucenter">
	<c:if test="${empty menuSortList }">  <!-- 메뉴가 없으면 -->
		<tr><td colspan="3" class="center">등록된 메뉴항목이 없습니다.</td></tr>
		<br>
		<input type="text" class="sortName">
		<input type="button" class="sortAdd" value="추가">
		<br>
	</c:if>
	</div>
	
	<c:if test="${not empty menuSortList }">  <!-- 메뉴가 있으면 -->
	<div class="menucenter">
		<c:forEach var="sort" items="${menuSortList }"> <!-- 등록된 메뉴구분목록 불러오기  -->
			<input type="button" class="sortDelete" id="" value="${sort.m_s_name }  x">
			<input type="hidden" class="m_sort_id" id="m_sort_id" value="${sort.m_sort_id }">
		</c:forEach>
		<br>
		<input type="text" class="sortName">
		<input type="button" class="sortAdd" value="추가">
	
		
		<h3>MENU</h3>
		<c:forEach var="sort" items="${menuSortList }"> <!-- 등록된 메뉴구분목록 불러오기  -->
			<input type="button" class="goList" id="goList" value="${sort.m_s_name }">
			<input type="hidden" class="m_sort_id" id="m_sort_id" value="${sort.m_sort_id }">
		</c:forEach>
		<br>
	</div>
		<table>
			<thead>
				<tr>
					<th style="width:50px;">NO</th>
					<th style="width:70px;">대표메뉴</th>
					<th style="width:200px;">메뉴명</th>
					<th style="width:200px;">가격</th>
					<th colspan='2'>사진</th>
					<th style="width:100px;">옵션</th>
					<th style="width:100px;">삭제여부</th>
				</tr>
			</thead>

	
			<tbody>
			<c:if test="${empty menuList }">  <!-- 항목에 해당하는 메뉴가 없으면 -->
				<td colspan='8'>등록된 메뉴가 없습니다.</td>
				<input type="hidden" name="list[0].s_id" value="${s_id }">
				<input type="hidden" name="list[0].m_sort_id" value="${m_sort_id }">
			</c:if>
			<c:if test="${not empty menuList }">  <!-- 항목에 해당하는 메뉴가 있으면 -->
				<c:forEach var="menu" items="${menuList}" varStatus="status">
					<tr>
						<td>${status.count }
							<input type="hidden" class="menu_id" name="list[${status.index }].menu_id" value="${menu.menu_id }">
							<input type="hidden" class="m_sort_id" name="list[${status.index }].m_sort_id" value="${menu.m_sort_id }">
							
						</td>
						<td><input type="checkbox" id="best" name="list[${status.index }].menu_best" value="1"></td>
						<td class="border"><input type="text" id="m_name" class="m_name" name="list[${status.index }].menu_name" value="${menu.menu_name }"></td>
						<td class="border"><input type="text" id="menu_price" name="list[${status.index }].menu_price" value="${menu.menu_price }"></td>
						<td colspan='2'>
						<c:if test="${empty menu.menu_photo }">
							<input type="file" id="file" class="add_file" >
							<input type="hidden" id="fileName" class="fileName" name="list[${status.index }].menu_photo" value="${menu.menu_photo }">
						</c:if>
						<c:if test="${not empty menu.menu_photo }">
							<img src="img/${menu.menu_photo }" class="listimg"/>
							<br>
							<input type="file" id="file" class="add_file" >
							<input type="hidden" id="fileName" class="fileName" name="list[${status.index }].menu_photo" value="${menu.menu_photo }">
						</c:if>		
						</td>
						<td>
							<input type="button" id="option" class="option" value="등록">
							<input type="hidden" class="menu_id" value="${menu.menu_id }">			
							<input type="hidden" class="menu_name" value="${menu.menu_name }">			
						</td>
						<td>
							<input type="button" id="menuDelete" class="menuDelete" value="판매종료">
							<input type="hidden" class="menu_id" value="${menu.menu_id }">
						</td>
					</tr>
					<tr>
						<td colspan="2">상세 설명</td>
						<td colspan="6" class="border">
						<textarea rows="5" cols="50" name="list[${status.index }].menu_reference" >${menu.menu_reference }</textarea>
						</td>
					</tr>
						<c:if test="${status.last == true }">
							<c:set var="count" value="${status.count }"/>
						</c:if>
				</c:forEach>
			</c:if>
			</tbody>
			<tbody class="addMenu onoff" >  <!-- 추가 부분 -->
				<tr class="item1">	
			<!-- 	<tr> -->
					<td class="border"><input type="text" class="addNum" value="${count+1 }" disabled >
					<input type="hidden" class="s_id" name="list[0].s_id" value="${s_id }">
					</td>
					<td class="border"><input type="checkbox" id="best"  value="1"></td>
					<td><input type="text" id="m_name" ></td>
					<td><input type="text" id="menu_price" ></td>
					<td colspan='2'>
						<input type="file" id="file" class="add_file" >
						<input type="hidden" id="fileName" class="fileName" >		
					</td>
					<td colspan='2'><input type="button" id="delBtn" class="delBtn" value="삭제"></td>
				</tr>
				<tr class="item1">
				<!-- <tr class="onoff"> -->
					<td colspan="2">상세 설명</td>
					<td colspan="6" class="border">
					<textarea rows="5" cols="50" id="menu_reference" >${menu.menu_reference }</textarea>
					</td>
				</tr>
			</tbody> 
		<%-- 	</c:if> --%>
			<tfoot>
				<tr>
					<td colspan="8">
						<input type="button" id="click_Menu" value="추가">

					</td>
				</tr>
			</tfoot>
		</table>
	</c:if>
	<div  class="menucenter">
	<input type="submit" id="menuUpdate" class="center" value="등록">
	<input type="submit" id="cancle" class="center" value="취소">
	</div>
	</form>

</div>

<%@include file="common/footer.jspf" %>
</body>
</html>













