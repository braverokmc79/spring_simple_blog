<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</head>
<body>

	<h1 class="text-center">회원 가입</h1>
	<div class="row">

		<div class="col-xs-3 col-sm-3 "></div>

		<div class="col-xs-6 col-sm-6">

			<form:form  method="post" commandName="usersVO">
				<table class="table">
					<tr>
						<td class="primary">아이디</td>
						<td><form:input path="userid" cssClass="form-control" />
						<br>
						<form:errors path="userid" cssClass="label label-danger" />
						<br>
						<span class="label label-danger">${idCheck}</span>
						</td>
					</tr>

					<tr>
						<td class="primary">비밀번호</td>
						<td>
						<form:password  path="userpw" cssClass="form-control" />
						<br>
						<form:errors path="userpw" cssClass="label label-danger" />
						</td>
					</tr>

					<tr>
						<td class="primary">비밀번호확인</td>
						<td><input type="password" name="userpwCheck" class="form-control" >
						 <br><span class="label label-danger">${pwCheck}</span>
						</td>
					</tr>

					<tr>
						<td class="primary">이름</td>
						<td><form:input  path="username" cssClass="form-control" />
						<br>
						<form:errors path="username"  cssClass="label label-danger"/>
						</td>
					</tr>

					<tr>
						<td class="primary">이메일</td>
						<td>
						<form:input  path="email" cssClass="form-control" />
						<br>
						<form:errors path="email" cssClass="label label-danger" />
						</td>
					</tr>

					<tr>
						<td class="primary">포인트</td>
						<td><form:input  path="upoint" cssClass="form-control" />
						<br>
						<form:errors path="upoint" cssClass="label label-danger" />
						</td>
					</tr>
					
					<tr>
						<td colspan="2">
							<input type="submit" value="전송" class="btn btn-success"> 
						</td>
					</tr>

				</table>
			</form:form>
		</div>
	</div>


</body>
</html>