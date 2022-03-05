<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
<link rel="stylesheet" href="../resources/css/mypageCommon.css" type="text/css">
</head>
<body>
	<div id="container">
		<div><jsp:include page="../common/header.jsp"></jsp:include></div>
		<div class="page_article">
		
		
			<div id="snb">
				<h2 class="tit_snb">마이보글</h2>
				<div class="inner_snb">
					<ul class="list_menu">
						<li><a href="/mypage/orderList">주문 내역</a></li>
						<li><a href="/mypage/listReviewWrite">상품 후기</a></li>
						<li><a href="/mypage/listQna">상품 문의</a></li>
						<li><a href="/mypage/mypageMain">개인 정보 수정</a></li>
					</ul>
				</div>
			</div>


<!-- 마이페이지 메인에서 개인정보수정 탭을 누르면 이리로 온다 그리고 확인을 누르면 updateCustomer로 가기 -->
	<h2>개인 정보 수정</h2>
	<h3>비밀번호 재확인</h3>
	<hr>
	<form action="mypageMain" method="post">
		아이디 ${cust_id }<br>
		비밀번호 <input type="password" name="cust_pwd"><br>
		<hr>
		<input type="submit" value="확인">
	</form>
	
	
			</div>
		<div id="footer"><!-- 푸터 --></div>
	</div>
</body>
</html>