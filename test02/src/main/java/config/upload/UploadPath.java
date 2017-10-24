/**
* <pre>
* 1. 패키지명 : config.upload
* 2. 타입명 : UploadPath.java
* 3. 작성일 : 2017. 10. 24. 오후 8:32:41
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.upload;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class UploadPath {

	public static String attach_path = "resources/upload/";

	public static String path(HttpServletRequest request) {
		String uploadPath = "";
		try {
			String root_path = request.getServletContext().getRealPath("/");

			uploadPath = root_path + attach_path.replace('/', File.separatorChar);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return uploadPath;
	}
	
}
