<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<script>
function click_go(){
	var cartMenuListSize = $('#cartMenuListSize').val();
	var b_price = 0;
	var onePrice = 0;
	var oneAmount = 0;
	changeRadioValues();
	$('.remove').click(function(){
		var amount = $(this).next('.b_amount').val();
		if(amount == 1){
			alert("최소 수량 입니다. ");
			$('.b_amount').val(amount);
		}else{
			amount = parseInt(amount) - 1;
			$(this).next('.b_amount').val(amount);
			amount = $(this).next('.b_amount').val();
			oneAmount = $(this).nextAll('.amount').first().val();
			b_price = $(this).parent().prev().children('.price').val();
			onePrice = parseInt(b_price) / parseInt(oneAmount);
			var changPrice = parseInt(onePrice) * parseInt(amount);
			$(this).parent().prev().children('.b_price').val(changPrice);
			changeRadioValues();
		}
	});
	$('.add').click(function(){	
		var amount = $(this).prevAll('.b_amount').first().val();
		amount = parseInt(amount) + 1;
		$(this).prevAll('.b_amount').first().val(amount);
		amount = $(this).prevAll('.b_amount').first().val();
		oneAmount = $(this).prev('.amount').val();
		b_price = $(this).parent().prev().children('.price').val();
		onePrice = parseInt(b_price) / parseInt(oneAmount);
		var changPrice = parseInt(onePrice) * parseInt(amount);
		$(this).parent().prev().children('.b_price').val(changPrice);
		changeRadioValues();

	});
	$('.delete').click(function(){
		var result = confirm("장바구니에서 삭제하시겠습니까?");
		if(result){
        	var scb_num = $(this).next('.scb_num').val();
        	location.href="deleteCart.do?scb_num="+scb_num;
		}
	});
	$('.goOrder').click(function(){
		var result = confirm("주문하시겠습니까?");
		if(result){
			select();
        	$('#order').submit();	
		}
	});
	function select(){
		for(var i=1; i<=cartMenuListSize; i++){
			b_price = $('#b_price'+i+'').val();
			amount = $('#amount'+i+'').val();
			$('.b_price'+i).val(b_price);
			$('.b_amount'+i).val(amount);
		}
	}
	function changeRadioValues(){
		totalPrice = 0;
		for(var i=1; i<=cartMenuListSize; i++){
			b_price = $('#b_price'+i+'').val();
			amount = $('#amount'+i+'').val();
			b_priceName = $('#b_price'+i+'').attr('id');
			amountName = $('#amount'+i+'').attr('id');
			$('.'+b_priceName).val(b_price);
			$('.'+amountName).val(amount);
			
			
			totalPrice += parseInt(b_price); 
			
		}
		$('.totalPrice').val(totalPrice);			
	}
}

$().ready(function(){
	click_go();
});
</script>
<style>
	#container {
		width: 1000px;
		margin: 0 auto;
		
	}
	/* h1, h3, p { text-align: center; } */
	table { border-collapse: collapse; 
			table-layout:fixed;
			word-break:break-all;
			margin : auto; 
			text-align:center;
			border: none;
			border: 1px solid #444444;
			}
	tr { border: 1px solid #444444;}
	th { background-color: orange; }
	
	.size {	width: 800px;
			overflow: hidden;
			margin: 0 auto;
			height: 200px;
	}
	.center { text-align: center; }
	.border-none, .border-none td { border: none; }

    		
</style>
<link href="css/style.css" rel="stylesheet" type="text/css">
<body>
<%@include file="common/menu.jspf" %>
<div id="container">
<br>
	<div>
		<h2 class="subtitle">CART</h2>
	</div>
	<br>
<form id="order" method="post" action="getOrderList.do" >
	<table>
		<thead>
			<tr>
				<td>NO</td>
				<td>메뉴명</td>
				<td>금액</td>
				<td>수량</td>
				<td>삭제</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cartMenu" items="${cartMenuList }" varStatus="menustatus">
				<tr>
					<td>${menustatus.count }</td>
					<td>${cartMenu.menu_name }</td>
					<td class="border">
						<input type="text" class="b_price" id="b_price${menustatus.count }"  value="${cartMenu.b_price}" disabled>
						<input type="hidden" class="price" value="${cartMenu.b_price}" disabled>
					</td>
					<td class="border">
						<button type="button" class="remove" id="remove"> - </button>
						<input type="text" class="b_amount" id="amount${menustatus.count }"  value="${cartMenu.b_amount }" disabled >
						<input type="hidden" class="amount" value="${cartMenu.b_amount }" disabled>
						<button type="button" class="add" id="add"> + </button>
					</td>
					<td>
						<button type="button" id="cartDelete" class="delete"> 삭제 </button>
						<input type="hidden" class="scb_num" value="${cartMenu.scb_num }">
					</td>
				</tr>
			<c:set var="count" value="0"/>
			<c:forEach var="cart" items="${cartList }" varStatus="opstatus">
				<c:if test="${cartMenu.scb_num == cart.scb_num }">
				<c:set var="count" value="${count+1 }"/>
					<tr>
						<td>${menustatus.count } - ${count }</td>
						<td colspan="4">${cart.op_name } ${cart.op_price }</td>
					</tr>
					<input type="hidden" class="amount${menustatus.count }" name="CartList[${opstatus.index }].b_amount" value="">
					<input type="hidden" class="b_price${menustatus.count }" name="CartListt[${opstatus.index }].b_price" value="">
					<input type="hidden" name="CartList[${opstatus.index }].menu_id" value="${cart.menu_id }">
					<input type="hidden" name="CartList[${opstatus.index }].scb_num" value="${cart.scb_num }">
					<input type="hidden" name="CartList[${opstatus.index }].op_id" value="${cart.op_id }">
					<input type="hidden" name="CartList[${opstatus.index }].s_id" value="${cart.s_id }">
					<input type="hidden" name="CartList[${opstatus.index }].b_id" value="${cart.b_id }">
					<input type="hidden" class="b_price${menustatus.count }" name="CartList[${opstatus.index }].b_price" value="${cart.b_price }">
					<input type="hidden" class="b_amount${menustatus.count }" name="CartList[${opstatus.index }].b_amount" value="${cart.b_amount }">
				</c:if>
					
			</c:forEach>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" class="border">합계 : <input type="text" id="totalPrice" name="o_price" class="totalPrice"></td>
			</tr>	
		</tfoot>
	</table>
	
	
	<h3>총 주문 금액 : <input type="text" class="totalPrice"></h3>
	<div class="center">
		<button type="button" class="goOrder"> 주문 </button>
	</div>
<input type="hidden" id="cartMenuListSize" value="${cartMenuListSize }">

</form>	
</div>

<%@include file="common/footer.jspf" %>
</body>
</html>















