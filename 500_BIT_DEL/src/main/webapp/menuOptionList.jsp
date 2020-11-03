<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" href="css/menuList.css">
<meta charset="UTF-8">
<title>메뉴목록</title>
<script>
	function click_go(){
		var totalPrice = 0;
		var opSortCount = $('#opSortCount').val();
		var opCount = $('#opCount').val();
		var amount = $('#amount').val();
		$('#remove').click(function(){
			if(amount == 1){
				alert("최소 수량 입니다. ");
				$('#amount').val(amount);
			}else{
				amount = parseInt(amount) - 1;
				$('#amount').val(amount);
				changeRadioValues();
			}
		});
		$('#add').click(function(){			
			amount = parseInt(amount) + 1;
			$('#amount').val(amount);
			changeRadioValues();
		});		
		function select(){
			for(var i=1; i<=opCount; i++){
				if($('#select'+i+'').is(':checked') == true){
					$('#select'+i+'').next('.op_id').first().attr("checked", true);
					$('#select'+i+'').nextAll('.op_price').first().attr("checked", true);
					$('#select'+i+'').nextAll('.menu_id').first().attr("checked", true);
				}
			}
		}
		//radio 관련
		if(opSortCount == 0 ){
			totalPrice = 0;
			$('#totalPrice').val(totalPrice);
		}
		for(var i=1; i<=opSortCount; i++){
			$('input[name="select'+i+'"]').eq(0).attr("checked", true);
			select();
			changeRadioValues();
			$('.select'+i+'').change(function(){
				for(var i=0; i<=opCount; i++){
					$('.op_id').eq(i).attr("checked", false);
					$('.op_price').eq(i).attr("checked", false);
					$('.menu_id').eq(i).attr("checked", false);		
				}
				select();
				changeRadioValues();
			});
		}
		function changeRadioValues(){
			totalPrice = 0;			
	 		for(var j=1; j<=opSortCount; j++){
	 			var st = $('input[name="select'+ j +'"]:checked').val();
	 			totalPrice += (parseInt(st) * parseInt(amount));
	 		}
	 		$('#totalPrice').val(totalPrice);
	 		
		}
	
		
	}

	$().ready(function(){
		click_go();
	});
</script>
<style>
	#container {
		width: 700px;
		margin: 0 auto;
		text-align: center;
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
<%@include file="common/menu.jspf" %>

<div id="container">
	<h1>${menu.menu_name}</h1>
<br>
	<div>
		<h2 class="subtitle">OPTION</h2>
	</div>
	<br>
	<form action="getGoCartOrder.do" method="post">
	
	<input type="hidden" id="opSortCount" value="${opSortCount }">
	<input type="hidden" id="opCount" value="${opCount }">
	<c:forEach var="optionsort" items="${OptionSortList }" varStatus="sortStatus"> <!-- 옵션 구분 갯수(옵션 있는 만큼 반복) --> 
	<h3>${optionsort.op_s_name }</h3> 
	
		<c:forEach var="option" items="${menuOptionList }" varStatus="status"><!-- 옵션 메뉴 갯수 (옵션 갯수 만큼 반복) -->
			<c:if test= '${optionsort.op_s_id == option.op_s_id}'>
			
				<input type="radio" class="select${sortStatus.count }" id="select${status.count }" name="select${sortStatus.count }" value="${option.op_price }">${option.op_name }: ${option.op_price } 원
				<input style="display:none" type="radio" class="op_id" name="CartList[${sortStatus.index }].op_id" value="${option.op_id }" >
				<input style="display:none" type="radio" class="op_price" name="CartList[${sortStatus.index }].op_price" value="${option.op_price }">
				<input style="display:none" type="radio" class="menu_id" name="CartList[${sortStatus.index }].menu_id" value="${menu_id }">
				<input type="hidden" class="s_id" name="CartList[${sortStatus.index }].s_id" value="${menu.s_id }">
			</c:if>
		</c:forEach>
	</c:forEach>
	<br>
	<br>
	<label for="amount">수량</label>
	<button type="button" id="remove"> - </button>
	<input type="text" id="amount" name="CartList[0].b_amount" value="1" >
	<button type="button" id="add"> + </button>

<%-- 	<select id="amount" name="" >
		<c:forEach var="number" begin="1" end="10" step="1">
			<option value="${number }">${number}</option>
		</c:forEach>
	</select>	 --%>
	<h3>총 금액 : <input type="text" id="totalPrice" name="CartList[0].b_price" ></h3>
	<button type="submit" id="cart" name="cart">장바구니</button>
	<button type="submit" id="order" name="order">주문하기</button>
	</form>

</div>

<%@include file="common/footer.jspf" %>
</body>
</html>