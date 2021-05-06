<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "sistProject3.*" %>
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

   function idCheck(id){   // [ ID중복확인 ] 버튼 눌렀을 때
	   frm = document.regFrm;
	   
	   if(id = ""){
		   alert("아이디를 입력해주세요.");
		   frm.id.focus();
		   return;
	   }
	   
	   url = "idCheck.jsp?id=" + id;
	   
	   window.open(url, "IDCheck", "width = 400, height = 200");
   }
   
   
   
   function zipCheck(){   // [ 우편번호 검색 ] 버튼 눌렀을 때
	   url = "zipSearch.jsp?check=n";
	   
	   window.open(url, "ZipCodeSearch", 
			       "width = 500, height = 300, scrollbars = yes");
   }
   
   
   
   
   function inputCheck(){   // [ 회원 가입 ] 버튼 눌렀을 때
	   // alert("회원등록");	   
	   if(document.regFrm.mem_id.value == ""){
		   alert("아이디를 입력해주세요.");
		   document.regFrm.mem_id.focus();
		   return;
	   } 
	   
	   if(document.regFrm.mem_id.value.length < 5) {
		   alert("최소 5자 이상으로 입력해주세요.");
		   document.regFrm.mem_id.focus();
		   return;
	   } else {
		   if(document.regFrm.mem_id.value.length > 15) {
			   alert("최대 15자 이하로 입력해주세요.");
			   document.regFrm.mem_id.focus();
			   return;
		   }
	   } 
	    
   
       if(document.regFrm.mem_pass.value == ""){
    	   alert("비밀번호를 입력해주세요.");
    	   document.regFrm.mem_pass.focus();
		   return;
       } 
      
	   if(document.regFrm.mem_pass.value.length < 8) {
		   alert("최소 8자 이상으로 입력해주세요.");
		   document.regFrm.mem_pass.focus();
		   return;
	   } else{
		   if(document.regFrm.mem_pass.value.length > 16) {
			   alert("최대 16자 이하로 입력해주세요.");
			   document.regFrm.mem_pass.focus();
			   return;
		   }
	   }
	  
       if(document.regFrm.repwd.value == ""){
    	   alert("비밀번호를 다시 한번 입력해주세요.");
    	   document.regFrm.repwd.focus();
		   return;
       } else{
    	   if(document.regFrm.mem_pass.value != document.regFrm.repwd.value){
    	   alert("비밀번호가 일치하지 않습니다.");
    	   document.regFrm.repwd.value = "";
    	   document.regFrm.repwd.focus();
		   return;
		   }
       }
       
       if(document.regFrm.mem_name.value == ""){
    	   alert("이름을 입력해주세요.");
    	   document.regFrm.mem_name.focus();
		   return;
       }
       
       if(document.regFrm.mem_email.value == ""){
    	   alert("이메일을 입력해주세요.");
    	   document.regFrm.mem_email.focus();
		   return;
       }
       
       if(document.regFrm.mem_pnumber.value == ""){
    	   alert("휴대폰 번호를 입력해주세요.");
    	   document.regFrm.mem_pnumber.focus();
		   return;
       }
       
       
       // 유효성 check 후, 최종적으로 전송 처리
       document.querySelector("form").submit();
   }
   
 
   var id = "${param.mem_id}";
   if(id != "") {
  	 // alert("등록 성공");
  	 
  	 if(confirm("회원 가입을 완료하시겠습니까?")){
  		 location.href = "${path}/sessLogin.do";
  	 }
   }


// 이메일 옵션 선택시 자동 입력
$(document).ready(function(){

	$("select[name = emailDomain]").change(function() {

		if($(this).val() == "1"){

			$('#email').val("");

		} else {

			$('#email').val($("#email").val() + $(this).val());

			// $("#email").attr("readonly", true);

		}

	});

});
</script>

<style>
#joinMember {
   overflow : scoll;
   margin : 0 auto;
   width : 1200px;
   height : 600px;
}

table th {
   background-color : #A6D3DF;
}

font {
   font-size : 12px;
   color : darkgray;
}
</style>

