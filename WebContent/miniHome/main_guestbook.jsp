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



/*방명록 박스*/
.guestbook-wrap { 
	width:92%; 	
	padding:20px; 
	border:1px solid #ddd; 
	background:#fff}	
.guestbook-form dl.guestbook-guest dd {
	margin-bottom:10px
	}	
	
/*이름 비밀번호 박스모양 */	
.guestbook-form dl.guestbook-guest dd input {
	width:30%; 
	padding:10px 0; 
	border:1px solid #ddd; 
	background:#f9f9f9; 
	color:#999; 
	text-indent:10px;}	
.guestbook-form dl.guestbook-guest dd input:focus, .guestbook-form dl.guestbook-guest dd input:active {
	background:#fff; 
	color:#111}
.guestbook-form .secret label {
	cursor:pointer}	
	
/*비밀글버튼*/	
.guestbook-form .secret input {
	width:20px; 
	height:20px; 
	margin-right:10px; 
	vertical-align:bottom;}
.guestbook-form dl.guestbook-write {
	margin-top:10px;}	
	
/*'내용' 히든으로 가리기*/	
.guestbook-form dl.guestbook-write dt {
	position: absolute; 
	width:1px; 
	height:1px; 
	padding:0; 
	margin:-1px; 
	overflow:hidden; 
	clip:rect(0,0,0,0); 
	border:0;}	

/*방명록 작성란*/	
.guestbook-form dl.guestbook-write dd textarea {
	width:80%; 
	margin-bottom:10px; 
	padding:10px 0; 
	height:200px; 
	border:1px solid #ddd; 
	background:#f9f9f9; 
	color:#999; 
	text-indent:10px;}
.guestbook-form dl.guestbook-write dd textarea:focus, .guestbook-form dl.guestbook-write dd textarea:active {
background:#fff; color:#111}	

/*등록버튼*/
.guestbook-form button {
	display:block; 
	width:10%; 
	margin:10px 0 0 0; 
	padding:10px 0; 
	border:1px solid #369; 
	background:#369; 
	color:#fff; 
	text-align:center;
	align:center;
	}
	
/* Guestbook list */
s_guest_container {
style=overflow: scroll; 

}
.guestbook-list {
	margin-bottom:30px; 
	list-style:none; 
	border-bottom:1px 
	solid #e9e9e9}
.guestbook-list li {	
	padding:5px 0; 
	border-top:1px solid #e9e9e9}	
.guestbook-list li:after {
	display:block; 
	clear:both; 
	content:''}	
.guestbook-list li .thumb {
	float:left; 
	width:10%; 
	text-align:center}	

/*사진 둥글게*/	
.guestbook-list li .thumb img {
	border-radius: 50%;}

/*글내용 옆으로 출력*/	
.guestbook-list li .guestbook-content {
	float:left; 
	width:90%}
.guestbook-list li .guestbook-content:after {
	display:block; 
	clear:both; 
	content:''}
.guestbook-list li .guestbook-content ul li {
	border:0; 
	padding:2;}	
	
/*이름이랑 내용 사이 간격*/	
.guestbook-list li .guestbook-content .info {
	float:left;}	
	
/*이름 & 날짜 같은라인에 있게*/	
.guestbook-list li .guestbook-content .info li {
	display:inline-block}	

/*날짜 상대적으로 작게*/	
.guestbook-list li .guestbook-content .info li.date {
	font-size:0.85em; 
	color:#bbb}
	
/*수정 삭제 댓글쓰기 우측으로 정렬*/	
.guestbook-list li .guestbook-content .control {
	float:right}	
.guestbook-list li .guestbook-content .control li {
	display:inline-block; 
	margin-right:10px}
	
/*수정 삭제 댓글쓰기 css*/	
.guestbook-list li .guestbook-content .control li a {
	color:#369; 
	font:normal 0.75em 'NanumBarunGothic', 'Noto Sans', sans-serif;}	
.guestbook-list li .guestbook-content .control li a .fa {
	color:#ff8149;}
.guestbook-list li .guestbook-content .text {
	clear:both; 
	padding:10px 0 0; 
	color:#777; 
	font:normal 0.875em 'NanumBarunGothic', 'Noto Sans', sans-serif; 
	line-height:1.5em}	
/* @ 비밀글 */ 
.guestbook-list li.guest_secret .guestbook-content .text {
	color:#999}
/* @ 일반 */   
.guestbook-list li.guest_general {}
/* @ 관리자 */ 
.guestbook-list li.guest_admin .guestbook-content .nickname a {
	color:#ff8149}
/* RE Guestbook list */
.guestbook-list li.re-guestbook {
	width:90%; 
	margin-left:10%; 
	border-top:1px solid #f5f5f5}
.Scrollbar{
overflow: auto; 
	width:630px;
  height:500px;
  margin: 5px;
  background-color: #fff;
  float: left;
}	

textarea{
	width:350px; 
	height:20px; 
    resize:none;
    }
.body{
main_board_cont.jsp
}
</style>



<script type="text/javascript">
function logout(obj){
    location.href = "${path}/logout.do?logout=y";
 }
var ckInsert = "${param.gb_content}";
var home_no = "${param.home_no}";
if( ckInsert != "" ){
	alert("등록했습니다.");
	location.href="${path}//gbcdetail.do?home_no="+home_no;

}
$(document).ready(function(){
	$("#insBtn").on("click", function(){
		if($("[name=gb_content]").val() == ""){
			alert("내용을 입력입니다.")
			$("[name=gb_content]").focus();
			return false;
		}
		$("#book").submit(); // form의 모든 데이터 전송 처리.
	});
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
						<span class="content-title" >방명록</span>	
						<hr style="margin-block-end: 0px; width: 100%;">

						<!-- 방명록 코드 삽입 -->
<div class="Scrollbar">
<s_guest>
    <!-- guestbook
    <h2 id="guestbookBody" class="guestbook-title"  >방명록</h2> -->
    <div class="guestbook-wrap">
        <s_guest_input_form>
            <div class="guestbook-form">
                <fieldset >
                <form id="book" method="post">
                    <s_guest_member>
                        <s_guest_form >
                            <dl class="guestbook-guest">
                        </s_guest_form>
                        <p class="secret">
                            <label for="[##_guest_input_is_secret_##]"><input type="checkbox" name="gb_constraint" value="Y"> 비밀글</label>
                        </p>
                    </s_guest_member>
                    <dl class="guestbook-write">
                        <dt><label for="[##_guest_input_comment_##]">내용</label></dt>
                        <dd><textarea name="gb_content" placeholder="여러분의 방명록을 입력해주세요" title="방명록 내용 입력"></textarea></dd>
                    </dl>
                    <input type="button" id="insBtn" value="등록">
               		</form>	
                </fieldset>
            </div>
        </s_guest_input_form>      
     <!-- 방명록 출력 -->   
         <s_guest_container >
            <ul class="guestbook-list">
                <s_guest_rep>
                    <li id="[##_guest_rep_id_##]" class="[##_guest_rep_class_##]">
                        <c:forEach var="bom" items="${bookList}">
                        <div class="guestbook-content">
                            <ul class="info">
                            <li class="bookno" style="display:none;">${bom.gbook_no }</li>
                                <li class="nickname">${bom.mem_id }</li>
                                <li class="date">${bom.gb_date }</li>
                            </ul>
                            <p class="text">${bom.gb_content }</p>    
                        </div>                 
                        </c:forEach>       
                    </li>
                </s_guest_rep>
            </ul>
        </s_guest_container>
    </div>
</s_guest>
</div>				
						
						<hr style="margin-block-end: 0px; width: 100%;">
						<!-- 버튼 삽입(필요 시) -->
						
						<div class="tody" >
							<span class="small-text">TOTAL</span>&nbsp;<span>${mainProfile.getTotal()}</span>
							<input type = "button" value = "로그아웃" onclick = "logout()"/>
						</div>
						<a href="${path}/hmain.do" class="menu-item">홈</a>
						<a href="${path}/pro.do" class="menu-item" style="top: 98px">프로필</a>
						<a href="${path}/gbcdetail.do" class="menu-item menu-selected" style="top: 136px">방명록</a>
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