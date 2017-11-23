<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>로그인 페이지</title>
</head>

<body onload="document.f.id.focus();">

<div class="row">
	<div class="col-xl-3 col-sm-3"></div>
	<div class="col-xl-4 col-sm-4">
	
	<h3>아이디와 비밀번호를 입력해주세요.</h3>

	<c:url value="/login" var="loginUrl" />

	<form:form name="f" action="${loginUrl}" method="post" >
		<c:if test="${param.error != null}">
			<p>아이디와 비밀번호가 잘못되었습니다.</p>
		</c:if>
		<c:if test="${param.logout != null}">
			<p>로그아웃 하였습니다.</p>
		</c:if>
		<p>
			<label for="username">아이디</label> <input type="text" id="id" name="id" class="form-control" />
		</p>
		<p>
			<label for="password">비밀번호</label> <input type="password" id="password" name="password" class="form-control" />	
		</p>
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
		<button type="submit" class="btn">로그인 </button>
	</form:form>


	</div>
</div>

</body>
</html>
