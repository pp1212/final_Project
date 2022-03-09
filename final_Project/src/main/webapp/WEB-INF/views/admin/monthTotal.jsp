<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  <script type="text/javascript">
  /*  
	  Array(3)
	0: {month: 1, total: 247350}
	1: {month: 2, total: 213400}
	2: {month: 12, total: 60800}
	  
	  var arr = [
	        ["Element", "Density", { role: "style" } ],
	        ["1", 247350, "#b87333"],
	        ["2",213400, "silver"],
	        ["12", 60800, "gold"]
	      ]
  */

  	var arr = [
  		 ["Element", "매출", { role: "style" } ]
  	];
	
   
    
   $(function () {
	$.ajax({
		url:"/admin/monthTotal",
		success:function(data){
			$.each(data, function(){
				var month = this.month;
				var total = this.total;
				arr.push([month+"",total,"#F2884B"]);
			});
			
			console.log(arr);
		}
	});
});
  
   
   setTimeout(function(){
	   google.charts.load("current", {packages:['corechart']});
	    google.charts.setOnLoadCallback(drawChart);
	    function drawChart() {
	      var data = google.visualization.arrayToDataTable(arr);

	      var view = new google.visualization.DataView(data);
	      view.setColumns([0, 1,
	                       { calc: "stringify",
	                         sourceColumn: 1,
	                         type: "string",
	                         role: "annotation" },
	                       2]);

	      var options = {
	        title: "월별 총매출",
	        width: 600,
	        height: 400,
	        bar: {groupWidth: "60%"},
	        legend: { position: "none" },
	      };
	      var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
	      chart.draw(view, options);
	      
	  }
	   
   },100);
   
    
  </script>

</head>
<body>
	<div><jsp:include page="../common/header.jsp"></jsp:include></div>
	<div id="columnchart_values" style="width: 900px; height: 300px;"></div>
	<div><jsp:include page="../common/footer.jsp"></jsp:include></div>
</body>
</html>