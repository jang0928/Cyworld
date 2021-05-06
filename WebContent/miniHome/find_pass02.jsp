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


<script type="text/javascript" 
	src="${path}/a00_main_com/jquery-3.5.1.js"></script>
<script type="text/javascript">
<%--


--%>
function change(){
	if(document.password.pass.value == "") {
		alert("비밀번호를 재설정 해주세요.");
		document.password.pass.focus();
		return;
	} else {
		if(document.password.pass.value != document.password.repass.value){
			alert("비밀번호가 일치하지 않습니다.\n다시 입력해주세요.");
			document.password.repass.value = "";
			document.password.repass.focus();
			return;
		}
	}
	
	if(document.password.pass.value.length < 8) {
		   alert("최소 8자 이상으로 입력해주세요.");
		   document.password.pass.focus();
		   return;
	} else{
		   if(document.password.pass.value.length > 16) {
			   alert("최대 16자 이하로 입력해주세요.");
			   document.password.pass.focus();
			   return;
	       }
	}
	
	alert("비밀번호 변경이 완료되었습니다.");
	
	location.href = "${path}/sessLogin.do";
}
</script>

<style>
#myPass {
   border : 1px solid darkgray;
   width : 350px;
   height : 220px;
   
   margin-top : 200px;
   margin-left : 470px;
   margin-bottom : 200px;
   
   background : lightgray;
}

div a {
   text-decoration : none;
   cursor : pointer;
   color : darkgray;
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

<div id = "myPass">

 <h2 align = "center">비밀번호 재설정</h2>
 <hr>
 <br>
 <form name = "password">
 <table>
 <tr><th>비밀번호 : </th><td><input type = "password" name = "pass"/></td></tr>
 <tr><th>비밀번호 재입력 : </th><td><input type = "password" name = "repass"/></td></tr>
 <tr>
   <th colspan = "2">
     <input type = "button" value = "변경"
            style = "width :50px; height : 30px;
            background : white; margin-top : 10px;
            margin-left : 30px;" onclick = "change()"/></th></tr>
 </table>
 </form>
 <br>
</div>
</body>
</html>