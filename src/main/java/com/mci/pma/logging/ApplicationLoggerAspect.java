package com.mci.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(com.mci.pma.controllers..*)")
	public void definePackagePointcuts() {
		// empty method to name the location specified in the pointcut
	}

	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint jp) {
		log.debug(" \n \n \n ");
		log.debug("****************** Before method execution ****************** \n {}.{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("____________________________________________________ \n \n \n");

		Object object = null;

		try {
			object = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug(" \n \n \n ");
		log.debug("****************** After method execution ****************** \n {}.{} () with arguments[s] = {}",
				jp.getSignature().getDeclaringTypeName(), jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
		log.debug("____________________________________________________ \n \n \n");

		return object;
	}
}
