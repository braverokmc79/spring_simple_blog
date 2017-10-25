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
package test.aop;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {

	private static final Logger logger =LoggerFactory.getLogger(SampleAdvice.class);
	
	//@Before("execution( * test.service.MessageService*.*(..))")
	public void startLog() throws Throwable{
		logger.info("----------------");
		logger.info("-----------------");
		
	}
	
	
	
	//@Around("execution( * test.service.MessageService*.*(..))"
	//		+ " or execution( * test.persistence.*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable{
		long startTime =System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));
		
		Object result=pjp.proceed();
		logger.info("----------------");
		logger.info("-----------------");
		
		long endTime=System.currentTimeMillis();		
		logger.info(pjp.getSignature().getName()+" : " + (endTime- startTime));
		logger.info("===============================================");
		
		return result;
	}
	
	
	
	
	
	
}
