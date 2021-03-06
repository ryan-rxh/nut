package com.nut.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	@Pointcut("execution(* com.nut.service..*.*(..))")
	public void log(){
	}
	
	@Before(value="log()")
	public void doBefore(JoinPoint jp){
		
		System.out.println(jp.getTarget().getClass() + " method " + jp.getSignature().getName() + " is called.");
	}
}
