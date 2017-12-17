/**
* <pre>
* 1. 패키지명 : config.security
* 2. 타입명 : CustomWebSecurityExpressionHandler.java
* 3. 작성일 : 2017. 12. 16. 오후 4:00:53
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.security_sample_3_1;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebExpressionVoter;

public class CustomWebSecurityExpressionHandler extends WebExpressionVoter {

	@Override
	public int vote(Authentication authentication, FilterInvocation fi, Collection<ConfigAttribute> attributes) {
		// TODO Auto-generated method stub
		return super.vote(authentication, fi, attributes);
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return super.supports(attribute);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return super.supports(clazz);
	}

	@Override
	public void setExpressionHandler(SecurityExpressionHandler<FilterInvocation> expressionHandler) {
		// TODO Auto-generated method stub
		super.setExpressionHandler(expressionHandler);
	}

	
	
}
