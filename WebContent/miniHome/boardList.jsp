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
<script src="${path}/a00_main_com/main.js"></script>
<style type="text/css">
td {
font-size:13px;
}

label {
	display : block ; /* 새 라인에서 시작 */
	padding : 5px;
	text-align : center;
}
.bList{
   color : black;
   text-decoration : none;
}

.paging {
   margin: 2px;
   text-align : center;

}
.paging a {
   display: inline-block;
   margin-left 10px;
   padding : 1px 3px;
   border : 1px solid #000;
   border-radius : 7px;
   font-size : 2px;
   
}
a.bt {
   border : 1px solid #dcdcdc;
   background : #dcdcdc;
}
</style>

<script type="text/javascript" 
	src="${path}/a00_main_com/jquery-3.5.1.js"></script>
<script type="text/javascript">
//
   $(document).ready(function(){
		$(".data").on("click",function(){
			// $(this) : 클릭한 class data를 지정
			// .children() : 바로 밑 하위 td들을 지정.
			// eq.(0) : tr하위 td의 첫번째.
			var board_no =  $(this).children().eq(0).text();
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
		<div class="col" style="display: flex; flex-direction: column;">
			<span class="content-title" >최근 게시글</span>			  
			<hr style="margin-block-end: 0px; width: 100%;">
			<table>
				<c:forEach var="bl" items="${blist}">
				<col width="0%">
				<col width="50%">
				<col width="50%">
				 	<tr class="data">
				 		<td style="display:none;">${bl.board_no }</td>
				 		<td>${bl.board_title }</td>
				 		<td style="text-align : right;"><fmt:formatDate  pattern="yyyy.MM.dd" value="${bl.board_date }"/>&nbsp;&nbsp;</td>
				 	</tr>
			 	</c:forEach>
			 </table>
			 <hr style="margin-block-end: 0px; width: 100%; margin-top: 10px;">				
			<div class="paging">
				<span data-page=1><a href="hmain.do?page=1&perPageNum=4" class="bt">&lt;&lt;</a></span>
				<c:if test="${blpageObject.page > 1 }">
					<span data-page=${blpageObject.page -1 }><a href="hmain.do?page=${blpageObject.page - 1}&perPageNum=4" class="bt">&lt;</a></span>
				</c:if>
				<c:forEach begin="${blpageObject.startPage }" end="${blpageObject.endPage }" var="cnt">
					<span ${(blpageObject.page == cnt)?"class=\"active\"":"" } data-page=${cnt }>
						<a href="hmain.do?page=${cnt}&perPageNum=4" >${cnt}</a>
					</span>
				</c:forEach>
				<c:if test="${blpageObject.page != blpageObject.endPage }">
					<span data-page=${blpageObject.page + 1 }><a href="hmain.do?page=${blpageObject.page + 1}&perPageNum=4"" class="bt">&gt;</a></span>
				</c:if>
				<span data-page=${blpageObject.totalPage }><a href="hmain.do?page=${blpageObject.totalPage}" class="bt">&gt;&gt;</a></span>
			</div>

		</div>

		<div class="col" style="padding-bottom: 5px">
			<span class="content-title" style="color: #fff;">더미</span>
			<hr class="dashed">
			<div class="row">
				<div class="col">
					&nbsp;게시글&nbsp;&nbsp;<a href="" class="board-count">${boardCnt }</a> 
				</div>
				<div class="col">
					&nbsp;팔로잉&nbsp;&nbsp;<a href="" class="board-count">${following }</a>
				</div>
			</div>
			<hr class="dashed">
			<div class="row">
				<div class="col">
					&nbsp;사진첩&nbsp;&nbsp;<a href="" class="board-count">${picList}</a>
				</div>
			  	<div class="col">
					&nbsp;팔로워&nbsp;&nbsp;<a href="" class="board-count">${follower }</a>
			  	</div>
			</div>
			<hr class="dashed">
			<div class="row">
			 	 <div class="col">
					&nbsp;방명록&nbsp;&nbsp;<a href="" class="board-count">${gbList }</a>
			  	</div>
			</div>
			<hr class="dashed">
		</div>
	</div>
	
</body>
</html>