</head>
<body>
<div style="width:100%; max-width:1100px;">
	<div class="outer-box border-left-box" style="width: 27%; padding: 20px 0px 20px 20px">
		<!-- 왼쪽 inner-box -->
		<div class="inner-box" style="padding: 10px 5px 10px 10px;">
<div class="content-box-header" style="justify-content: center">
	<img style="width: 10%" src="${path}/miniHome/img/myWorld.JPG"></img>
	<font style="font-size: 25px; font-weight : bolder; color : black;">마이월드</font>
</div>
</div>
</div>
</div>

<div id = "joinMember" class = "form">
   <h4>기본 정보</h4>
   <form name = "regFrm" method = "post">
   <table width = "1200px" height = "500px"
          style = "border-top: 1px solid lightgray;">
   <col width = "20%">
   <col width = "80%">
   <tr>
     <tr>
       <th>아이디</th>
       <td><input type = "text" name = "mem_id" size = "57"/>
           <input type = "button" value = "ID중복확인" style = "background : white;"
                  onclick = "idCheck(this.form.id.value)"/>
           <br><font>최소 5자 이상 입력해주세요. (5 ~ 15자)</font><br>
               <font>아이디 중복을 확인해주세요.</font></td>
     </tr>
     <tr>
       <th>비밀번호</th>
       <td><input type = "password" name = "mem_pass" size = "70"/>
           <br><font>최소 8자 이상 입력해주세요. (8 ~ 16자)</font></td>
     </tr>
     <tr>
       <th>비밀번호 확인</th>
       <td><input type = "password" name = "repwd" size = "70"/>
           <br><font>비밀번호를 동일하게 입력해주세요.</font></td>
     </tr>
     <tr>
       <th>이름</th>
       <td><input type = "text" name = "mem_name" size = "70"/></td>
     </tr>
     <tr>
       <th>이메일</th>
       <td><input type = "text" name = "mem_email" size = "52" id = "email"/>
           <select name="emailDomain" id = "emailDomain" class="tune" style="width: 120px;" tabindex="-1">
	                  <option value = "1" selected = "selected">직접입력</option>
	                  <option value = "@naver.com">@naver.com</option>
	                  <option value = "@hanmail.net">@hanmail.net</option>
	                  <option value = "@daum.net">@daum.net</option>
	                  <option value = "@nate.com">@nate.com</option>
	                  <option value = "@hotmail.com">@hotmail.com</option>
	                  <option value = "@gmail.com">@gmail.com</option>
	                  <option value = "@icloud.com">@icloud.com</option>
           </select>
       <br>
           <input type="checkbox" id="mail">
           <label for="maill" class="">정보/이벤트 메일 수신에 동의합니다.</label></td>
     </tr>
     <tr>
       <th>휴대폰 번호</th>
       <td><input type = "text" name = "mem_pnumber" size = "70" placeholder = "예) 010-1234-5678"/>
       <br>
           <input type="checkbox" id="phone">
           <label for="maill" class="">정보/이벤트 메일 수신에 동의합니다.</label></td>
     </tr>
     <tr>
       <th>주소</th>
       <td><input type = "text" name = "postal code" size = "15"/>
           <input type = "button" value = "우편번호 검색" onclick = "zipCheck()"
                  style = "background : white;"/>
       <br>
       <input type = "text" name = "mem_address" size = "70"/>
       <br>
       <input type = "text" size = "70"/></td>
     </tr>
     <tr>
        <th>성별</th>
        <td>
          <input type = "text" name = "gender" size = "70" placeholder = "예) 남 or 여">
        </td>
     </tr>
     <tr>
       <th>생년월일</th>
       <td><input type = "text" name = "mem_birth2" placeholder = "YYYY-MM-DD"/></td>
     </tr>
   </table>
   
   <br><br><br>
   
   <input type = "button" value = "회원 가입" id = "ins"
          style = "background : black; color : white; width : 150px;
          height : 50px; margin-left : 520px;"
          onclick = "inputCheck()" />
   </form>
   </div>
</body>
</html>