<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var = "path" value = "${pageContext.request.contextPath}" />  
<fmt:requestEncoding value = "UTF-8" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="${path}/a00_com/bootstrap.min.css" >
<link rel="stylesheet" href="${path}/a00_com/jquery-ui.css" >

<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>

<script type="text/javascript">
<%--


--%>
   $(document).ready(function(){
	   
   });
</script>

<style>
#find {
   border : 2px solid gray;
   width : 300px;
   height : 170px;
   
   margin-top : 250px;
   margin-left : 470px;
   margin-bottom : 200px;
   
   background-color : lightgray;
}
</style>

</head>
<body style = "background: #A6D3DF">
<div style="width:100%; max-width:1100px;">
	<div class="outer-box border-left-box" style="width: 27%; padding: 20px 0px 20px 20px">
		<!-- 왼쪽 inner-box -->
		<div class="inner-box" style="padding: 10px 5px 10px 10px;">
<div class="content-box-header" style="justify-content: center">
	<img style="width: 10%" src="${path}/miniHome/img/myWorld.JPG"></img>
	<font style="font-size: 25px; font-weight : bolder">마이월드</font>
</div>
</div>
</div>
</div>

<div id = "find">
<div>
<h4 align = "center">ID 찾기</h4>
<hr>
<br>
</div>

<form method = "post" action = "${path}/memId.do">
<table>
<tr>
   <th>휴대폰 번호 : </th>
      <td><input name = "mem_pnumber" value = "${param.mem_pnumber}"/></td>
</tr>
<tr>      
  <th colspan = "2">
    <input type = "submit" value = "찾기"
           style = "width :80px; height : 30px;
           background : white; margin-left : 10px; margin-top : 5px"/>
  </th>
</tr>
</table>
</form>
</div>
</body>
</html>