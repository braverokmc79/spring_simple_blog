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
package config.upload;

import org.springframework.web.multipart.MultipartFile;

//파일 업로드 종류 제한 보안 설정 
public class UploadSecurity {

	public static boolean check(MultipartFile uploadedFile) {

		if (!uploadedFile.isEmpty()) {

			String fileName = uploadedFile.getOriginalFilename();

			// jpg, jpeg, png, gif, 만 업로드 되도록 수정
			if (fileName.toLowerCase().endsWith(".jpg") || fileName.toLowerCase().endsWith(".jpeg")
					|| fileName.toLowerCase().endsWith(".png") || fileName.toLowerCase().endsWith(".gif")) {
				return true;
			}
		}

		return false;
	}

}
