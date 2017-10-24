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
package config.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonException {

	private static final Logger logger = LoggerFactory.getLogger(CommonException.class);

	// 개발자 버전 - 에러메시지 상세 확인 error_datail 페이지로 이동
	public static final String DEFAULT_ERROR_VIEW = "error/error_developer";

	// 일반 - 에러메시지로 error 페이지로 이동
	// public static final String DEFAULT_ERROR_VIEW = "error/error";

		
	@ExceptionHandler(Exception.class)
	public String commonErrorMessage(Exception e) {
		logger.error("commonErrorMessage() , {}" , e.getMessage());	
		logger.error("@ExceptionHandler(Exception.class) --  {}", errorMessge(e.getStackTrace(), e.getMessage()));
		return DEFAULT_ERROR_VIEW;
	}

	@ExceptionHandler(RuntimeException.class)
	private ModelAndView handleRuntimeExceptionErrorMessage(RuntimeException e) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(DEFAULT_ERROR_VIEW);
		modelAndView.addObject("exception", e);
		logger.error("handleRuntimeExceptionErrorMessage() , {}" , e.getMessage());	
		logger.error("@ExceptionHandler(RuntimeException.class) --  {}", errorMessge(e.getStackTrace(), e.getMessage()));
		
		return modelAndView;
	}

	
	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String methodAnnotationException(Throwable e, HandlerMethod handlerMethod) {
		ResponseBody methodAnnotation = handlerMethod.getMethodAnnotation(ResponseBody.class);			
		if (methodAnnotation != null) {
			// @ResponseBody  어노테이션이 있으면 이렇게 처리 하시오 . - ajax 
			logger.error(" @ResponseBody 에서 일어난 에러");	
		}
		
		logger.error("methodAnnotation() , {}" , errorMessge(e.getStackTrace(), e.getMessage()));	
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName(DEFAULT_ERROR_VIEW);
		modelAndView.addObject("exception", e);
		
	  return DEFAULT_ERROR_VIEW;
	}

	
	private String errorMessge(StackTraceElement[] stes, String message){
		StringBuffer buffer =new StringBuffer();
		buffer.append("\n\n");
		buffer.append("★ ★ ★     에러 메시지 시작 ★★★  \n\n");
		buffer.append("getMessage() : " +message + "\n\n");	
		for(int i=0; i<stes.length; i++){
			if(i==0){
				buffer.append("★ 에러 시작 클래스 이름 className : " + stes[i].getClassName()+"\n" ); 						
				buffer.append("★ 에러 시작 메서드 이름(methodName) : " + stes[i].getMethodName() + ", line : " + stes[i].getLineNumber() +"\n\n");
			}else{
				buffer.append("STACKTRACE - className : " + stes[i].getClassName() + ", 메서드 이름(methodName) : " 
			              + stes[i].getMethodName() + ", line : " + stes[i].getLineNumber() +"\n");
			}
		}
		
		return buffer.toString();
	}

	
	
}




