/**
* <pre>
* 1. 패키지명 : config.security3_2
* 2. 타입명 : ApplicationInitializer.java
* 3. 작성일 : 2017. 12. 16. 오후 4:56:14
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.security_sample_3_2;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
다음에는 보통 스프링 MVC를 이용해서 
애플리케이션을 구성하기 때문에 ApplicationIniticalizer에 WebSecurityConfigurerAdapter를 
상속받은 클래스를 getRootConfigClasses() 메소드에 추가하는 것으로 스프링 시큐리티에 대한
기본적인 적용은 끝입니다.
*/
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getRootConfigClasses()
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebSecurityConfig.class };
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer#getServletConfigClasses()
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletMappings()
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}

}
