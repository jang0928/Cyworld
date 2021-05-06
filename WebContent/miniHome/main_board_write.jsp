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
.tableBoard {
	border-collapse : collapse;
	border-top: 1px solid; /* 세로선 없이 가로선(top)만 만들때, 1px 실선의 형태로 적용 */
	width : 620px;	
	margin-top: 7px;
}
td {
	text-align : left;  /* 내부의 글자의 정렬 처리 */
	padding : 5px; /* 여백 지정(border와 글자 사이 간격) */
	font-size: 13px;
	border-bottom: 1px solid #a0a0a0; /* 세로선 없이 가로선(bottom)만 만들때, 1px 실선의 형태로 적용 */
}
td.td01{
 background-color : #dcdcdc;
 font-size: 13px;
}
label.l01 {
	display : block ; /* 새 라인에서 시작 */
	padding : 13px;
	text-align : center;
}
</style>
 <script>
 function logout(obj){
     location.href = "${path}/logout.do?logout=y";
  }
function complete() {
	alert("작성을 완료하시겠습니까?");
	location.href="main.jsp";
}
</script>
<script type="text/javascript" 
	src="${path}/a00_com/jquery-3.5.1.js"></script>
<script type="text/javascript">
<%--
 
--%>
//
	var ckInsert = "${param.board_title}";
	if( ckInsert != "" ){
		alert("등록했습니다.\n메인화면으로 이동합니다.");
		location.href='${path}/hmain.do';

	}
   $(document).ready(function(){
		$("#insBtn").on("click", function(){
			if($("[name=board_title]").val() == ""){
				alert("제목을 입력하세요.")
				$("[name=board_title]").focus();
				return false;
			}
			if($("[name=board_content]").val() == ""){
				alert("내용을 입력입니다.")
				$("[name=board_content]").focus();
				return false;
			}
			$("form").submit(); // form의 모든 데이터 전송 처리.
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
		  	<!-- 게시글 작성 -->
		  	<div class="content-box" style="padding: 10px 20px; height: 560px">
				<div style="display: flex; font-size: 14px;">
					<div style="flex-direction: column;">
						<span class="content-title" >게시물 작성</span>	
						<hr style="margin-block-end: 0px; width: 100%;">
						<form method="post">
						<table class="tableBoard">
							<col width="15%">
						 	<col width="85%">
							<tr><td class="td01">제목</td><td><input type="text" name="board_title" size="50"></td></tr>
							<tr><td class="td01">작성자</td><td><input type="text" name="HIMAN" readonly placeholder="홍길동" size="30"></td></tr>
							<tr><td class="td01">첨부파일</td><td>
								<input type="file" name="board_picture" placeholder="선택된 파일이 없습니다." size="50">
								</td></tr>
							<tr><td class="td01">본문</td><td>
								<textarea cols="70" rows="22" name="board_content" placeholder="내용을 작성해주세요"></textarea></td>
							</tr>
						</table>
						</form>
						<hr style="margin-block-end: 0px; width: 100%;">
						<label class="l01">
							<input type="button" onclick="window.location.href='${path}/hmain.do'" value="이전">
							<!-- <button onclick="window.location.href='${path}/hmain.do'">이전</button> -->
							<input type="button" id="insBtn" value="등록">
						</label>
						<div class="tody" >
								<span class="small-text">TOTAL</span>&nbsp;<span>${mainProfile.getTotal()}</span>
								<input type = "button" value = "로그아웃" onclick = "logout()"/>
						</div>
						<a href="${path}/hmain.do" class="menu-item">홈</a>
						<a href="${path}/pro.do" class="menu-item" style="top: 98px">프로필</a>
						<a href="${path}/gbcdetail.do" class="menu-item" style="top: 136px">방명록</a>
						<a href="${path}/friendlist.do" class="menu-item" style="top: 174px">친구목록</a>
						<a href="${path}/bWrite.do" class="menu-item  menu-selected" style="top: 212px">게시물+</a>
						<a href="${path}/hmain.do" class="menu-item" style="top: 250px">내홈피</a>
					</div>
				</div>
	  		</div>
	  	</div>
	</div>
  </body>
</html>