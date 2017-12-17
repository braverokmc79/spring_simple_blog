/**
* <pre>
* 1. 패키지명 : config.security3_2
* 2. 타입명 : WebSecurityConfig.java
* 3. 작성일 : 2017. 12. 16. 오후 4:51:53
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.security_sample_3_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableGlobalMethodSecurity(securedEnabled=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().
		  and().authorizeRequests()
		  .antMatchers("/users/{userId}")
		  .access("@authenticationCheckHandler.checkUserId(authentication,#userId)")
		  .antMatchers("/admin/db/**").access("hasRole('ADMIN_MASTER') or hasRole('ADMIN') and hasRole('DBA')") 
		  .antMatchers("/register/**").hasRole("ANONYMOUS")
		  .and()
		  .formLogin()
		  	.loginPage("/login")
		  	.usernameParameter("email")
		  	.passwordParameter("password")
		  //	.successHandler(successHandler())
		  	//.failureHandler(failuserHandler())
		    .permitAll();
		/**
		    anoymouse() - 인증되지 않은 사용자가 접근할 수 있습니다.
			
			authenticated() - 인증된 사용자만 접근할 수 있습니다.
			
			fullyAuthenticated()  - 완전히 인증된 사용자만 접근할 수 있습니다.
			
			hasRole() or hasAnyRole() - 특정 권한을 가지는 사용자만 접근할 수 있습니다.
			
			hasAuthority() or hasAnyAuthority() - 특정 권한을 가지는 사용자만 접근할 수 있습니다.
			
			haslpAddress()  - 특정 아이피 주소를 가지는 사용자만 접근할 수 있습니다.
			
			access()  - SpEL 표현식에 의한 결과에 따라 접근할 수 있습니다.
			
			not() - 접근 제한 기능을 해제합니다.
			
			permitAll() or denyAll() - 접근을 전부 허용하거나 제한합니다.
			
			rememberMe() - 리멤버 기능을 통해 로그인한 사용자만 접근할 수 있습니다.
			
		*/
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("scott").password("tiger").roles("ROLE_USER");
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "DBA");
		auth.inMemoryAuthentication().withUser("scott").password("tiger").roles("USER", "SETTING");
	}
	
	
	
	
}





