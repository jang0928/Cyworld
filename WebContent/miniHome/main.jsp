<%@page import="sistProject3.vo.Myhome"%>
<%@page import="sistProject3.database.Main_Dao"%>
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


<script type="text/javascript">
<%--
--%>
//

   function logout(obj){
      location.href = "${path}/logout.do?logout=y";
   }
   $(document).ready(function(){
      
   });
</script>
<%
/* Main_Dao dao = new Main_Dao();

dao.updateToday_Hit(1);
Myhome home =dao.mainProfile("HIMAN"); */

%>
</head>
 <body class="body">
		<jsp:include page = "main_left.jsp"></jsp:include>
	<!-- 오른쪽 inner-box(게시글) -->
	<div class="outer-box border-right-box" style="width: 72%; padding: 20px 20px 20px 0px">
		<div class="inner-box" style="padding: 10px 110px 10px 5px;"> 
			<div class="content-box-header">
				<h1 style="margin:0px; font-size: 1.3em; font-weight: 550;" class="color-blue">&nbsp;&nbsp;5조의 미니홈피에 오신 것을 환영합니다~!</h1>
				<span style="font-size: 12px;">http://www.myworld.com</span>
		  	</div>
		  	<!-- 게시글 -->
		  	<div class="content-box" style="padding: 10px 20px; height: 165px">
		  		<jsp:include page = "boardList.jsp"></jsp:include>
		  		
		  		
				
				<div class="tody" >
						<span class="small-text">TOTAL</span>&nbsp;<span>${mainProfile.getTotal()}
						<input type = "button" value = "로그아웃" onclick = "logout()"/>
					<%-- 	${mainProfile.getHome_no()} --%>
						</span>
				</div>
				<a href="${path}/hmain.do" class="menu-item menu-selected">홈</a>
				<a href="${path}/pro.do" class="menu-item" style="top: 98px">프로필</a>
				<a href="${path}/gbcdetail.do" class="menu-item" style="top: 136px">방명록</a>
				<a href="${path}/friendlist.do" class="menu-item" style="top: 174px">친구목록</a>
				<a href="${path}/bWrite.do" class="menu-item" style="top: 212px">게시물+</a>
				<a href="${path}/hmain.do" class="menu-item" style="top: 250px">내홈피</a>
			</div>
			<!-- 사진첩 -->
			<div class="content-box" style="padding: 10px 20px; margin-top: 7px; height: 390px">
				<!-- 사진첩 파일 include -->
				<jsp:include page = "photoList.jsp"></jsp:include>
			</div>
		</div>
	  </div>
  </body>
</html>