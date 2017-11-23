/**
* <pre>
* 1. 패키지명 : net.macaronics.web.controller
* 2. 타입명 : UserController.java
* 3. 작성일 : 2017. 11. 22. 오후 5:10:15
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
@RequestMapping(value="/user/")
public class UserController {

	private static Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "introduction.do", method = RequestMethod.GET)
	public String introduction(Locale locale, Model model) {
		logger.info("Welcome Introduction!");
		
		return "user/introduction";
	}
	
	
	
}



