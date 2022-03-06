<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
<link rel="stylesheet" href="../resources/css/listProduct.css" type="text/css">
</head>
<body>
	<div id="container">
		<div><jsp:include page="../common/header.jsp"></jsp:include></div>
		<div class="page_article">
			<div class="marketLsit">
				<div class="marketList_category"> 
					<ul class="tnb_inner">
						<li class="tnb_list">
							<a href="/market/listProduct?category_code=sp">
								<span class="tnb_list_depth">국,찌개</span>
							</a>
						</li>
						<li class="tnb_list">
							<a href="/market/listProduct?category_code=d">
								<span class="tnb_list_depth">반찬</span>
							</a>
						</li>
						<li class="tnb_list">
							<a href="/market/listProduct?category_code=s">
								<span class="tnb_list_depth">샐러드</span>
							</a>
						</li>
						<li class="tnb_list">
							<a href="/market/listProduct?category_code=n">
								<span class="tnb_list_depth">면류</span>
							</a>
						</li>
						<li class="tnb_list">
							<a href="/market/listProduct?category_code=r">
								<span class="tnb_list_depth">밥,죽</span>
							</a>
						</li>
						<li class="tnb_list">
							<a href="/market/listProduct?category_code=b">
								<span class="tnb_list_depth">베이커리</span>
							</a>
						</li>
						<li class="tnb_list">
							<a href="/market/listProduct?category_code=v">
								<span class="tnb_list_depth">비건</span>
							</a>
						</li>
					</ul>
				</div>
				<div class="marketList_p">
					<div class="head">
						<ul class="list">
							<li><a href="/market/listProduct?orderType=product_date desc">최신순</a></li><br>
							<li><a href="/market/listProduct?orderType=product_price desc">높은가격순</a></li><br>
							<li><a href="/market/listProduct?orderType=product_price">낮은가격순</a></li><br>
						</ul>
					</div>
					<div class="box">
						<c:forEach var="p" items="${list }">
							<div class="box_list">
								<a href="/market/detailProduct?product_no=${p.product_no }"><img class="box_list_img" src="/images/${p.product_img }" width="400" height="400"></a>
								<div class="box_list_name" name="product_name">${p.product_name }</div>
								<div class="box_list_price" name="product_price">${p.product_price }</div>
							</div>
						</c:forEach>
					</div>
					<div class="pagenation">
						<c:forEach var="i" begin="1" end="${totalPage }">
							<a href="/market/listProduct?category_code=${category_code }&pageNUM=${i }">${i }</a>&nbsp;&nbsp;
						</c:forEach>
					</div> 
				</div>
			</div>
		</div>
		<div id="footer"><!-- 푸터 --></div>
	</div>
	
</body>
</html>