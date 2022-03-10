<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
<link rel="stylesheet" href="../resources/css/mgr_updateProduct.css" type="text/css">
</head>
<body>
<div><jsp:include page="../common/header.jsp"></jsp:include></div>
	<div class="mgr_list">
	<h2>상품수정</h2>
	<hr width="1000px">
	<form action="mgr_updateProduct" method="post" enctype="multipart/form-data">
		상품번호: ${p.product_no }
		<input type="hidden" name="product_no" value="${p.product_no }"><br>
		상품이름 : <input type="text" name="product_name" value="${p.product_name }"><br>
		상품가격 : <input type="text" name="product_price" value="${p.product_price }"><br>
		상품설명 : <input type="text" name="product_desc" value="${p.product_desc }"><br>
		상품등록날짜 :  ${p.product_date }<br>
		상품할인여부 : <input type="text" name="product_margin" value="${p.product_margin }"><br>
		카테고리 코드 : ${p.category_code }<br>
		상품상세사진 : <img src="/images/${p.product_detail }" width="100" height="100"><br>
		상품사진 : <img src="/images/${p.product_img }" width="100" height="100"><br>
		<input type="submit" value="수정">
	</form>
	</div>
		   <div><jsp:include page="../common/footer.jsp"></jsp:include></div>
</body>
</html>