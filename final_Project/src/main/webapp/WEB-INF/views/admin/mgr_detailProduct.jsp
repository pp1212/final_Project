<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
<link rel="stylesheet" href="../resources/css/mgr_detailProduct.css" type="text/css">
</head>
<body>
<div><jsp:include page="../common/header.jsp"></jsp:include></div>
	<div class="mgr_list">
	<h2>상품상세</h2>
	<a href="mgr_listProduct">목록</a>
	<hr>
	상품번호 : ${p.product_no }<br><br>
	상품이름 : ${p.product_name }<br><br>
	상품가격 : ${p.product_price }<br><br>
	상품설명 :  ${p.product_desc }<br><br>
	상품등록날짜 :  ${p.product_date }<br><br>
	상품할인여부 : ${p.product_margin }<br><br>
	카테고리 코드 : ${p.category_code }<br><br>
	상품상세사진 : <img src="/images/${p.product_detail }" width="100" height="100"><br><br>
	상품사진 : <img src="/images/${p.product_img }" width="100" height="100"><br>
	<button type="button" onclick="location.href='mgr_updateProduct?product_no=${p.product_no }' " id="updatepro">상품수정</button>
	<button type="button" onclick="location.href='mgr_deleteProduct?product_no=${p.product_no }' " id="deletepro">상품삭제</button>
	
	</div>
	   <div><jsp:include page="../common/footer.jsp"></jsp:include></div>
</body>
</html>