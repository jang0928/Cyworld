<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<c:set var="path" value="${pageContext.request.contextPath}"/> 
<fmt:requestEncoding value="UTF-8" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_main_com/main.css" >
<script type="text/javascript" 
	src="${path}/a00_main_com/jquery-3.5.1.js"></script>
	
<style type="text/css">
  table {
    margin-left: auto;
    margin-right: auto;
  }

table.profile_1 {
  border-collapse: collapse;
  text-align: center;
  line-height: 1.5;

}
table.profile_1 thead th {
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #369;
  border-bottom: 3px solid #036;
}
table.profile_1 tbody th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
  background: #f3f6f7;
}
table.profile_1 td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
  border-bottom: 1px solid #ccc;
}

input:focus {
	outline:1px solid #000000;}
</style>

<script type="text/javascript">
<%--
 
--%>
//
  function logout(obj){
      location.href = "${path}/logout.do?logout=y";
   }
   $(document).ready(function(){
	/*   
		수정버튼 누르고 alert창 뜨게
		function check() {
		   if(fr.id.value == "") {
		     alert("수정사항을 입력해 주세요.");
		     fr.id.focus();
		     return false;
		   }
		   else if(fr.pw.value == "") {
		     alert("수정사항을 입력해 주세요.");
		     fr.pw.focus();
		     return false;
		   }
		   else return true;
		 }
	*/
	   $("#pont").click(function(){
		      //alert($(this).text());
				   $("body").css("font-family",$(this).text());
	
   });
</script>
</head>
 <body class="body">
		<jsp:include page = "main_left.jsp"></jsp:include>
	<!-- 오른쪽 inner-box(삭제x) -->
	<div class="outer-box border-right-box" style="width: 72%; padding: 20px 20px 20px 0px">
		<div class="inner-box" style="padding: 10px 110px 10px 5px;"> 
			<div class="content-box-header">
				<h1 style="margin:0px; font-size: 1.3em; font-weight: 550;" class="color-blue">&nbsp;&nbsp;5조의 미니홈피에 오신 것을 환영합니다~!</h1>
				<span style="font-size: 12px;">http://www.myworld.com</span>
		  	</div>
		  	<div class="content-box" style="padding: 10px 20px; height: 560px">
				<div style="display: flex; font-size: 14px;">
					<div style="flex-direction: column;">
						<span class="content-title" >프로필</span>	
						<hr style="margin-block-end: 0px; width: 100%;">
						<!-- 프로필 코드 삽입 -->					
<table class="profile_1">
  <thead>
  <tr>
    <th scope="cols" colspan="2">프로필 정보</th>
  </tr>
  </thead>

  <tbody>
   <c:forEach var="p" items="${proList }">
    <tr>
    <th scope="row">Email</th>
    <td>${p.mem_email }</td>
  </tr>
  <tr>
    <th scope="row">NAME</th>
    <td>${p.mem_name }</td>
  </tr>
  <tr>
    <th scope="row">PHON_NUMBER</th> <!-- 기존 데이터를 key값으로 가져와서 value에 넣는다 -->
    <td>${p.mem_pnumber }</td>
  </tr>
  </c:forEach>  	
  </tbody>
</table>
						<hr style="margin-block-end: 0px; width: 100%;">
						<!-- 버튼 삽입(필요 시) -->
						
					<div class="tody" >
								<span class="small-text">TOTAL</span>&nbsp;<span>${mainProfile.getTotal()}
								<input type = "button" value = "로그아웃" onclick = "logout()"/>
							<%-- 	${mainProfile.getHome_no()} --%>
								</span>
						</div>
						<a href="${path}/hmain.do" class="menu-item">홈</a>
						<a href="${path}/pro.do" class="menu-item menu-selected" style="top: 98px">프로필</a>
						<a href="${path}/gbcdetail.do" class="menu-item" style="top: 136px">방명록</a>
						<a href="${path}/friendlist.do" class="menu-item" style="top: 174px">친구목록</a>
						<a href="${path}/bWrite.do" class="menu-item" style="top: 212px">게시물+</a>
						<a href="${path}/hmain.do" class="menu-item" style="top: 250px">내홈피</a>
					</div>
				</div>
	  		</div>
	  	</div>
	</div>
  </body>
</html>