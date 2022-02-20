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
		
		/* $.ajax({url:"listCategory",success:function(data){
			console.log(data);
			$.each(data,function(){
				let li = $("<li></li>").html(this.category_name).attr({class:"tnb_list",category_code:this.category_code});
				$(".tnb_inner").append(li);
			});
		}}); */
		
		$(".tnb_list").click(function(){
			$(".box_list").empty();
			
			let category_code = $(this).attr("value");
			$.ajax({url:"listProduct/"+category_code,success:function(data){
				console.log(data);
				$.each(data,function(){
					$(".box_list").append(
						"<a href='detailProduct'>"+
						"<img class='box_list_img' src='/images/"+this.product_img+"' width='400' height='400'>"+
						"</a>"+
						"<div class='box_list_name'>"+this.product_name+"</div>"+
						"<div class='box_list_price'>"+this.product_price+"</div>"+
						"<button type='button' class='box_list_cart'>"+
						"<img width='15' height='15' src='/images/shopping-cart.jpg'>"+
						"</button>"
					);
					/* $(".box_list_img").attr("src","/images/"+this.product_img);
					$(".box_list_title").html(this.product_name);
					$(".box_list_price").html(this.product_price); */
				})
			}});
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
			<div class="head"></div>
			<div class="box">
				<div class="box_list">
				</div>
			</div>
		</div>
	</div>
</body>
</html>