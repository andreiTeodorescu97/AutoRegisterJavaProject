package com.auto.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto.service.LogService;

@Aspect
@Component
public class LoggingAspect {
	
	//setup logger
	@Autowired
	private LogService logService;
	
	//setup pointcut declarations
	@Pointcut("execution(* com.auto.controller.*.*(..))")
	private void forControllerPackage() {}
		
	@Pointcut("forControllerPackage()")
	private void forAppFlow() {}
	
	//@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
			//display method we are calling
			String logMessage = "Method Signature" + theJoinPoint.getSignature().toShortString();
			String logType = "CALL:";
			
			Object[] args = theJoinPoint.getArgs();
			
			logMessage = logMessage + "Parameters";
			
			for(Object tempArg : args) {
				logMessage = logMessage + "param: " + tempArg;
			}
			
			logService.addLogToDatabase(logType, logMessage);
	}
	
	@Around("execution(* com.auto.controller.*.*(..))")
	public Object aroundMethods(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		//get method 
		String logMessage = "==>Method Signature: " + theProceedingJoinPoint.getSignature().toShortString();
		String logType = "LOG";
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		Object result = null;
					
		result = theProceedingJoinPoint.proceed();
		
		//get ending timestamp
		long end = System.currentTimeMillis();
		//compute duration
		long duration = end - begin;
		//display duration
		logMessage = logMessage + "==>Duration " + duration / 1000.0 + " secs";
				
		logService.addLogToDatabase(logType, logMessage);
		
		return result;
	}
	
}
