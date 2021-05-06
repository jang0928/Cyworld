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

<script type="text/javascript" 
	src="${path}/a00_main_com/jquery-3.5.1.js"></script>
<script type="text/javascript">
<%--
--%>
//
   $(document).ready(function(){
      
   });
</script>

</head>
 <body class="body">
	<div style="width:100%; max-width:1100px;">
		<div class="outer-box border-left-box" style="width: 27%; padding: 20px 0px 20px 20px">
			<!-- 왼쪽 inner-box -->
			<div class="inner-box" style="padding: 10px 5px 10px 10px;"> 
				<div class="content-box-header" style="justify-content: center">
					<img style="width: 10%" src="${path}/miniHome/img/myWorld.JPG"></img>&nbsp;
					<h1 style="margin:0px; font-size: 1.3em;">마이월드</h1>
				</div>
				<!-- 왼쪽 프로필 사진 -->
				<div class="content-box" style="padding: 20px; height: 230px">
					<img style="width:220px; height:185px;" src="${path}/miniHome/img/${mainProfile.profile_photo}"></img>
				</div>
			   	<!-- 왼쪽 소개글 -->
			  	<div class="content-box" style="padding: 20px; margin-top: 7px; height: 210px">
					<p style="font-size: 14px">${mainProfile.getStatus_message()}</p>
			  	</div>
			  	<!-- 왼쪽 이름/성별 -->
			    <div class="content-box" style="text-align: center; padding: 12px; margin-top: 7px; height: 50px">
					<b class="color-blue">${mainName.getMem_name() }</b><span style="color: #b3b3b3; font-size: 12px;">
					&nbsp;${mainName.getGender() }</span>
			    </div>
			    <!-- 왼쪽 홈피와의 관계 -->
			    <div class="content-box" style="text-align: center; padding: 12px; margin-top: 7px; height: 50px">
					<b style="font-size: 14px">내 미니홈피</b>
			    </div>
			</div>
		</div>
	</div>
	
  </body>
</html>