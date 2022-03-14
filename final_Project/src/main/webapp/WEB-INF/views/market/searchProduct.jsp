<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/searchProduct.css" type="text/css">
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
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
			<c:choose>
				<c:when test="${not empty list }">
					<div class="searchLsit">
						<ul class="box">
							<c:forEach var="s" items="${list }">
								<li class="box_list">
									<a href="/market/detailProduct?product_no=${s.product_no }">
										<img class="box_list_img" src="/images/${s.product_img }" width="340">
									</a>
									<div class="box_list_title_wrap">
										<span class="box_list_sub">${s.product_desc }</span>
										<span class="box_list_title"><a href="/market/detailProduct?product_no=${s.product_no }">${s.product_name }</a></span>
									</div>
									<div class="box_list_price">
										<span class="box_list_price-origin">${s.product_price }원</span>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</c:when>
				<c:otherwise>
					<div class="search_n">
						<p class="search_n_desc">
							<img src="/images/icon_mark.png">
							<strong>검색결과가 없습니다.</strong>
						</p>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div><jsp:include page="../common/footer.jsp"></jsp:include></div>
	</div>
	<a href="#" class="top">Top</a>
</body>
</html>