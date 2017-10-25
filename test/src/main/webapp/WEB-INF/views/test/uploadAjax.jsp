<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.fileDrop{

	width:100%;
	height:200px;
	border:1px dotted blue;

}

small{
	margin-left:3px;
	font-weight:bold;
	color:gray;
}

</style>
</head>
<body>



<h3>Ajax File Upload</h3>
<div class="fileDrop"></div>
<div class="uploadedList"></div>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

<script>

$(function(){
	

	
	
	$(".fileDrop").on("dragenter dragover", function(event){
		event.preventDefault();
	});

	$(".fileDrop").on("drop", function(event){
		event.preventDefault();
		
		var files=event.originalEvent.dataTransfer.files;
		
		var file=files[0];
		
		console.log(file);
		var formData=new FormData();
		formData.append("file", file);

		$.ajax({
			
			url:'/test/uploadAjax2',
			data:formData,
			dataType:'text',
			processData:false,
			contentType:false,
			type:'POST',
			success:function(data){
				
				var str="";
				
				if(checkImageType(data)){
					
					str="<div>"
					 +"<a href='/displayFile?fileName="+getImageLink(data)+"' ><img src='/displayFile?fileName="+data+"'/>"
					  +getOriginalName(data)+"</a>";		 
				}else{
					str ="<div>"+getOriginalName(data);
					
				}
				str +="<button data-src="+data+">X</button></div>";
				$(".uploadedList").append(str);
				
			}
		});
				
	});
	
	//첨부파일 삭제 처리
	$(".uploadedList").on("click", "button", function(event){
		
		var that =$(this);
		$.ajax({
			url:"/deleteFile",
			type:"post",
			data:{
				fileName:$(this).attr("data-src")
			},
			dataType:"text",
			success:function(result){
				if(result=='deleted'){	
					//삭제후 화면에서 제거
					that.parent("div").remove();
				}	
			}
			
		});
		
	});
	
	
	
});


//이미지인지 패턴으로 확인
function checkImageType(fileName){
	
	var pattern=/jpg|gif|png|jpeg/i;
	
	return fileName.match(pattern);
	
}


//원본이미지 이름 출력
function getOriginalName(fileName){
	
	if(checkImageType(fileName)){
		//이미지 일경우
		var idx=fileName.lastIndexOf("_")+1;
		return fileName.substr(idx);
	}
	
	//일반 파일 일 경우
	var idx=fileName.indexOf("_")+1;
	return fileName.substr(idx);
	
}


//이미지 원본 파일 찾아서 링크로 연결 시키기
// /2017/10/23/s_4beb6430-7dfb-4def-bcfd-35f4425b538f_a1.jpg
function getImageLink(fileName){
	
	//이미지가 아니면 반환
	if(!checkImageType(fileName)){
		return ;
	}
	
	var front =fileName.substr(0,12);
	var end=fileName.substr(14);
	return front +end;
}

</script>


</body>
</html>



