/**
* <pre>
* 1. 패키지명 : net.macaronics.web.controller
* 2. 타입명 : LoginController.java
* 3. 작성일 : 2017. 11. 21. 오후 7:17:08
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
@RequestMapping(value="/login")
public class LoginController {
	
	private static final Logger logger=LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/loginForm.do", method=RequestMethod.GET)
	public String loginForm(Locale locale, Model model){
		logger.info("Welcome Login Form!");
		return "login/loginForm";
	}
	
	@RequestMapping(value="/accessDenied.do", method=RequestMethod.GET)
	public String accessDenied(Locale locale, Model model){
		logger.info("Welcome Access Denied!");
		return "login/accessDenied";
	}
	
}
