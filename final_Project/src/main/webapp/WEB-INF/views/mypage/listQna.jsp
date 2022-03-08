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
						<li><a href="/mypage/loginMypage">개인 정보 수정</a></li>
					</ul>
				</div>
			</div>
			
			<!-- 오른쪽 -->
			<div class="page_section">
				<!-- 제목 -->
				<div class="head_article">
					<h2>1:1 문의</h2>
				</div> 
				
				<div id="reviewView">
					<table border="1">
						<tr>
							<td>번호</td>
							<td>제목</td>			
							<td>작성일</td>			
						</tr>
						<c:forEach var="q" items="${list }">
							<tr>
								<td>${q.qna_no }</td>	
								<td><a href="detailQna?qna_no=${q.qna_no }">${q.qna_title }</a></td>	
								<td><fmt:formatDate value="${q.qna_date }"/></td>					
							</tr>
						</c:forEach>
					</table>
					<a href="insertQna">문의작성</a>
				</div>
			
			</div>
		</div>
		<div id="footer"><!-- 푸터 --></div>
	</div>
	
</body>
</html>