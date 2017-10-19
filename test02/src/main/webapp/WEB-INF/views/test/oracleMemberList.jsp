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
				  <td colspan="8" class="text-center">페이징 처리만</td>
				</tr>
				
				  <tr>
					<td colspan="8" class="text-center">
					 <ul class="pagination">
						 <!-- [처음] -->
    <c:if test="${pageMaker.curBlock >1 }">
    	<li><a href="oracleMemberListSearch?page=1&perPageNum=10" >[처음]</a></li>
    </c:if>
   
    <!-- [이전] -->
    <c:if test="${pageMaker.curBlock >1 }">
    	<li><a href="oracleMemberListSearch?page=${pageMaker.prevPage}&perPageNum=10" >[이전]</a></li>
    </c:if>
   
   <c:forEach var="num" begin="${pageMaker.blockBegin}" end="${pageMaker.blockEnd}">
	  <c:choose>
	  	<c:when test="${num == pageMaker.page}">
	  	 <li class='active'><a href="oracleMemberListSearch?page=${num}&perPageNum=10">${num}</a></li>
	  	</c:when>
	  	<c:otherwise>
	  	 <li> <a href="oracleMemberListSearch?page=${num}&perPageNum=30">${num}</a></li>	
	  	</c:otherwise>
	  </c:choose>	  
   </c:forEach> 

	  <!-- [다음] -->
    <c:if test="${pageMaker.curBlock < pageMaker.totBlock }">
    	<li><a href="oracleMemberListSearch?page=${pageMaker.nextPage}&perPageNum=10" >[다음]</a></li>
    </c:if>
   
    <!-- [마지막] -->
    <c:if test="${pageMaker.curBlock < pageMaker.totBlock }">
    	<li><a href="oracleMemberListSearch?page=${pageMaker.totPage}&perPageNum=10" >[마지막]</a></li>
    </c:if>
    </ul>
					</td>
	</tr>
	
	
	
	
	<!-- ---      makeQuery() 사용     -->
				   <tr>
				  <td colspan="8" class="text-center"> makeQuery() 사용</td>
				</tr>
				
			<tr>
						<td colspan="8" class="text-center">
						
					 <ul class="pagination">
						 <!-- [처음] -->
    <c:if test="${pageMaker.curBlock >1 }">
    	<li><a href="oracleMemberListSearch${pageMaker.makeQuery(1) }" >[처음]</a></li>
    </c:if>
   
    <!-- [이전] -->
    <c:if test="${pageMaker.curBlock >1 }">
    	<li><a href="oracleMemberListSearch${pageMaker.makeQuery(pageMaker.prevPage) }" >&laquo;</a></li>
    </c:if>
   
   <c:forEach var="num" begin="${pageMaker.blockBegin}" end="${pageMaker.blockEnd}">
	  <c:choose>
	  	<c:when test="${num == pageMaker.page}">
	  	 <li class='active'><a href="oracleMemberListSearch${pageMaker.makeQuery(num) }">${num}</a></li>
	  	</c:when>
	  	<c:otherwise>
	  	 <li> <a href="oracleMemberListSearch${pageMaker.makeQuery(num) }">${num}</a></li>	
	  	</c:otherwise>
	  </c:choose>	  
   </c:forEach> 

	  <!-- [다음] -->
    <c:if test="${pageMaker.curBlock < pageMaker.totBlock }">
    	<li><a href="oracleMemberListSearch${pageMaker.makeQuery(pageMaker.nextPage) }" >&raquo;</a></li>
    </c:if>
   
    <!-- [마지막] -->
    <c:if test="${pageMaker.curBlock < pageMaker.totBlock  }">
    	<li><a href="oracleMemberListSearch${pageMaker.makeQuery(pageMaker.totPage) }" >[마지막]</a></li>
    </c:if>
    </ul>
					</td>
	</tr>
	
					
					<!-- 페이징 부트스트랩 -->
					<tr>
					  <td colspan="8" class="text-center">
					   페이징 부트스트랩 bootStrapPagingHTML  사용
					  </td>
					</tr>
					<tr>
					  <td colspan="8" class="text-center">
					    ${pageMaker.bootStrapPagingHTML('oracleMemberListSearch') }
					  </td>
					</tr>
		
							<!-- 검색 추가 페이징 부트스트랩  -->
					<tr>
					  <td colspan="8" class="text-center">
					  검색 추가 페이징 부트스트랩 bootStrapPagingSearchHTML  사용
					  </td>
					</tr>
					<tr>
					  <td colspan="8" class="text-center">
					    ${pageMaker.bootStrapPagingSearchHTML('oracleMemberListSearch') }
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
		
		  var url ="oracleMemberListSearch${pageMaker.makeQuery(1)}";
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



