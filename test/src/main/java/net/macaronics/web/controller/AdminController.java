/**
* <pre>
* 1. 패키지명 : net.macaronics.web.controller
* 2. 타입명 : AdminController.java
* 3. 작성일 : 2017. 11. 21. 오후 7:11:30
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package net.macaronics.web.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	private static final Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value="/admin/adminHome.do", method=RequestMethod.GET)
	public String home(Locale locale, Model model){
		logger.info("Welcome Admin Home!");
		return "admin/adminHome";
	}
	
}


