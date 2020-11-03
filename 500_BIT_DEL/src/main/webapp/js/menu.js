$(function(){
	$("#nav>li>a>span").mouseover(function(){
		$("#nav>li>ul").fadeIn(200);
		$("#nav>li>ul").mouseleave(function(){
			$("#nav>li").mouseleave(function(){
				$("#nav>li>ul").css("display", "none");
			});
		});
		$("#nav>li").mouseleave(function(){
			$("#nav>li>ul").css("display", "none");
		}); 
	});
});
