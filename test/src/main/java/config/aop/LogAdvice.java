/**
* <pre>
* 1. 패키지명 : net.macaronics.web.controller
* 2. 타입명 : test2.java
* 3. 작성일 : 2017. 10. 24. 오후 7:40:39
* 4. 저자 : 최준호
* 
* </pre>
*
*/
package config.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // 스프링에서 관리하는 bean
@Aspect // aop bean
public class LogAdvice {

	// 로그 수집 객체
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

	// ProceedingJoinPoint 클래스는 around 에서 만 가능
	// @Around("execution( * net.macaronics.web.controller..*Controller.*(..))"
	// + " or execution( * net.macaronics.web.persistence..*Impl.*(..))"
	// + " or execution( * net.macaronics.web.service..*Impl.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {

		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();

		String type = joinPoint.getSignature().getDeclaringTypeName();

		String name = "";

		if (type.indexOf("Controller") > -1) {
			name = "Controller \t : ";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl \t: ";
		} else if (type.indexOf("DAO") > -1) {
			name = "persistence(DAO) \t: ";
		}
		// 클래스 + 매소드 이름

		logger.info("\n\n\n******* => " + name + type + "." + joinPoint.getSignature().getName() + "()");

		// 파라미터 값
		logger.info(Arrays.toString(joinPoint.getArgs()));

		long end = System.currentTimeMillis();
		long time = end - start;
		logger.info(result + " 실행시간 :" + time);
		return joinPoint.proceed();
	}

	// ProceedingJoinPoint 클래스는 around 에서 만 가능
	@Before("execution( *  net.macaronics.web.controller..*Controller.*(..))"
			+ " or execution( * net.macaronics.web.persistence..*Impl.*(..))"
			+ " or execution( * net.macaronics.web.service..*Impl.*(..))")
	public void logPrintBefore(JoinPoint joinPoint) throws Throwable {

		Class clazz = joinPoint.getTarget().getClass();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();

		String type = joinPoint.getSignature().getDeclaringTypeName();

		String name = "";

		if (type.indexOf("Controller") > -1) {
			name = "Controller \t : ";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl \t: ";
		} else if (type.indexOf("DAO") > -1) {
			name = "persistence(DAO) \t: ";
		}
		// 클래스 + 매소드 이름
		logger.info( "\n\n\n*******  Macaroncis AOP Annotation.beforeTargetMethod executed. => " );
		logger.info(" MVC 영역 - {} ,  Type - {} ", name , type);
		logger.info("클래스 명 - {}, 메서드 명 - {} ", className, methodName);
		
		// 파라미터 값
		logger.info("파라미터 값 : {}"  , Arrays.toString(joinPoint.getArgs()));
		
	}

	
	
	
	
	
}
