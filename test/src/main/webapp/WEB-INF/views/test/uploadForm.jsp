<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<form id="form1" action="uploadForm" method="post" enctype="multipart/form-data">
		<input type="file" name="file">
		<input type="submit">
	</form>

		<script type="text/javascript">
			var savedName = '${savedName}';

			if (savedName != '') {
				alert(savedName);
				location.href = "/test/uploadForm";
			}
		</script>
</body>
</html>