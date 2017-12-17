<%@page import="net.macaronics.web.domain.UserVO"%>
<%@page import="org.springframework.security.core.userdetails.User"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<title>Home</title>
</head>


<body>
	<h1>Home!</h1>
	<sec:authorize access="isAnonymous()">
		<p>
			<a href="<c:url value="/login/loginForm.do" />">로그인</a>
		</p>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input type="submit" value="로그아웃" />
		</form:form>
	</sec:authorize>
	<h3>
		[<a href="<c:url value="/user/introduction.do" />">소개 페이지</a>] [<a
			href="<c:url value="/admin/adminHome.do" />">관리자 홈</a>]
	</h3>
	

<sec:authorize access="isAuthenticated()">
<%

User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

if(user!=null){
	System.out.println("username = " + user.toString());	
	out.write(user.getUsername());
}

%>

</sec:authorize>

<c:if test="${ not empty userVO }">
<br>
<h2>로그인한  정보 DB에서 개별 상세 정보 가져오기</h2>
${userVO.toString() }

</c:if>


</body>
</html>
