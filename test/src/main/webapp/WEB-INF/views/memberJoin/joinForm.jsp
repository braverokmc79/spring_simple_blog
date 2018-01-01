<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>회원 가입</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<h1 class="text-center">회원 가입</h1>
	<div class="row">
		<div class="col-xs-3 col-sm-3"></div>
		<div class="col-xs-6 col-sm-6">
			'
			<form:form method="post" commandName="usersVO" action="/member/join.do">
				<table class="table">
					<tr>
						<td class="primary">아이디</td>
						<td><form:input path="username" cssClass="form-control" /> <br>
							<form:errors path="username" cssClass="label label-danger" /> <br>
							<span class="label label-danger">${idCheck}</span>
					    </td>		
					</tr>

					<tr>
						<td class="primary">비밀번호</td>
						<td><form:password path="password" cssClass="form-control" />
							<br> <form:errors path="password" cssClass="label label-danger" />
								
					    </td>			
					</tr>

					<tr>
						<td class="primary">비밀번호확인</td>
						<td><input type="password" name="pwCheck" class="form-control">
							 <br>
						<span class="label label-danger">${pwCheck}</span></td>
					</tr>

					<tr>
						<td class="primary">닉네임</td>
						<td><form:input path="nickname" cssClass="form-control" /> <br>
							<form:errors path="nickname" cssClass="label label-danger" /></td>
					</tr>

					<tr>
						<td class="primary">이메일</td>
						<td><form:input path="email" cssClass="form-control" /> <br>
							<form:errors path="email" cssClass="label label-danger" />
						</td>
					</tr>

					<tr>
						<td class="primary">포인트</td>
						<td><form:input path="upoint" cssClass="form-control" /> <br>
							<form:errors path="upoint" cssClass="label label-danger" />
						</td>
					</tr>

					<tr class="text-center">
						<td colspan="2"><input type="submit" value="회원가입" class="btn btn-success">
						</td>
					</tr>

				</table>
			</form:form>

		</div>
	</div>



</body>
</html>