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
.tableSize {
   border-collapse : collapse;
   width : 600px;   
  height: 300px;
  text-align : center;
}
.th {
   text-align : center;  /* 내부의 글자의 정렬 처리 */
   padding : 5px; /* 여백 지정(border와 글자 사이 간격) */
   height : 15px;
   border-bottom: 1px solid #a0a0a0; /* 세로선 없이 가로선(bottom)만 만들때, 1px 실선의 형태로 적용 */
   background : #dcdcdc;
}
.td {
   text-align : center;  /* 내부의 글자의 정렬 처리 */
   padding : 5px; /* 여백 지정(border와 글자 사이 간격) */
   height : 15px;
   border-bottom: 1px solid #a0a0a0; /* 세로선 없이 가로선(bottom)만 만들때, 1px 실선의 형태로 적용 */
}
.impPList{
width:145px; 
height:145px;
}

label {
	display : block ; /* 새 라인에서 시작 */
	padding : 5px;
	text-align : center;
}
</style>

<script type="text/javascript" 
	src="${path}/a00_main_com/jquery-3.5.1.js"></script>
<script type="text/javascript">
//
   $(document).ready(function(){
		$(".pdata").on("click",function(){
			// $(this) : 클릭한 class data를 지정
			// .children() : 바로 밑 하위 td들을 지정.
			// eq.(0) : tr하위 td의 첫번째.
			var board_no =  $(this).eq(0).text();
			// /empDetail.do
			// alert(empno); // 요청값 넘길 시 , 반드시 확인
			// ${path} // 컨드롤러 uri이름?요청key=+요청값;
			location.href="${path}/boardConDetail.do?board_no="+board_no;
		});     	 
   });
</script>

</head>
 <body>
	<div style="display: flex; font-size: 14px;">
		<div style="flex-direction: column;">
			<span class="content-title" >사진첩</span>	
			<hr style="margin-block-end: 0px; width: 100%;">		  
			<table class="tableSize" style="margin-top: 7px;">
			 	<col width="25%"><col width="25%"><col width="25%"><col width="25%">
			 	<tr height="50%">
			 	<c:forEach var="blp" items="${bplist}" begin="0" end="4">
				 		<td class="pdata"><img class="impPList" src="${path}/miniHome/img/${blp.board_picture}"></img><span style="display:none;">${blp.board_no }</span></td>
			 	</c:forEach>
			 	</tr>
			 	<%--
			 	<col width="25%"><col width="25%"><col width="25%"><col width="25%">
			 	<c:forEach var="blp" items="${bplist}" begin="1" end="2">
			 	<tr height="50%">
				<c:forEach var="blp" items="${bplist}" begin="1" end="4">
				 		<td style="display:none;">${blp.board_no }</td>
				 		<td><img class="impPList" src="${path}/miniHome/img/${blp.board_picture}"></img></td>
			 	</c:forEach>
			 	</tr>
			 	</c:forEach>
			 	 --%>
			 </table>
			 <hr style="margin-block-end: 0px; width: 100%;">
			<div class="paging">
				<span data-page=1><a href="hmain.do?ppage=1&pperPageNum=4" class="bt">&lt;&lt;</a></span>
				<c:if test="${bplPageObject.page > 1 }">
					<span data-page=${bplPageObject.page -1 }><a href="hmain.do?ppage=${bplPageObject.page - 1}&pperPageNum=4" class="bt">&lt;</a></span>
				</c:if>
				<c:forEach begin="${bplPageObject.startPage }" end="${bplPageObject.endPage }" var="cnt">
					<span ${(bplPageObject.page == cnt)?"class=\"active\"":"" } data-page=${cnt }>
						<a href="hmain.do?ppage=${cnt}&pperPageNum=4" >${cnt}</a>
					</span>
				</c:forEach>
				<c:if test="${bplPageObject.page != bplPageObject.endPage }">
					<span data-page=${bplPageObject.page + 1 }><a href="hmain.do?ppage=${bplPageObject.page + 1}&pperPageNum=4" class="bt">&gt;</a></span>
				</c:if>
				<span data-page=${bplPageObject.totalPage }><a href="hmain.do?ppage=${bplPageObject.totalPage}" class="bt">&gt;&gt;</a></span>
			</div>
		</div>
	</div>
</body>
</html>