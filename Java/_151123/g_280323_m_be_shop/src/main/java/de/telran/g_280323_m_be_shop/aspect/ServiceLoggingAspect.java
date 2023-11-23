package de.telran.g_280323_m_be_shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggingAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(ServiceLoggingAspect.class);

    @Before("execution(* de.telran.g_280323_m_be_shop.service.interfaces.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        LOGGER.info("Method {} called with arguments: {}", methodName, args);
    }

    @After("execution(* de.telran.g_280323_m_be_shop.service.interfaces.*.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("Method {} completed.", methodName);
    }

    @AfterReturning(pointcut = "execution(* de.telran.g_280323_m_be_shop.service.interfaces.*.*(..))",
            returning = "result")
    public void logMethodResult(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("Method {} completed successfully. Result: {}", methodName, result);
    }

    @AfterThrowing(pointcut = "execution(* de.telran.g_280323_m_be_shop.service.interfaces.*.*(..))",
            throwing = "error")
    public void logMethodError(JoinPoint joinPoint, Throwable error) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.error("Method {} encountered an error: {}", methodName, error.getMessage());
    }
}
