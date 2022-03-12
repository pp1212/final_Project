<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
<link rel="stylesheet" href="../resources/css/orderPageOK.css" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div><jsp:include page="../common/header.jsp"></jsp:include></div>
<br><br>
<h2 align="center" style="color:#F2884B;">주문이 완료되었습니다</h2>
<h3  align="center">주문번호: ${order_no}</h3>
<div><jsp:include page="../common/footer.jsp"></jsp:include></div>
</body>
</html>