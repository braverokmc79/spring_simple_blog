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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</head>

<body>

	<h1 class="text-center">회원 가입</h1>
	<div class="row">

		<div class="col-xs-3 col-sm-3 "></div>

		<div class="col-xs-6 col-sm-6">

			<form:form  method="post" commandName="vo">
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

<!-- 



http://superfelix.tistory.com/70


http://happybuk.tistory.com/entry/REPLACEALL-%ED%8A%B9%EC%88%98%EB%AC%B8%EC%9E%90-%EC%A0%9C%EA%B1%B0-%EC%9D%B4%EB%A9%94%EC%9D%BC-%EC%9C%A0%ED%9A%A8%EC%84%B1-%EC%97%B0%EC%86%8D-%EB%90%9C-%EC%8A%A4%ED%8E%98%EC%9D%B4%EC%8A%A4-%EC%A0%9C%EA%B1%B0-%EC%A0%95%EA%B7%9C%EC%8B%9D


http://highcode.tistory.com/6

http://xxxelppa.tistory.com/56


비밀번호 유효성 체크 ( 문자, 숫자, 특수기호 ) http://ibulkamgodoldol.tistory.com/20 -->

</body>
</html>