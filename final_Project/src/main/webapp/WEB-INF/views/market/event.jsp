<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
<link rel="stylesheet" href="../resources/css/event.css" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(window).scroll(function(){
		if($(this).scrollTop() > 200){
			$(".top").fadeIn();
		}else{
			$(".top").fadeOut();
		}
	});
	
	$(".top").click(function(){
		$("html,body").animate({scrollTop : 0},400);
		return false;
	});
</script>
</head>
<body>
	<div id="container">
		<div><jsp:include page="../common/header.jsp"></jsp:include></div>
		<div class="page_article">
			<ul>
				<li><img src="/images/banner1.jpg"></li>
				<li><img src="/images/banner2.jpg"></li>
				<li><img src="/images/banner3.jpg"></li>
				<li><img src="/images/event1.jpg"></li>
			</ul>
		</div>
		<div><jsp:include page="../common/footer.jsp"></jsp:include></div>
	</div>
	<a href="#" class="top">Top</a>
</body>
</html>