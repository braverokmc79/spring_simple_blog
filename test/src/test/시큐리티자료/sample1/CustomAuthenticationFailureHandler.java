/**
* <pre>
* 1. 패키지명 : config.security
* 2. 타입명 : AdminFailureHandler.java
* 3. 작성일 : 2017. 12. 16. 오후 2:40:08
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.security_sample_3_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

//spring security 로그인 실패시 오는 핸들러
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	
	private String defaultFailureUrl;
	
	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, 
			AuthenticationException authenticationException)
			throws IOException, ServletException {
		
		if(authenticationException instanceof AuthenticationException){
			response.sendRedirect(request.getContextPath() + defaultFailureUrl);
		}
		
		if(authenticationException instanceof LockedException){
			response.sendRedirect(request.getContextPath()+ defaultFailureUrl);
		}
		
		if(authenticationException instanceof BadCredentialsException){
			response.sendRedirect(request.getContextPath() + defaultFailureUrl);
		}
		
	}

	
}
