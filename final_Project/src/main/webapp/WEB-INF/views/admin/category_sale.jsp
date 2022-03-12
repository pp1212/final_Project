<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css">
<link rel="stylesheet" href="../resources/css/category_sale.css" type="text/css">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
google.charts.load('current', {'packages':['corechart']});
</script>
</head>
<body>
<div><jsp:include page="../common/header.jsp"></jsp:include></div>
	<div class="cate">
      <h1>카테고리별 판매량</h1>
      <select id="category_code">
        <option value="sp">국, 찌개</option>
        <option value="d">반찬</option>
        <option value="s">샐러드</option>
        <option value="n">면류</option>
        <option value="r">밥,죽</option>
        <option value="b">베이커리</option>
        <option value="v">비건</option>
      </select>
      <input type="submit" value="확인" onclick='Show_Category();'><br>
    
    <script>
    	function Show_Category(category_code) {
    	var category_code =$("#category_code option:selected").attr('value');
    		$.ajax({
    			url: "category_sale",
    			data: "category_code=" + category_code,
    			dataType: "JSON",
    			cache: false,
    			async: true,
    			type: "POST",
    			success: function(obj) {
    				Show_CategoryCallback(obj);
    			},
    			error: function(xhr, status, error) { }

    		});
    	}
    
    function Show_CategoryCallback(obj) {
    	
    	var count = obj.length;
    	console.log(obj);
    	var arr = [
            ['상품이름', '판매량',{ role: "style" },{ role: 'annotation' }],
            ];
    	if (obj != null) {
    		console.log("callback success");
    		document.getElementById("cate_list").innerHTML="";
    		for (var index = 0; index < count; index++) {
    			arr.push([obj[index].product_name,obj[index].cnt,"#F2884B",obj[index].cnt]);
    		}
    	}
    	
    	var options = {
    	        title: '카테고리별 판매량',
    	        chartArea: {width: '50%', height:'100%'},
    	        hAxis: {
    	          title: '판매량',
    	          minValue: 0
    	        },
    	        legend: { position: "none" },
    	        vAxis: {
    	          title: '상품이름'
    	        }
    	      };
    	console.log(arr);
    	var data = google.visualization.arrayToDataTable(arr);
    	var chart = new google.visualization.BarChart(document.getElementById('cate_list'));
        chart.draw(data, options);
    }
    
    
    </script>  
    
    <div id="cate_list"></div> 
    </div>     
    <div><jsp:include page="../common/footer.jsp"></jsp:include></div>
</body>
</html>