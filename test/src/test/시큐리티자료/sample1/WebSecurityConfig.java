package config.security_sample_3_1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * DB 접속을 통하여 사용자 정보 및 권한을 확인할 Service
	 */
	// @Autowired
	// CustomUserDetailsService userService;

	/*
	 * AuthenticationManager 설정
	 * 
	 * <security:authentication-manager alias="authenticationManager">
	 * <security:authentication-provider user-service-ref="userService">
	 * <security:password-encoder ref="passwordEncoder" />
	 * </security:authentication-provider> </security:authentication-manager>
	 * 
	 * <bean id="passwordEncoder" class=
	 * "org.springframework.security.authentication.encoding.ShaPasswordEncoder">
	 * <constructor-arg value="256" /> </bean>
	 */

	/*
   <!--  provider  -->
    <authentication-manager>
        <authentication-provider >
        <password-encoder hash="bcrypt" />
        <jdbc-user-service 
            data-source-ref="dataSource"
            role-prefix=""
            users-by-username-query="select username, password, enabled from users where username = ?"
            authorities-by-username-query="select username, authority from authorities where username = ?"
            group-authorities-by-username-query="select g.id, g.group_name, 
            ga.authority from groups g, group_members gm, group_authorities ga where
             gm.username = ? and g.id = ga.group_id and g.id = gm.group_id"
        />
        </authentication-provider>
    </authentication-manager>

	 */
	
/*	@Override
	 protected void configure(AuthenticationManagerBuilder auth)
	   throws Exception {
	  auth
	   .userDetailsService(userService)
	   .passwordEncoder(new ShaPasswordEncoder(256));
	 }
*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		
		// TODO Auto-generated method stub
	//	auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN", "DBA");

		auth.inMemoryAuthentication().withUser("scott").password("tiger").roles("USER", "SETTING");
	}

	/**
	 * Security 권한체크에 해당하지 않도록 설정을 합니다. 해당 항목은 Security 4 에서 부터 적용이 됩니다.
	 * <security:http pattern="/resources/**" security="none" />
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		// web.ignoring().antMatchers("/static/**","/resources/**");
		web.ignoring().antMatchers("/resources/**");
	}
	
	

	/**
	 * <security:http auto-config="true" use-expressions="true"
	 * access-decision-manager-ref="accessDecisionManager">
	 *
	 * <security:custom-filter ref="requestProcessingFilter" before=
	 * "FORM_LOGIN_FILTER" />
	 *
	 * <security:intercept-url pattern="/favicon.ico" access="permitAll" />
	 * <security:intercept-url pattern="/login.htm" access="isAnonymous()" />
	 * <security:intercept-url pattern="/failureLogin.htm" access=
	 * "isAnonymous()" />
	 * <security:intercept-url pattern="/index.htm" access="permitAll" />
	 * <security:intercept-url pattern="/admsys/**" access="hasRole('SYSADM')"/>
	 * <security:intercept-url pattern="/**" access="hasCustomRole()" />
	 *
	 * <!-- Security 4에서는 CSRF 설정을 해줘야 합니다. 보안상 처리라고 하는데 사용하지 않는 것으로 처리하였습니다.
	 * CSRF 사용안함 설정 --> <security:csrf disabled="true"/>
	 *
	 * <security:form-login login-page="/login.htm" login-processing-url=
	 * "/login/process" username-parameter="userId" password-parameter=
	 * "userPass" default-target-url="/" authentication-success-handler-ref=
	 * "customeAuthenticationSuccessHandler" authentication-failure-handler-ref=
	 * "customeAuthenticationFailureHandler" />
	 *
	 * <security:logout logout-url="/logout.htm" logout-success-url=
	 * "/login.htm"/>
	 * <security:access-denied-handler error-page="/accessDenied.htm"/>
	 * </security:http>
	 */

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.httpBasic().and().authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.usernameParameter("email").passwordParameter("password").defaultSuccessUrl("/")
				.failureUrl("/login?error").permitAll();
	}

	/**
	 * AuthenticationSuccessHandler 설정 로그인 실패시 처리되는 Handler입니다.
	 *
	 * <bean id="customeAuthenticationFailureHandler" class=
	 * "com.intercast.security.handler.CustomAuthenticationFailureHandler">
	 * <property name="defaultFailureUrl" value="/failureLogin.htm" /> </bean>
	 * 
	 * @return
	 */
	public AuthenticationFailureHandler customAuthenticationFailureHandler() {
		CustomAuthenticationFailureHandler handler = new CustomAuthenticationFailureHandler();
		handler.setDefaultFailureUrl("/login/accessDenied.do");
		return handler;
	}

	/**
	 * AuthenticationSuccessHandler 설정 로그인 성공시 처리되는 Handler입니다.
	 *
	 * <bean id="customeAuthenticationSuccessHandler" class=
	 * "com.intercast.security.handler.CustomAuthenticationSuccessHandler">
	 * <property name="defaultTargetUrl" value="/index.htm" /> </bean>
	 * 
	 * @return
	 */
	public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() {
		LoginSuccessHandler handler = new LoginSuccessHandler();
		handler.setDefaultTargetUrl("/");
		return handler;
	}

	/**
	 * AccessDecisionManager 설정
	 *
	 * Security 설정중
	 * http.authorizeRequests().accessDecisionManager(accessDecisionManager())
	 * 에서 호출합니다. 권한 체크에 대한 여러가지 방법 중 AffirmativeBased 사용
	 *
	 * <bean id="accessDecisionManager" class=
	 * "org.springframework.security.access.vote.AffirmativeBased">
	 * <constructor-arg> <list> <ref bean="expressionVoter" /> </list>
	 * </constructor-arg>
	 * <property name="allowIfAllAbstainDecisions" value="false"/> </bean>
	 *
	 * @return
	 */
	@Bean
	public AffirmativeBased accessDecisionManager() {
		List<AccessDecisionVoter<?>> voters = new ArrayList<AccessDecisionVoter<?>>();
		voters.add(expressionVoter());

		AffirmativeBased affirmativeBased = new AffirmativeBased(voters);
		affirmativeBased.setAllowIfAllAbstainDecisions(false);
		return affirmativeBased;
	}

	/**로그인시에 세션에 저장하는 값들은 WebAttributes의 상수들 참조.
	 * 사용자 정의 권한을 사용하고자 할 경우 생성합니다. WebExpressionVoter에 생성한 권한 설정 Handler을 SET
	 * 합니다.
	 *
	 * <bean id="customExpressionHandler" class=
	 * "com.intercast.security.handler.CustomWebSecurityExpressionHandler">
	 * <property name="defaultRolePrefix" value="" /> </bean>
	 *
	 * <bean id="expressionVoter" class=
	 * "org.springframework.security.web.access.expression.WebExpressionVoter">
	 * <property name="expressionHandler" ref=
	 * "customExpressionHandler"></property> </bean>
	 *
	 * @return
	 */
	@Bean
	public WebExpressionVoter expressionVoter() {
		WebExpressionVoter voter = new WebExpressionVoter();
//
//		CustomWebSecurityExpressionHandler handler = new CustomWebSecurityExpressionHandler();
//		handler.setDefaultRolePrefix("");
//		voter.setExpressionHandler(handler);
		return voter;
	}

}
