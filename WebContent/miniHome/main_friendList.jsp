<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/a00_main_com/main.css">
<script type="text/javascript"
	src="${path}/a00_main_com/jquery-3.5.1.js"></script>

<style type="text/css">

/* main tap 처리 */
        .main {
            min-width: 320px;
            max-width: 800px;
            padding: 40px;
            margin: 0 auto;
            background: #ffffff;}

        section {
            display: none;
            padding: 5px;
            border-top: 1px solid #ddd;}

        /*라디오버튼 숨김*/
        input[type=radio] {
              display: none;}

        label {
            display: inline-block;
            margin: 0 0 -1px;
            padding: 10px 25px;
            font-weight: 600;
            text-align: center;
            color: #bbb;
            border: 1px solid transparent;}

        label:hover {
            color: #3f9cb9;
            cursor: pointer;}

        /*input 클릭시, label 스타일*/
        input:checked + label {
              color: #555;
              border: 1px solid #ddd;
              border-top: 2px solid #3f9cb9;
              border-bottom: 1px solid #ffffff;}

        #tab1:checked ~ #content1,
        #tab2:checked ~ #content2,
        #tab3:checked ~ #content3,
        #tab4:checked ~ #content4 {
            display: block;}
            
/* 검색창-검색버튼 */
	 input[type=submit] {
            background-color : #f0f0f0;}

/* 테이블 */
		.tg {
		border-collapse : collapse;
		border-color : #ccc;
		border-spacing : 0;
		}
		.tg td {
		background-color : #fff;
		border-bottom-width : 1px;
		border-color : #ccc;
		border-style : solid;
		border-top-width : 1px;
		border-width : 0;
		color : #333;
		font-family : Arial, sans-serif;
		font-size : 14px;
		overflow : hidden;
		padding : 10px 5px;
		word-break : normal;
		}
		.tg th {
		background-color : #f0f0f0;
		border-bottom-width : 1px;
		border-color : #ccc;
		border-style : solid;
		border-top-width : 1px;
		border-width : 0;
		color : #333;
		font-family : Arial, sans-serif;
		font-size : 14px;
		font-weight : normal;
		overflow : hidden;
		padding : 10px 5px;
		word-break : normal;
		}
		.tg .tg-2k8k {
		border-color : inherit;
		font-size : 13px;
		font-weight : bold;
		text-align : center;
		vertical-align : top;
		position: sticky;
		top: 0;
		}
		.tg .tg-76qt {
		border-color : inherit;
		font-size : 13px;
		text-align : center;
		vertical-align : top;
		}
		.paging .hide {
		display : block;
		height : 0;
		width : 0;
		font-size : 0;
		line-height : 0;
		margin : 0;
		padding : 0;
		overflow : hidden;
		}
		

</style>

<!--
	$(".data").on("click",function(){
			// $(this) : 클릭한 class data를 지정
			// .children() : 바로 밑 하위 td들을 지정.
			// eq.(0) : tr하위 td의 첫번째.
			var board_no =  $(this).children().eq(0).text();
			// /empDetail.do
			// alert(empno); // 요청값 넘길 시 , 반드시 확인
			// ${path} // 컨드롤러 uri이름?요청key=+요청값;
			location.href="${path}/boardConDetail.do?board_no="+board_no;
		});     	  -->

<script type="text/javascript">
function logout(obj){
    location.href = "${path}/logout.do?logout=y";
 }
$(document).ready(function(){
    $(".data").on("dblclick",function(){
        var mem_id = $(this).children().eq(1).text();
        location.href="${path}/hmain2.do?mem_id="+mem_id;//상대 홈피로?
     });
    
 });

</script>
</head>
<body class="body">
	<div style="width: 100%; max-width: 1100px;">
		<jsp:include page = "main_left.jsp"></jsp:include>
	</div>
	<!-- 오른쪽 inner-box(삭제x) -->
	<div class="outer-box border-right-box"
		style="width: 72%; padding: 20px 20px 20px 0px">
		<div class="inner-box" style="padding: 10px 110px 10px 5px;">
			<div class="content-box-header">
				<h1 style="margin: 0px; font-size: 1.3em; font-weight: 550;"
					class="color-blue">&nbsp;&nbsp;5조의 미니홈피에 오신 것을 환영합니다~!</h1>
				<span style="font-size: 12px;">http://www.myworld.com</span>
			</div>
			<div class="content-box" style="padding: 10px 20px; height: 560px">
				<div style="display: flex; font-size: 14px;">
					<div style="flex-direction: column;">
						<span class="content-title">친구목록</span>
						<hr style="margin-block-end: 0px; width: 100%;">
						
						<!-- 친구목록 코드 삽입 -->
	<!-- tap 1,2,3  -->
	 
<div class="main">
    <input id="tab1" type="radio" name="tabs" checked> <!--디폴트 메뉴-->
    <label for="tab1">팔로잉 목록</label>

    <input id="tab2" type="radio" name="tabs">
    <label for="tab2">팔로워 목록</label>

    <input id="tab3" type="radio" name="tabs">
    <label for="tab3">새 친구 찾기</label>


<!-- 검색창 -->
    <section id="content1">
      <br>
      <div style="width:130px; float:left">총 ${followingList.size()}명의 친구 </div>                		
      <div style="width:350px; float:right">
      	<form method="post">
				<select name="choice" >
					<option value="name">이름</option>
					<option value="id" >아이디</option>
				</select>
				<input type="text" name="search"  value="${param.search}" placeholder="이름/아이디 입력">
				<input type="submit" value="검색하기">
 		</form>      
       </div>   		
      <br><br><br>
      
<!-- 검색 결과 테이블 --> 
	<div style="width:100%; height:300px; overflow:auto">					  
		<table class="tg" style="undefined; table-layout: fixed; width: 533px">
			<col style="width: 98px">
			<col style="width: 140px">
			<col style="width: 280px">
			  <tr class="data">
			    <th class="tg-2k8k">이름</th>
			    <th class="tg-2k8k">아이디</th>
			    <th class="tg-2k8k">이메일</th>
			  </tr>
			<tbody>
			<%--controller에서 넘겨온 model데이터 
		request.setAttribute("followingList", dao.followingList(null));
		 --%>
			<c:forEach var="fl" items="${followingList}">
				<tr class="data">
			    <td class="tg-76qt">${fl.mem_name}</td>
			    <td class="tg-76qt">${fl.mem_id }</td>
			    <td class="tg-76qt">${fl.mem_email}</td>
			  </tr>
			</c:forEach>
			</tbody>
			</table>
		</div>	
    </section>

    <section id="content2">
	<!-- 검색창 -->
      <br>
      <div style="width:130px; float:left">총 ${followingList.size()}명의 친구 </div>                		
      <div style="width:350px; float:right">
      	<form method="post">
				<select name="choice" >
					<option value="name">이름</option>
					<option value="id" >아이디</option>
				</select>
				<input type="text" name="search" placeholder="이름/아이디 입력">
				<input type="submit" value="검색하기">
 		</form>      
       </div>   		
      <br><br><br>
	<!-- 검색 결과 테이블 -->
	<div style="width:100%; height:300px; overflow:auto">											
		<table class="tg" style="undefined; table-layout: fixed; width: 533px">
			<col style="width: 98px">
			<col style="width: 140px">
			<col style="width: 280px">
			<tr class="data">
			    <th class="tg-2k8k">이름</th>
			    <th class="tg-2k8k">아이디</th>
			    <th class="tg-2k8k">이메일</th>
			  </tr>
			<tbody>
			<%--controller에서 넘겨온 model데이터 
		request.setAttribute("followingList", dao.followingList(null));
		 --%>
			<c:forEach var="fl" items="${followerList}">
			 	<tr class="data">
			    <td class="tg-76qt">${fl.mem_name}</td>
			    <td class="tg-76qt">${fl.mem_id }</td>
			    <td class="tg-76qt">${fl.mem_email}</td>
			  </tr>
			</c:forEach>
			</tbody>
			</table>
		</div>	
    </section>

    <section id="content3">
	<!-- 검색창 -->
      <br>
      <div style="width:130px; float:left">총 ${followingList.size()}명의 친구 </div>                		
      <div style="width:350px; float:right">
      	<form method="post">
				<select name="choice" >
					<option value="name">이름</option>
					<option value="id" >아이디</option>
				</select>
				<input type="text" name="search" placeholder="이름/아이디 입력">
				<input type="submit" value="검색하기">
 		</form>      
       </div>   		
      <br><br><br>
	<!-- 검색 결과 테이블 -->	
	<div style="width:100%; height:300px; overflow:auto">					
			<table class="tg" style="undefined;table-layout: fixed; width: 533px">
			<col style="width: 87px">
			<col style="width: 131px">
			<col style="width: 240px">
			<col style="width: 80px">
			<thead>
			<tr class="data">
			    <th class="tg-2k8k">이름</th>
			    <th class="tg-2k8k">아이디</th>
			    <th class="tg-2k8k">이메일</th>
			    <th class="tg-2k8k">상태</th>
			  </tr>
			</thead> 
			<tbody>
			<%--controller에서 넘겨온 model데이터 
		request.setAttribute("followingList", dao.followingList(null));
		 --%>
			<c:forEach var="fl" items="${allList}">
				<tr class="data">
			    <td class="tg-76qt">${fl.mem_name}</td>
			    <td class="tg-76qt">${fl.mem_id }</td>
			    <td class="tg-76qt">${fl.mem_email}</td>
			    <td class="tg-76qt">${""}</td>
			  </tr>
			</c:forEach>
			</tbody>
			</table>
	 </div>		
    </section>


</div>
	


			
						<hr style="margin-block-end: 0px; width: 100%;">
						<!-- 버튼 삽입(필요 시) -->

							<div class="tody" >
						<span class="small-text">TOTAL</span>&nbsp;<span>${mainProfile.getTotal()}
						<input type = "button" value = "로그아웃" onclick = "logout()"/>
					<%-- 	${mainProfile.getHome_no()} --%>
						</span>
				</div>
				</div>
						<a href="${path}/hmain.do" class="menu-item menu-selected">홈</a>
				<a href="main_profile.jsp" class="menu-item" style="top: 98px">프로필</a>
				<a href="main_guestbook.jsp" class="menu-item" style="top: 136px">방명록</a>
				<a href="${path}/friendlist.do" class="menu-item" style="top: 174px">친구목록</a>
				<a href="${path}/bWrite.do" class="menu-item" style="top: 212px">게시물+</a>
				<a href="${path}/hmain.do" class="menu-item" style="top: 250px">내홈피</a>
					</div>
				</div>
			</div>
		</div>
</body>
</html>