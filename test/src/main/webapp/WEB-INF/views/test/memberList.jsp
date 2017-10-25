<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<body>
	<h2>&nbsp;</h2>
	<div class="row">
	   <div class="col-xs-3 col-sm-3"> </div>
		<div class="col-xs-8 col-sm-8">
		  <div class="text-right">
		  	 <div class="box-body">
		  	 
		  	  <div class="col-sm-4">
		  	 	<select name="searchType" class="form-control" id="searchType">
		  	 	  <option value="n" <c:out value="${pageMaker.searchType == null ? 'selected' : '' }"/>  >----</option>
		  	 	  <option value="userid" <c:out value="${pageMaker.searchType eq 'userid' ? 'selected' : '' }"/> >아이디</option>
		  	 	  <option value="username"  <c:out value="${pageMaker.searchType eq 'username' ? 'selected' : '' }"/> >이름</option>
		  	 	  <option value="email" <c:out value="${pageMaker.searchType eq 'email' ? 'selected' : '' }"/>  >이메일</option>
		  	 	  <option value="all" <c:out value="${pageMaker.searchType eq 'all' ? 'selected' : '' }"/>  >아이디 or 이름 or 이메일</option>
		  	 	</select>
		  	 </div>
		  	 
		  	 <div class="col-sm-4">
		  	    <input type="text" name="keyword" id="keywordInput"  class="form-control" value="${pageMaker.keyword}">	 
		  	 </div>
		  	 <div class="col-sm-4 text-left">
		  	    <button id="searchBtn" class="btn btn-success" >검색</button>
		  	 </div>
		  	 	
		  	 </div>
		  </div>
		</div>
	 </div>

	

	<div class="row">
		

		
		<div class="col-xs-12 col-sm-12">
		   <div class="table-responsive">
			<table class="table">
			<caption class="text-center"><h3>회원 리스트</h3></caption>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>이메일</th>
					<th>점수</th>
					<th>등록일</th>
					<th>업데이트일</th>
				</tr>
				<c:forEach items="${list}" var="member">
					<tr>
						<th>${member.mid }</th>
						<th>${member.userid }</th>
						<th>${member.userpw }</th>
						<th>${member.username }</th>
						<th>${member.email }</th>
						<th>${member.upoint }</th>
						<th>${member.regdate }</th>
						<th>${member.updatedate }</th>
					</tr>
				</c:forEach>
				<tfoot>
					<tr>
					  <td colspan="8" class="text-center">
					<!-- jsp 로 출력 할경우  -->  	  
 	  <ul class="pagination">
 	  	 <c:if test="${pageMaker.prev}">
 	  	 	<li><a href="memberList${pageMaker.makeQuery(pageMaker.startPage -1)}">&laquo;</a></li>
 	  	 </c:if>
 	  
 	  	 <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage}" var="idx">
 	  	 	 <li
 	  	 	   <c:out value="${pageMaker.page ==idx? 'class=active' : ''}" />
 	  	 	  >
 	  	 	   <a href="memberList${pageMaker.makeQuery(idx)}">${idx}</a></li>
 	  	 </c:forEach>	
 	  	 
 	  	 <c:if test="${pageMaker.next && pageMaker.endPage >0 }">
 	  	    <li><a href="memberList${pageMaker.makeQuery(pageMaker.endPage +1)}">&raquo;</a></li>
 	  	 </c:if> 
 	  </ul>
				
				<br>
				<!-- bootStrapPagingHTML 로 출력 할경우  -->  
				${pageMaker.bootStrapPagingHTML("memberList") }
				
				 </td>
					</tr>
		
		<!--  ----------------------------------------------  -->
		<!--  ----------------------------------------------  -->
		<!--  ----------------------------------------------  -->
		<!--  ----------------------------------------------  -->
		<!--  ----------------------------------------------  -->
		<!--  ----------------------------------------------  -->
		<!--  ----------------------------------------------  -->
		
				<!-- 검색 처리 추가시 -->
				<tr>
				 	<td colspan="8" class="text-center">검색처리 추가된 페이징  처리</td>
				</tr>			
					<tr>
					<td colspan="8" class="text-center">
					
					
					
									<!-- jsp 로 출력 할경우  -->  	  
 	  <ul class="pagination">
 	  	 <c:if test="${pageMaker.prev}">
 	  	 	<li><a href="memberListSearch${pageMaker.makeSearch(pageMaker.startPage -1)}">&laquo;</a></li>
 	  	 </c:if>
 	  
 	  	 <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage}" var="idx">
 	  	 	 <li
 	  	 	   <c:out value="${pageMaker.page ==idx? 'class=active' : ''}" />
 	  	 	  >
 	  	 	   <a href="memberListSearch${pageMaker.makeSearch(idx)}">${idx}</a></li>
 	  	 </c:forEach>	
 	  	 
 	  	 <c:if test="${pageMaker.next && pageMaker.endPage >0 }">
 	  	    <li><a href="memberListSearch${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
 	  	 </c:if> 
 	  </ul>
				
				<br>
				<!-- bootStrapPagingSearchHTML 로 출력 할경우  -->  
				${pageMaker.bootStrapPagingSearchHTML("memberListSearch") }
				
				 </td>
					
				
					
					</tr>
					
					
				</tfoot>
			</table>
			</div>
		</div>
	</div>

<script>
$(document).ready(function(){
	
	$("#searchBtn").on("click",
		function(event){
		
		  var url ="memberListSearch${pageMaker.makeQuery(1)}";
		  url +="&searchType="+searchType()+"&keyword="+keywordInput();
	      self.location =url;	
	});

});

function searchType(){
	return $("#searchType").val();
}

function keywordInput(){
	return $("#keywordInput").val();
}
</script>


</body>
</html>



