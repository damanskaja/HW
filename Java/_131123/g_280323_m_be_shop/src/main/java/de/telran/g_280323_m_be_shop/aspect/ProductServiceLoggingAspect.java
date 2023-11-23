package de.telran.g_280323_m_be_shop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductServiceLoggingAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceLoggingAspect.class);

    @Before("execution(* de.telran.g_280323_m_be_shop.service.interfaces.ProductService.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        LOGGER.info("Method {} called with arguments: {}", methodName, args);
    }

    @After("execution(* de.telran.g_280323_m_be_shop.service.interfaces.ProductService.*(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        LOGGER.info("Method {} completed.", methodName);
    }
}
