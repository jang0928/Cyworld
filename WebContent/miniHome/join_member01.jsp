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

<script type="text/javascript" 
	src="${path}/a00_main_com/jquery-3.5.1.js"></script>

<style type="text/css">
div.container {
   overflow : scoll;
   margin : 0 auto;
   width : 1200px;
}
#agrees {
   width : 500px;
   height : 800px;
   margin-left : 350px;
}

#agree1 {
   width : 500px;
   height : 30px;
   background-color : lightgray;
   border : 1px solid white;
   padding-top : 10px;
}

#agree1-1 {
   overflow : auto;
   width : 500px;
   height : 200px;
   border : 1px solid white;
   background-color : white;
}

#agree2 {
   width : 500px;
   height : 30px;
   background-color : lightgray;
   border : 1px solid white;
   padding-top : 10px;
}

#agree2-1 {
   overflow : auto;
   width : 500px;
   height : 200px;
   border : 1px solid white;
   background-color : white;
}

#seleAgree {
   width : 500px;
   height : 30px;
   border : 1px solid white;
   padding-top : 10px;
}
</style>

<script src="${path}/a00_com/jquery.min.js"></script>
<script src="${path}/a00_com/popper.min.js"></script>
<script src="${path}/a00_com/bootstrap.min.js"></script>
<script src="${path}/a00_com/jquery-ui.js"></script>

<script type="text/javascript">
<%--


--%>
   $(document).ready(function(){
	   $("#allAgree").on("click", function(){
		   // $(this).prop("ckecked")
		   // : 대상 객체의 속성을 boolean값으로 가져오기 때문에 바로 설정해서
		   //  전체 선택/ 전체 해제가 가능하다.
		   $("input").prop("checked", $(this).prop("checked"));
	   });
   });
</script>

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

<div class="container">
   <form id = "agree">
   <div id = "agrees" name = "agrees">
   <br>
   <h2 align = "center">약관동의</h2>
   <hr>
   <input type = "checkbox" class = "checkbox" id = "allAgree" name = "allAgree">
   서비스 이용약관, 개인정보 수집 및 이용, 이벤트 등 프로모션 안내 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;메일 수신(선택)에
   <span style = "color : blue; font-weight : bold">모두 동의</span>합니다.
   <br><br>
   <div id = "agree1">
   <input type = "checkbox" class = "checkbox" id = "agree01" name = "agree01">
   서비스 이용약관 동의
   </div>
   <div id = "agree1-1"> 
<h3>[ 제 1장 총칙 ]</h3>

<h4>제1조(목적)</h4>

이 약관은 <span style = "color : orange; font-weight : bold">(주)MyWorld</span>(이하 "회사"라고 함)가 제공하는 게임 및 제반 서비스의 이용과 관련하여 회원과 회사 간의 조건 및 절차에 관한 기본적인 사항을 정함을 목적으로 합니다.<br>

<h4>제2조(용어의 정의)</h4>
① 이 약관에서 사용하는 용어의 정의는 다음과 같습니다. 1. 이용 계약: 회사가 제공하는 서비스 이용과 관련하여 회사와 이용 고객 간에 체결하는 계약을 말합니다.<br>
2. 회원: 회사가 제공하는 절차에 따른 가입 신청 및 이용 계약 체결을 완료한 뒤, ID를 발급받아 회사의 서비스를 이용할 수 있는 자를 말합니다.<br>
3. ID: 회원 식별과 서비스 이용을 위하여 회원이 선정하고 회사가 승인하는 문자, 특수문자, 숫자 등의 조합을 말합니다.<br>
4. 체험 ID: 회원 식별과 회사가 제공하는 특정 서비스를 이용하기 위하여 회원이 선정하고 회사가 승인하는 문자, 특수문자, 숫자 등을 말합니다.<br> 
5. PASSWORD(이하 "비밀번호"라고 함): 회원이 자신의 ID 또는 체험 ID와 일치하는 이용 고객임을 확인하기 위해 선정한 문자, 특수문자, 숫자 등의 조합을 말합니다.<br>
6. 회원 탈퇴: 회원이 이용 계약을 해지함을 의미합니다.<br>
7. 계정 : ID에 수반하여 게임 이용을 위해 회원이 별도로 생성하는 캐릭터, 게임 ID 등을 의미합니다.<br>

② 이 약관에서 사용하는 용어의 정의는 제1항에서 정하는 것을 제외하고는 관계 법령 및 각 서비스 별 안내에서 정하는 바에 의합니다.
관계 법령과 각 서비스 별 안내에서 정하지 않는 것은 일반적인 상관례에 의합니다.<br>

