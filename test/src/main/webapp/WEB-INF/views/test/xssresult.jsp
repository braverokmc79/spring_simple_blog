<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Macaronics.net</title>
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
<body>

	<h1 class="text-center">XSS Test</h1>
	<div class="row">
		<div class="col-xl-2 col-sm-2"></div>
		<div class="col-xl-8 col-sm-8">
			<c:forEach items="${message }" var="ms">
				<table class="table">
				    <tr>
				    	<td>아이디</td>
				    	<td>${ms.mid }</td>
				    </tr>
				    
					<tr>
						<td>targetid</td>
						<td>${ms.targetid}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td class="span12">${ms.message}</td>
					</tr>
					<tr>
						<td>sender</td>
						<td>${ms.sender}</td>
					</tr>

					<tr>
						<td colspan="2"><a href="xssform" >다시 테스트</a></td>
					</tr>
			</table>
			</c:forEach>
		</div>
	</div>




</body>
</html>
