$(document).ready(function(){
	$(".slide_div").slick(
		{
			dots:false,
			autoplay:true,
			autoplaySpeed:3000
		}		
	);
	
	$(".post-wrapper").slick(
		{
			slidesToShow : 4,
			slidesToScroll : 1,
			autoplay: false,
			nextArrow: $(".next"),
			prevArrow: $(".prev")
		}
	);
});