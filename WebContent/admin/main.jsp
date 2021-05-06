<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<fmt:requestEncoding value="UTF-8" /> 
<%
	request.setCharacterEncoding("UTF-8");
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css">
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css">

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">
<title>마이월드 관리자 페이지</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/dashboard/">



<!-- Bootstrap core CSS -->
<link href="${path}/assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
img {
    display:block; 
    margin:auto;
}

ul {
  width: 100%;
  color: #666;
  text-align: center;
  margin-top: 200px;
}

li {
  float: left;
  width: 25%;
  list-style: none;
  border-left: 2px solid #ed5f00;
}

li:first-child {
  border-left: 0;
}

.text{
	font-size:1.5em;
}}
</style>

<script type="text/javascript" 
  src="${path}/a00_main_com/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(function() {
	  var count0 = count1 = count2 = count3 = 0;

	  timeCounter();

	  function timeCounter() {

	    id0 = setInterval(count0Fn, 100);

	    function count0Fn() {
	      count0++;
	      if (count0 > ${mList.size() }) {
	        clearInterval(id0);
	      } else {
	        $(".number").eq(0).text(count0);
	      }

	    }

	    id1 = setInterval(count1Fn, 50);

	    function count1Fn() {
	      count1++;
	      if (count1 > ${bList.size() }) {
	        clearInterval(id1);
	      } else {
	        $(".number").eq(1).text(count1);
	      }
	    }

	    id2 = setInterval(count2Fn, 100);

	    function count2Fn() {
	      count2++;
	      if (count2 > ${bgList.size() }) {
	        clearInterval(id2);
	      } else {
	        $(".number").eq(2).text(count2);
	      }
	    }

	    id3 = setInterval(count3Fn, 100);

	    function count3Fn() {
	      count3++;
	      if (count3 > ${fList.size() }) {
	        clearInterval(id3);
	      } else {
	        $(".number").eq(3).text(count3);
	      }
	    }
	  }
	});
</script>
<!-- Custom styles for this template -->
<link href="${path}/admin/admin.css" rel="stylesheet">
</head>
<body>


	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">마이월드 관리자 페이지</a> 
		<span style="color: white; font-size: 10px;">당신의 추억을 책임지는
			어쩌구 저쩌구 마이월드</span>
	</header>
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<img onclick="location.href='${path}/main.do'" src="${path}/admin/마이월드.png"/>
		</div>
<ul>
  	<li onclick="location.href='${path}/member.do'">
    	<h2 class="number">${mList.size() }</h2>
    	<i class="text">Members</i>
  	</li>
  	<li>
    	<h2 class="number" onclick="location.href='${path}/board.do'">${bList.size() }</h2>
    	<i class="text">Posts</i>
  	</li>
  	<li>
    	<h2 class="number" onclick="location.href='${path}/background.do'">${bgList.size() }</h2>
    	<i class="text">Background Images</i>
  	</li>
	<li>
    	<h2 class="number" onclick="location.href='${path}/font.do'">${fList.size() }</h2>
    	<i class="text">Font</i>
  	</li>
  	
</ul>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
	integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
	integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
	crossorigin="anonymous"></script>
<script src="${path}/admin/admin.js"></script>
</html>

