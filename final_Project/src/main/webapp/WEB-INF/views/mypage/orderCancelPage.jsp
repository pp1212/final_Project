<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
</head>
<body>
	<h2>주문 취소 신청</h2>
	<hr>
	<form action="orderCancelPage" method="post">
	주문일시<br>
	<fmt:formatDate value="${o.order_date }"/><br>
	주문번호<br>
	${o.order_no }<br>
	<hr>
	
	<!-- 반복문돌아야할듯 -->
	<h3>배송정보</h3>
	${o.cust_name }
	<br>
	<br>
	<c:forEach var="o" items="${list }">
		<img src="../images/${o.product_img }" width="100" height="100"><br>
		${o.product_name }<br>
		${o.detail_price }<br>
		${o.detail_cnt }<br>
	</c:forEach>
	
	<!-- 환불테이블에 수정, 등록시 취소사유가 같이 가야한다..-->
	<h3>취소사유</h3>
	<select>
		<option value="0">단순변심</option>
		<option value="1">상품불량</option>
		<option value="2">배송지연</option>
		<option value="3">배송정보와 상이</option>
		<option value="4">기타</option>
	</select>
	
	<h3>환불정보</h3>
	결제방법 ${o.payment_name }<br>
	주문금액 ${totalDetail }
	<hr>
	환불예정금액 ${totalDetail }<br>
	<input type="reset" value="취소"><input type="submit" value="주문 취소 신청">
	</form>
</body>
</html>