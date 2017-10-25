/**
* <pre>
* 1. 패키지명 : net.macaronics.web.controller
* 2. 타입명 : test2.java
* 3. 작성일 : 2017. 10. 24. 오후 7:40:39
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import config.upload.MediaUtils;
import config.upload.UploadFileDisplay;
import config.upload.UploadFileUtils;
import config.upload.UploadSecurity;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="/test/uploadForm", method=RequestMethod.GET)
	public void uploadForm() throws Exception{	
	}
	
	
	@RequestMapping(value="/test/uploadForm", method=RequestMethod.POST)
	public void uploadForm(MultipartFile file, Model model ) throws Exception{
		logger.info("originalName :  "  + file.getOriginalFilename());
		logger.info("size : " + file.getSize());
		logger.info("contentType : " +file.getContentType());
		
		String savedName= uploadFile(file.getOriginalFilename(), file.getBytes());
		
		model.addAttribute("savedName", savedName);
	}
	
	//실질적으로 파일 저장
	private String uploadFile(String originalName, byte[] fileData) throws Exception{
		
		UUID uid=UUID.randomUUID();
	
		String savedName=uid.toString() + "_"+ originalName;
		
		File target =new File(uploadPath, savedName);
		
		FileCopyUtils.copy(fileData, target);
		
		return savedName;
	}
	
	
	//Ajax 업로드용 컨트롤러와 JSP 작성하기
	@RequestMapping(value="/test/uploadAjax", method=RequestMethod.GET)
	public void uploadAjax(){
		
	}
	
	
	
	//일반적인 파일 업로드
	@ResponseBody
	@RequestMapping(value="/test/uploadAjax", method=RequestMethod.POST,
					produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		
		logger.info("originalName ,  {} ",  file.getOriginalFilename());
		logger.info("size  : " , file.getSize());
		logger.info("contentType : " + file.getContentType());		
		return new ResponseEntity<String>(file.getOriginalFilename(), HttpStatus.CREATED);
	}
	
	
	   //년월일 폴더로 분리후 이미지일 경우 썸네일 이미지 생성
		@ResponseBody
		@RequestMapping(value="/test/uploadAjax2", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
		public ResponseEntity<String> uploadAjax2(MultipartFile file) throws Exception{
				//사이즈 가로 설정
			UploadFileUtils.setWIDTH_SIZE(200);	
			String uploadFile=UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		
			logger.info("originalName ,  {} ",  file.getOriginalFilename());
			logger.info("파일 저장후 반환 값 - ,  {} ",  uploadFile);
			
			return new ResponseEntity<String>(uploadFile, HttpStatus.CREATED);
		}
		
	
	
	
	//년월일 폴더로 분리후 이미지일 경우 썸네일 이미지 생성
	@ResponseBody
	@RequestMapping(value="/test/uploadAjax3", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax3(MultipartFile file) throws Exception{
		logger.info("originalName ,  {} ",  file.getOriginalFilename());	
		
		 String uploadFile="";
		// 보안상 , jpg, jpeg, png, gif, 만 업로드 되도록 수정 
		if(UploadSecurity.check(file)){
			//사이즈 가로 설정
			UploadFileUtils.setWIDTH_SIZE(200);
				
			uploadFile=UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		}else{
			uploadFile="허용되지 않은 파일 입니다.";
		}
			
		
		logger.info("파일 저장후 반환 값 - ,  {} ",  uploadFile);
		return new ResponseEntity<String>(uploadFile, HttpStatus.CREATED);
	}
	
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception{
		UploadFileDisplay display=UploadFileDisplay.getInstance();
		
		return display.disPlay(fileName, uploadPath);
	}
	
	
	
	//삭제 처리
	@ResponseBody
	@RequestMapping(value="/deleteFile", method=RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName){
		
		logger.info("delete file {} " , fileName);
		
		String formatName =fileName.substring(fileName.lastIndexOf(".")+1);
		
		MediaType mType =MediaUtils.getMediaType(formatName);
		
		if(mType!=null){
			//이미지 파일인경우
			//이미지 원본 파일 삭제
			String front =fileName.substring(0, 12);
			String end=fileName.substring(14);
			new File(uploadPath+(front+end).replace('/', File.separatorChar)).delete();
		}
		
		//일반 파일 삭제, 썸네일 이미지 삭제
		new File(uploadPath+fileName.replace('/', File.separatorChar)).delete();
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
	
	
	
}


