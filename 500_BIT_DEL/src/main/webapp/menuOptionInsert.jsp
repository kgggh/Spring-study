<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	function click_go(){
		var menu_id = $('.menu_id').val();
		var s_id = $('.s_id').val();
		$('.option').click(function(){
			location.href="optionAdd.do";
		});
		$('.sortAdd').click(function(){  //옵션 구분명 추가하기
			var sortName = $(this).prev('.sortName').val();
			location.href="addOptionSort.do?op_s_name="+sortName+"&menu_id="+menu_id;
		});
		$('.goList').click(function(){  //옵션 구분별로 메뉴 List 호출
			var op_s_id = $(this).next('.op_s_id').val();
			location.href="optionSortList.do?op_s_id="+op_s_id+"&menu_id="+menu_id;
		});		
		$('.OptionDelete').click(function(){  //옵션 삭제
        	var result = confirm("정말 삭제하시겠습니까?");
			if(result){
	        	var op_id = $(this).next('.op_id').val();
	        	location.href="disableOption.do?op_id="+op_id+"&menu_id="+menu_id;
			}
		});
        $('.opsortDelete').click(function(){ //메뉴구분 삭제
        	var result = confirm("항목을 삭제하시면 등록된 메뉴도 함께 삭제됩니다. \n정말 삭제하시겠습니까?");
			if(result){
	        	var op_s_id = $(this).next('.op_s_id').val();
	        	location.href="disableOpSort.do?op_s_id="+op_s_id+"&menu_id="+menu_id;
			}
        });
        $('#cancle').click(function(){ //메뉴구분 삭제
        	location.href="setMenuList.do?s_id="+s_id;
        });        
	    $(".click_Option").click(function(){  //추가버튼 클릭시
			var addNum = $(".addNum").last().val();  //마지막번호 값 가져오기
			var num = parseInt(addNum);
		    if($('.addOption').attr("class") == 'addOption onoff'){
		    	num = parseInt(num) - 1;
			}
		    var name = "list[" + num + "].op_name";
		    var price = "list[" + num + "].op_price";
		    var lastItemNo = $(".addOption tr:last").attr("class").replace("item", "");
	       	if($('.addOption').attr("class") == 'addOption onoff'){
			    $(".addOption").removeClass('onoff');  //
			    $('.item1').find('#op_name').attr('name', name);
			    $('.item1').find('#op_price').attr('name', price);
	        }else{
			    var newitem = $(".addOption tr:eq(0)").clone();  // tr복제
			    newitem.removeClass();  //tr 클래스를 지우고
			    newitem.find(".addNum").val(parseInt(addNum)+1);
			    newitem.find('#op_name').attr('name', name);
			    newitem.find('#op_price').attr('name', price);
			    newitem.addClass("item"+(parseInt(lastItemNo)+1));  //새로운 클래스명으로 기존클래스명 +1 을 줌
			    
			    $(".addOption").append(newitem)  //addMenu 마지막에 tr 추가	
	        }
	    });
	    //추가 후 삭제버튼 클릭시
	    $(document).on("click",".delBtn",function(){
	    	var result = confirm("입력된 정보가 삭제됩니다. \n정말 삭제하시겠습니까?");
	        var clickedRow = $(this).parent().parent();
	        var cls = clickedRow.attr("class");
	        var lastItemNo = $(".addOption tr:last").attr("class").replace("item", "");
	        if(result){
		        if(lastItemNo == '1'){
		           $(".addOption").addClass('onoff');
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
<title>옵션등록</title>
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
	<h1>${menu_name }</h1>
<br>
	<div>
		<h2 class="subtitle">ADDOPTION</h2>
	</div>
	<form action="getUpdateOption.do" method="post">
	<h3>CLASSIFICATION</h3>
	<input type="hidden" class="menu_id" value="${menu_id }">
	<input type="hidden" class="s_id" value="${s_id }">
	<div class="menucenter">
	<c:if test="${empty OptionSortList }">  <!-- 옵션이 없으면 -->
		<tr><td colspan="3" class="center">등록된 옵션이 없습니다.</td></tr>
		<br>
		<input type="text" class="sortName">
		<input type="button" class="sortAdd" value="추가">
	</c:if>
	</div>	
	<c:if test="${not empty OptionSortList }">  <!-- 옵션이 있으면 -->
	<div class="menucenter">
		<c:forEach var="optionSort" items="${OptionSortList }"> <!-- 등록된 옵션구분목록 불러오기  -->
			<input type="button" class="opsortDelete" id="sort" value="${optionSort.op_s_name }">
			<input type="hidden" class="op_s_id" id="op_s_id" value="${optionSort.op_s_id }">
		</c:forEach>
		<br>
		<input type="text" class="sortName">
		<input type="button" class="sortAdd" value="추가">
		<h3>OPTION</h3>
		<c:forEach var="optionSort" items="${OptionSortList }"> <!-- 등록된 옵션구분목록 불러오기  -->
			<input type="button" class="goList" id="goList" value="${optionSort.op_s_name }">
			<input type="hidden" class="op_s_id" id="op_s_id" value="${optionSort.op_s_id }">
			
		</c:forEach>
		<br>
	</div>	
		<table>
			<thead>
				<tr>
					<th>NO</th>
					<th>옵션명</th>
					<th>가격</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${empty menuOptionList }">  <!-- 항목에 해당하는 옵션이 없으면 -->
				<td colspan='4'>등록된 메뉴가 없습니다.</td>
				<input type="hidden" name="list[0].menu_id" value="${menu_id }">
				<input type="hidden" name="list[0].op_s_id" value="${op_s_id }">
			</c:if>
			<c:if test="${not empty menuOptionList }">  <!-- 항목에 해당하는 옵션이 있으면 -->
				<c:forEach var="option" items="${menuOptionList}" varStatus="status">
					<tr>
						<td>${status.count }
						<input type="hidden" class="menu_id" name="list[${status.index }].menu_id" value="${option.menu_id }">
						<input type="hidden" class="op_id" name="list[${status.index }].op_id" value="${option.op_id }">
						<input type="hidden" class="op_s_id" name="list[${status.index }].op_s_id" value="${option.op_s_id }">
						
						</td>
						
						<td class="border"><input type="text" id="op_name" class="op_name" name="list[${status.index }].op_name" value="${option.op_name }"></td>
						<td class="border">
							<input type="text" id="op_price" class="op_price" name="list[${status.index }].op_price" value="${option.op_price }">
						</td>
						<td>
							<input type="button" id="OptionDelete" class="OptionDelete" value="삭제">
							<input type="hidden" class="op_id" value="${option.op_id }">
						</td>
					</tr>
					<c:if test="${status.last == true }">
						<c:set var="count" value="${status.count }"/>
					</c:if>
				</c:forEach>
			</c:if>
			</tbody>
			<tbody class="addOption onoff">
				<tr class="item1">
					<td class="border"><input type="text" class="addNum" value="${count+1 }" disabled ></td>
					<td class="border"><input type="text" id="op_name"></td>
					<td class="border"><input type="text" id="op_price"></td>
					<td>
						<input type="button" id="OptionDelete" class="delBtn" value="삭제">
						<input type="hidden" name="op_s_id" value="${op_s_id }">
					</td>
				</tr>
			</tbody>
		<%-- 	</c:if> --%>
			<tfoot>
				<tr>
					<td colspan="4">
						<input type="button" id="optionAdd" class="click_Option" value="추가">
					</td>
				</tr>
			</tfoot>
		</table>
	</c:if>
	<br>
	<div  class="menucenter">
	<input type="submit" id="menuOptionUpdate" value="등록">
	<input type="button" id="cancle" value="취소">
	</div>
	</form>

</div>
<%@include file="common/footer.jspf" %>
</body>
</html>













