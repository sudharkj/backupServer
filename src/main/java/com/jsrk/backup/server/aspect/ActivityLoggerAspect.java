package com.jsrk.backup.server.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Contains functions that log different activities of the application.
 */
@Component
@Aspect
public class ActivityLoggerAspect {

	private static Logger logger = Logger.getLogger(ActivityLoggerAspect.class);

	/**
	 * Logs the following details for each request to the application.
	 * <ul>
	 * <li>Request to the application</li>
	 * <li>Response of the application to the request</li>
	 * <li>Time-taken to respond by the application</li>
	 * </ul>
	 * 
	 * @param proceedingJoinPoint
	 *            Join-point (here it is a function) around which the advice
	 *            will run
	 * @return Object returned by the join-point function
	 * @throws Throwable
	 *             If the join-point function returns some error
	 */
	@Around("execution(public com.jsrk.backup.server.globals.Response com.jsrk.backup.server.controller.introduction.*.*(..))")
	public Object logActivity(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {

		long duration = -System.currentTimeMillis();
		Object object = proceedingJoinPoint.proceed();
		Object[] parameters = proceedingJoinPoint.getArgs();
		duration += System.currentTimeMillis();

		logger.info((MethodSignature) proceedingJoinPoint.getSignature()
				+ "\n\t" + parameters[0] + "\n\t" + object + "\n\tDuration="
				+ duration + "ms");

		return object;
	}

}
