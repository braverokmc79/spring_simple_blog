<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta id="_csrf" name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta id="_csrf_header" name="_csrf_header" content="${_csrf.headerName}"/>


<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

<title>ajax csrf Test</title>
</head>
<body>


<form id="form1">
 <input type="text" name="username">
 <input type="text" name="password">
 <input type="text" name="hobby">
 <button id="btnAjax" type="button" >전송</button>
</form>


<div id="result">
</div>


<script>
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
 
$(function() {
	
	$("#btnAjax").click(function(){		
		var params=jQuery("#form1").serialize();	
		$.ajax({	
			url:"/ajaxTest/ajaxCsrf",
			type:"post",
			data:params,
	/* 		beforeSend : function(xhr){
	            xhr.setRequestHeader(header, token);
	        }, */
			success:function(result){
				
				if($.trim(result)=='success'){
					$("#result").html(params);
				}
			},
			error:function(result){
				alert("실패");	
			}
		});
		
	});

	
});
</script>




</body>
</html>

