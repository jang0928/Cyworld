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


</style>
<script type="text/javascript" 
  src="${path}/a00_main_com/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  $("#insBtn").on("click", function(){
		  if($("[name=bgname]").val()==""){
			  alert("배경 이름을 입력하는 칸이 공백입니다.\n배경 이름을 입력해 주세요.");
			  $("[name=bgname]").focus();
		      return false;
		  }
		  if($("[name=bgurl]").val()==""){
			  alert("배경 url을 입력하는 칸이 공백입니다.\n배경 url을 입력해 주세요.");
			  $("[name=bgurl]").focus();
		      return false;
		  }
		  $("form").submit(); // form의 모든 데이터 전송 처리
	     });
});

var ckInsert = "${param.bgname}";
if (ckInsert!=""){
	if(confirm("등록완료!")){
		location.href='${path}/background.do';
	}
}

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

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link"
							aria-current="page" onclick="location.href='${path}/member.do'"> <span data-feather="user"></span>
								회원 관리
						</a></li>
						<li class="nav-item"><a class="nav-link" onclick="location.href='${path}/board.do'"> <span
								data-feather="edit"></span> 게시글 관리
						</a></li>
						<li class="nav-item"><a class="nav-link active" onclick="location.href='${path}/background.do'"> <span
								data-feather="layers"></span> 배경 관리
						</a></li>
						<li class="nav-item"><a class="nav-link" onclick="location.href='${path}/font.do'"> <span
								data-feather="type"></span> 폰트 관리
						</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</div>
	<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
		<div
			class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
			<img onclick="location.href='${path}/main.do'" src="${path}/admin/마이월드.png"/>
		</div>

		<h4>배경 관리</h4>
		<br>
		<h6>총 ${bgList.size() }개</h6>
		<hr><br>

		<h5>배경 등록</h5>
		<br>
		<div class="table-responsive">
			<form method="post">
			<table class="table table-striped table-sm">
			<colgroup>
				<col style="width:20%">
				<col style="width:80%">
			</colgroup>
					<tr>
						<th>배경 이름</th>
						<td><input type="text" name="bgname" style="width:100%"></td></tr>
					<tr>	
						<th>배경 URL</th>
						<td><input type="text" name="bgurl" style="width:100%"></td></tr>					
			</table><br>
			<table>
			<tr><td colspan="2"><input type="button" id="insBtn" class="btn btn-sm btn-outline-secondary" value="등록"/>
            			</td>
					</tr>
			</table>
			</form>
		</div>
		<br><br><br>
		<h5>배경 목록</h5>
		<br>		
		<div class="table-responsive">
			<table class="table table-striped table-sm">
			<colgroup>
				<col style="width:5%">
				<col style="width:10%">
				<col style="width:85%">
			</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>URL</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bg" items="${bgList }">
					<tr>
						<td>${bg.BG_NO }</td>
						<td>${bg.BG_NAME }</td>
						<td>${bg.BG_URL }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br><br>
	</main>

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
