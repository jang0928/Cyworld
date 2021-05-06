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
div.container{
	overflow : scroll;
	width:630px; 
	height:500px;
}
.tableBoard {
	border-collapse : collapse;
	border-top: 1px solid; /* 세로선 없이 가로선(top)만 만들때, 1px 실선의 형태로 적용 */
	width : 610px;	
	margin-top: 7px;
}
th {
	text-align : left;  /* 내부의 글자의 정렬 처리 */
	padding : 5px; /* 여백 지정(border와 글자 사이 간격) */
	height : 15px;
	border-bottom: 1px solid #a0a0a0; /* 세로선 없이 가로선(bottom)만 만들때, 1px 실선의 형태로 적용 */
	background-color : #dcdcdc;
}
td {
	text-align : left;  /* 내부의 글자의 정렬 처리 */
	padding : 5px; /* 여백 지정(border와 글자 사이 간격) */
	height : 15px;
	border-bottom: 1px solid #a0a0a0; /* 세로선 없이 가로선(bottom)만 만들때, 1px 실선의 형태로 적용 */
}
.inp1 {
	padding : 5px;
	width:300px;
  	height:60px;
}
.font{
sfont-weight : bold;
font-size : 0.8em;;
}
.cmnts {
	display: inline-block;
	margin : 5px;
	padding : 5px 10px 5px 10px;
	border : 1px solid #000;
	border-radius : 7px;
	font-size : 11px;
	width : 300px;
	
}
.impPList{
width:250px; 
height:250px;
}
</style>


<script type="text/javascript" 
	src="${path}/a00_main_com/jquery-3.5.1.js"></script>
<script type="text/javascript">
<%--
 
--%>
function logout(obj){
    location.href = "${path}/logout.do?logout=y";
 }//

	var ckInsert = "${param.com_content}";
	var board_no = "${param.board_no}";
	if( ckInsert != "" ){
		alert("등록했습니다.\n조회화면으로 이동하시겠습니까?")
		location.href="${path}//boardConDetail.do?board_no="+board_no;

	}
   $(document).ready(function(){
		$("#insBtn").on("click", function(){
			if($("[name=com_content]").val() == ""){
				alert("내용을 입력하세요.")
				$("[name=com_content]").focus();
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
		  	<div class="content-box" style="padding: 10px 20px; height: 560px">
				<div style="display: flex; font-size: 14px;">
					<div style="flex-direction: column;">
						<span class="content-title" >게시글</span>	
						<hr style="margin-block-end: 0px; width: 100%;">
						<!-- 상세 게시물 -->
						<div class = "container">
							<!-- center -->
								 <table class="tableBoard">
								 	<col width="30%">
						 			<col width="70%">

							<c:choose>
								<c:when test="${empty bcd.board_picture}">
									 	<tr><th style="text-align:left;" colspan="2">${bcd.board_title}...</th></tr>
									 	<tr><td class="font">작성자 ${bcd.mem_name}</td>
									 		<td style="text-align:right;" class="font">작성날짜 ${bcd.board_date}</td></tr>
									 	<tr><td colspan="2" style="text-align:left">${bcd.board_content}</td></tr>
									 	<tr><td colspan="2"><button>♥</button> 좋아요${bcd.board_like}</td></tr>
								</c:when>
								<c:otherwise>
									 	<tr><th style="text-align:left;" colspan="2">${bcd.board_title}...</th></tr>
									 	<tr><td class="font">작성자 ${bcd.mem_name}</td>
									 		<td style="text-align:right;" class="font">작성날짜 ${bcd.board_date}</td></tr>
									 	<tr><td colspan="2" style="text-align:center">
									 		<img class="impPList" src="${path}/miniHome/img/${bcd.board_picture}"></img>
									 	</td></tr>
									 	<tr><td colspan="2" style="text-align:left">${bcd.board_content}</td></tr>
									 	<tr><td colspan="2"><button>♥</button> 좋아요${bcd.board_like}</td></tr>
								</c:otherwise>
							</c:choose>
								 </table><br>
								 
							<c:forEach var="bcom" items="${bcomList}">
							<div class="cmnts">
							<span>${bcom.mem_name } (${bcom.com_date })</span><br>
							<span>${bcom.com_content }</span>
							</div><br>
							</c:forEach>
			
							
						<form style="text-align:center; padding:10px" method="post">
							<input name="board_no" value="${param.board_no}" style="display:none;">
							<span>Comment </span><textarea name="com_content" placeholder="댓글을 입력해 주세요" class="inp1"></textarea><br>
							<input type="button" id="insBtn" value="등록">
						</form>
						</div>						
						<hr style="margin-block-end: 0px; width: 100%;">
						<!-- 버튼 삽입(필요 시) -->
						
						<div class="tody" >
								<span class="small-text">TOTAL</span>&nbsp;<span>${mainProfile.getTotal()}</span>
								<input type = "button" value = "로그아웃" onclick = "logout()"/>
						</div>
						<a href="${path}/hmain.do" class="menu-item">홈</a>
						<a href="${path}/pro.do" class="menu-item" style="top: 98px">프로필</a>
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