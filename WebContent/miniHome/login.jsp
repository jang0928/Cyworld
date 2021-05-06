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

<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>


<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<%--
   $(document).ready(function(){
		$("#insBtn").on("click", function(){
			if($("[name=com_comment]").val() == ""){
				alert("내용을 입력하세요.")
				$("[name=com_comment]").focus();
				return false;
			}
			$("form").submit(); // form의 모든 데이터 전송 처리.
		});

--%>	   
<script type="text/javascript">
$(document).ready(function(){
	   var isSuccess = "${isSuccess}";
	   if(isSuccess == "false"){
		   alert("${param.mem_id}님 로그인 실패!");
	   }
	   $("[name=mem_id]").focus();
});
</script>

<style>
div.container {
   overflow : scoll;
   margin : 0 auto;
   width : 1200px;
}

#loginForm {
   overflow : scoll;
   margin : 0 auto;
   width : 1200px;
   
   margin-left : 350px;
   margin-top : 150px;
   margin-bottom : 120px;
}

#login {
   width : 500px;
   height : 300px;
   border : 2px solid gray;
}

button {
   width : 150px;
   height : 30px;
   background-color : white;
   color : black;
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
				
<div class = "container">
   <div id = "loginForm">
   <h2>L O G I N</h2>
   <div id = "login">
   <form method = "post">
   <br><br><br>
   <table>
   <col width = "25%">
   <col width = "30%">
   <col width = "30%">
   <col width = "15%">
   <tr>
      <td></td>
      <td><input type = "text" name ="mem_id" placeholder = "ID"
                 style = "height : 30px;"/></td>
      <td rowspan = "2"><input type = "submit" id="insBtn" value = "LOGIN"
                               style = "width : 100px; height : 75px;
                                        background-color : white; color : balck;"/></td>
      <td></td>
   </tr>
   <tr>
      <td></td>
      <td><input type = "password" name="mem_pass" placeholder = "PASSWORD"
                 style = "height : 30px;"/></td>
      <td></td>
   </tr>
   <tr>
      <td></td>
      <td><input type = "checkbox"  id = "saveId">
          <label for = "saveId">아이디 저장</label></td>
      <td></td>
      <td></td>
   </tr>
   </table>
   <hr>
   <br>
   <button type = "button" style = "margin-left : 20px;"
           onclick = "location.href = '${path}//miniHome//join_member01.jsp'">회원가입</button>
   <button type = "button"
           onclick = "location.href = '${path}//miniHome//find_id01.jsp'">ID 찾기</button>
   <button type = "button"
           onclick = "location.href = '${path}//miniHome//find_pass01.jsp'">PASSWORD 찾기</button>
   </form>
   </div>
   </div>
</div>  
   
<%--    <%
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    
    if(id != null && pass != null){
    	String page1 = "";
    	
    	if(id.equals("master") && pass.equals("m1234")) page1 = ""; // 관리자 페이지 입력(마스터 계정[ID : master]으로 로그인했을 때)
    	else if(id.equals("staff") && pass.equals("s1234")) page1 = "";  // 관리자 페이지 입력(스태프 계정[ID : staff]으로 로그인했을 때)
    	else page1 = "main.jsp";
   %> 
   <%} %> --%>

</body>
</html>