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
	totalPrice();

	function totalPrice(){
		var price = $('#price').val();
		var saleprice = $('#saleprice').val();
		var tip = $('#tip').val();
		var totalPrice = parseInt(price) + parseInt(saleprice) + parseInt(tip);
		$('#totalPrice').val(totalPrice);			
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
	
	img {width : 198px ;
		height:150px;
		 }
	.page {
		position: relative;
	}	 
	.prev { 
			position: absolute;
    		top: 135px;
    		left: 40px; }
    .next { 
		    position: absolute;
		    top: 135px;
    		right: 40px;}
    		
    .prevBest{ position: absolute;
    		top: 70px;
    		left: 40px;
    }
    
   .nextBest { 
		    position: absolute;
		    top: 70px;
    		right: 40px;}
    		
</style>
<link href="css/style.css" rel="stylesheet" type="text/css">
<body>
<%@include file="common/menu.jspf" %>
<div id="container">
<br>
	<div>
		<h2 class="subtitle">ORDERS</h2>
	</div>
	<br>
	<form action="orderInsert.do" method="post">
	<table>
		<thead>
			<tr>
				<td>NO</td>
				<td>메뉴명</td>
				<td>금액</td>
				<td>수량</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cartMenu" items="${cartMenuList }" varStatus="menustatus">
				<tr>
					<td>${menustatus.count }</td>
					<td>${cartMenu.menu_name }</td>
					<td>${cartMenu.b_price}</td>
					<td>${cartMenu.b_amount }</td>
				</tr>
			<c:set var="count" value="0"/>
			<c:forEach var="cart" items="${cartList }" varStatus="opstatus">
				<c:if test="${cartMenu.scb_num == cart.scb_num }">
				<c:set var="count" value="${count+1 }"/>
					<tr>
						<td>${menustatus.count } - ${count }</td>
						<td colspan="3">${cart.op_name } ${cart.op_price }</td>
					</tr>
				</c:if>
					
			</c:forEach>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">합계 : <input type="text" value="${o_price }"></td>
			</tr>	
		</tfoot>
	</table>
	
	
	<h3>배달 정보</h3>
	<p>${dong }</p>
	<p>${dong }</p>
	
	<h3>요청사항</h3>
	<h3>쿠폰 </h3>
	<h3>결제방법</h3>
	<h3>결제수단</h3>
	<h3>결제금액</h3>
	<p>주문 금액 : <input type="text" id="price" value="${o_price }"></p>
	<p>배달팁 : <input type="text" id="tip" value="${tipPrice.tip_price }"></p>
	<p>할인 금액 : <input type="text" id="saleprice" value="0"></p>
	<div class="center">
	<h3>총 결제 금액 : <input type="text" name="o_price" id="totalPrice" value=""></h3>
	<button type="submit" class="goPayment"> 결제하기 </button>
	<button type="button" class="back"> 취소 </button>
	</div>
<input type="hidden" id="cartMenuListSize" value="${cartMenuListSize }">	
<input type="hidden" name="cartList" value="${cartList}">	
</form>
</div>
<%@include file="common/footer.jspf" %>
</body>
</html>