<h4>제3조(약관의 효력 및 적용과 변경)</h4>
① 회사는 이 약관의 내용을 회원이 알 수 있도록 회사에서 운영하는 홈페이지(www.nexon.com, 이하 "홈페이지"라 함)에 게시하거나 연결화면을 제공하는 방법으로 회원에게 공지합니다.<br>
② 이 약관에 동의하고 회원 가입을 한 회원은 약관에 동의한 시점부터 동의한 약관의 적용을 받고 약관의 변경이 있을 경우에는 변경의 효력이 발생한 시점부터 변경된 약관의 적용을 받습니다. 
이 약관에 동의하는 것은 정기적으로 홈페이지를 방문하여 약관의 변경 사항을 확인하는 것에 동의하는 것을 의미합니다.<br>
③ 회사는 필요하다고 인정되는 경우 이 약관을 변경할 수 있습니다. 회사는 약관이 변경되는 경우에 변경된 약관의 내용과 시행일을 정하여, 그 시행일로부터 7일전 홈페이지에 온라인으로 공시합니다.
다만, 이용자에게 불리하게 약관 내용을 변경하는 경우에는 시행일로부터 30일전 홈페이지에 온라인으로 공시하거나 회원이 회원 가입 시 등록한 e-mail로 전송하는 방법으로 회원에게 고지합니다.
변경된 약관은 공시하거나 고지한 시행일로부터 효력이 발생합니다.<br>
④ 회원은 변경된 약관에 대해 거부할 권리가 있습니다. 본 약관의 변경에 대해 이의가 있는 회원은 서비스 이용을 중단하고 회원 탈퇴를 할 수 있습니다.
회원이 변경된 이용약관의 시행일 이후에도 서비스를 계속 이용하는 경우에는 변경된 약관에 동의한 것으로 봅니다.<br>

<h4>제4조(개인정보의 보호 및 사용)</h4>
① 회사는 관계법령이 정하는 바에 따라 이용자 등록정보를 포함한 이용자의 개인 정보를 보호하기 위해 노력합니다.
이용자의 개인 정보 보호 및 사용에 대해서는 관련 법령 및 회사의 개인정보처리방침이 적용됩니다.
단, 회사의 공식 사이트 이외의 링크된 사이트에서는 회사의 개인정보처리방침이 적용되지 않습니다.<br>
② 회사는 이용자의 귀책 사유로 인해 노출된 이용자의 계정 정보를 비롯한 모든 정보에 대해서 일체의 책임을 지지 않습니다.<br>

<h4>제5조(운영 정책)</h4>
① 회사는 약관을 적용하기 위해 필요한 사항과 회원의 권익을 보호하고 게임 세계 내 질서를 유지하기 위하여 약관에서 구체적 범위를 정하여 
위임한 사항을 게임 서비스 운영 정책(이하 "운영 정책"이라고 함)으로 정할 수 있습니다.<br>
② 회사는 운영 정책의 내용을 회원이 알 수 있도록 게임별 서비스 홈페이지(이하 "게임 홈페이지"라고 함)에 게시하거나 연결 화면을 제공하는 방법으로 회원에게 공지합니다.<br>
③ 회원의 권리 또는 의무에 중대한 변경을 가져오거나 약관 내용을 변경하는 것과 동일한 효력이 발생하는 운영정책 개정의 경우에는 제3조 제3항의 절차에 따릅니다. 
단, 운영정책 개정이 다음 각 호의 어느 하나에 해당하는 경우에는 본 조 제2항의 방법으로 사전에 공지합니다. 1. 약관에서 구체적으로 범위를 정하여 위임한 사항을 개정하는 경우<br>
2. 회원의 권리·의무와 관련 없는 사항을 개정하는 경우<br>
3. 운영정책의 내용이 약관에서 정한 내용과 근본적으로 다르지 않고 회원이 예측 가능한 범위 내에서 운영정책을 개정하는 경우<br>

<h4>제6조(약관의 규정 외 사항에 관한 준칙)</h4>

이 약관에 규정 되지 않은 사항과 이 약관의 해석에 대해서는 회사가 정한 개별 서비스 이용약관, 운영정책 및 관계법령이 적용됩니다.<br>
   </div>
   <br>
   
   <div id = "agree2">
   <input type = "checkbox" class = "checkbox" id = "agree02" name = "agree02">
   개인정보 수집 및 이용 동의
   </div>
   <div id = "agree2-1">
   <h3>[ 개인정보 수집 및 이용 동의 ]</h3>

<span style = "color : orange; font-weight : bold">㈜MyWorld</span>는 다음과 같이 개인정보를 수집 및 이용하고 있습니다.<br>
- 수집 및 이용 목적: 회원 가입, 게임서비스 제공, 이용자 식별, 공지사항 전달<br>
- 항목: ID, 비밀번호, 이메일주소<br>
- 수집 및 이용 목적: 본인확인, 이용자 식별, 부정이용 방지, 중복가입 방지, 공지사항 전달<br>
- 항목: 이름, 생년월일, 성별, 내외국인정보, 이동통신사정보, 휴대폰번호, 연계정보(CI), 중복가입정보(DI)<br>
- 보유 및 이용기간: 회원탈퇴일로부터 30일 (법령에 특별한 규정이 있을 경우 관련 법령에 따라, 부정이용기록은 회원탈퇴일로부터 1년)<br><br>

동의를 거부할 경우 회원가입이 불가능 합니다.<br>
외부 계정을 이용하는 경우 이용자가 동의한 범위 내에서만 개인정보를 제공받고 처리합니다.<br>
이벤트 등 프로모션 알림 전송을 위해 선택적으로 개인정보를 이용할 수 있습니다. <br><br>

※ 그 외의 사항 및 자동 수집 정보와 관련된 사항은 개인정보처리방침을 따릅니다.<br>
   
   </div>
   <br>
   <div id = "seleAgree">
   <input type="checkbox" class="checkbox" id="agree03">
   (선택) 이벤트 등 프로모션 안내 메일을 수신합니다.
   </div>
   <br>
   <input type = "button" value = "다음 단계"
          style = "background : white; width : 100px; height : 40px; margin-left : 190px;"
          onclick = "location.href = '${path}/memInsert.do'"/>
   </div>
   </form>
   <br>
</div>  
</body>
</html>