/**
* <pre>
* 1. 패키지명 : config.security
* 2. 타입명 : CustomAuthenticationSuccessHandler.java
* 3. 작성일 : 2017. 12. 16. 오후 3:22:36
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.security_sample_3_1;

import java.io.IOException;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

/*
 * 로그인 성공시 실행되는 클래스
 * 
 * */
//@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	private static final Logger logger =LoggerFactory.getLogger(LoginSuccessHandler.class);

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		logger.info("****** 로그인 성공 *********");
		logger.info("유저 이메일  :  {} ", authentication.getName());
		logger.info("로그인 권한 : ", authentication.getAuthorities().toString());
		logger.info("로그인 시각 : " , new Date().toString());
		
		HttpSession session =request.getSession();
		SavedRequest savedRequest =(SavedRequest)session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");

		if(savedRequest ==null){
			response.sendRedirect("/");
		}else{
			super.onAuthenticationSuccess(request, response, authentication);	
		}
		
	}
	
	
}
