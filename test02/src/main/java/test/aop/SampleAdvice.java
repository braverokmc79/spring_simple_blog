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
	
	@Before("execution( * test.service.MessageService*.*(..))")
	public void startLog() throws Throwable{
		logger.info("----------------");
		logger.info("-----------------");
		
	}
	
	
	
	@Around("execution( * test.service.MessageService*.*(..))"
			+ " or execution( * test.persistence.*.*(..))")
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
