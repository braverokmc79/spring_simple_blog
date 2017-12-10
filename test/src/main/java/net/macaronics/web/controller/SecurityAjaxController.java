/**
* <pre>
* 1. 패키지명 : net.macaronics.web.controller
* 2. 타입명 : SecurityAjaxController.java
* 3. 작성일 : 2017. 12. 1. 오후 6:12:29
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.macaronics.web.domain.UserVO;

@Controller
@RequestMapping("/ajaxTest")
public class SecurityAjaxController {

	private static Logger logger =LoggerFactory.getLogger(SecurityAjaxController.class);
	
	@RequestMapping(value="/ajaxCsrfForm",  method=RequestMethod.GET )
	public String ajaxCsrfTestForm() throws Exception{
		
		return "ajax/csrfTest";
	}
	
	@RequestMapping(value="/ajaxCsrf", method=RequestMethod.POST)
	public void ajaxCsrfTest(HttpServletResponse response  ,String username, String password, String hobby) throws Exception{
		
		logger.info("넘겨온 값  {} , {} , {} " , username, password, hobby);
		
		PrintWriter out =response.getWriter();
		out.println("success");
		
	}
	
	
	
}










