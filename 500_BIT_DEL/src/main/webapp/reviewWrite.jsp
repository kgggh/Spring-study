<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/review.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>리뷰</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

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
        border: 
    }   
</style>
</head>
<%@include file="common/menu.jspf" %>
<body>
<div id="container">
<br>
	<div>
		<h2 class="subtitle">REVIEW</h2>
	</div>
	<br>
<form action="reviewUpdate.do" method="post">

	<table>
	<thead>
		
		<tr>
			<th colspan="3"><h1>${s_name }</h1></th> 
		</tr>
		<tr>
			<td>${menu_name }</td>
		</tr>	 
		</thead>
		
		<tr>
			<td colspan="3"> 음식점의 점수를 매겨주세요. </td>
		</tr>
		<tr>
			<td colspan="3"><input type="text" name="r_avg" value="" ></td>
		</tr>
		<tbody>
		<tr> 
			<td><textarea rows="20" cols="133" class="review" name="r_content" placeholder="리뷰는 300자 이내로 작성해주세요.">
			</textarea>
			<br />
	         <span style="color:#aaa;" id="counter">(0 / 300)</span>
		</td>
		</tr>
		<tr>
			<td>
				<input type="file" id="file" class="add_file" value="">
				<input type="hidden" id="fileName" class="fileName" name="r_photo" value="">
				<input type="hidden" name="sco_num" value="${sco_num }">
				<input type="hidden" name="s_id" value="${s_id }">
			</td>
		</tr>
		</tbody>
	</table>
	<br>
	<input type="submit" id="reviewbutton"value="리뷰등록" >
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
	$('.review').keyup(function (e){
	    var content = $(this).val();
	    $('#counter').html("("+content.length+" / 300)");    //글자수 실시간 카운팅
	    if (content.length > 200){
	        alert("최대 300자까지 입력 가능합니다.");
	        $(this).val(content.substring(0, 300));
	        $('#counter').html("(300 / 최대300자)");
	    }
	});    
	$('.add_file').change(function(){
		var fileName = $(this).val().split('/').pop().split('\\').pop(); // 파일명만 추출
		$(this).next('.fileName').val(fileName);
	});
	
</script>
</html>















