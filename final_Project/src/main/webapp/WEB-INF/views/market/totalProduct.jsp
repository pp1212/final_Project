<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		function plist(data){
			$.each(data,function(){
				$(".box").append(
					"<div class='box_list'>"+
					"<a href='market/detailProduct'>"+
					"<img class='box_list_img' src='/images/"+this.product_img+"' width='400' height='400'>"+
					"</a>"+
					"<div class='box_list_name'>"+this.product_name+"</div>"+
					"<div class='box_list_price'>"+this.product_price+"</div>"+
					"<button type='button' class='box_list_cart'>"+
					"<img width='15' height='15' src='/images/shopping-cart.jpg'>"+
					"</button>"+
					"</div>"
				);
			})
		};
		
		
		let category_code="";
		

		
		$(".tnb_list").click(function(){
			$(".box").empty();
			
			category_code = $(this).attr("value");
			$.ajax({url:"/market/listProduct/"+category_code,success:function(data){
				console.log(data);
				plist(data);
			}});
			
			$(".orderTypeSelect").on("change",function(){
				alert(this.value);
			})
		})
	});
</script>
</head>
<body>
	<div class="marketLsit">
		<div class="marketList_category">
			<ul class="tnb_inner">
				<c:forEach var="c" items="${category }">
					<li class="tnb_list" value="${c.category_code }">${c.category_name }</li>
				</c:forEach>
			</ul>
		</div>
		<div class="marketList_p">
			<div class="head">
				<select class="orderTypeSelect">
					<option class="orderTypeOption" value="product_date desc" selected="selected">최신순</option>
					<option class="orderTypeOption" value="product_price desc">높은가격순</option>
					<option class="orderTypeOption" value="product_price">낮은가격순</option>
				</select>
			</div>
			<div class="box">
			</div>
		</div>
	</div>
</body>
</html>