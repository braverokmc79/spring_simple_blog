<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="//cdn.ckeditor.com/4.7.3/standard/ckeditor.js"></script>
</head>
<body>

	<h1>&nbsp;</h1>
	<div class="row">
		<div class="col-xl-2 col-sm-2"></div>
		<div class="col-xl-8 col-sm-8">
			<table class="table">
				<tr>
					<td>내용</td>
					<td class="span12"><textarea rows="5" class="form-control" name="content"></textarea> 
					<!-- textarea 를 ckeditor 로 변경 시킴 -->
				</tr>
			</table>
		</div>
	</div>



<script>
	CKEDITOR.replace("content", {

		filebrowserUploadUrl : "/ckeditorupload3"
	// filebrowserImageUploadUrl: 'MacaronicsServlet?command=ckeditor_upload'	
	});
</script>
</body>
</html>
