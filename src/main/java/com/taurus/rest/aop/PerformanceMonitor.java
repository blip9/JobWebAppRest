package com.taurus.rest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitor {

    public static final Logger logger = LoggerFactory.getLogger(PerformanceMonitor.class);
    @Around("execution(* com.taurus.rest.controller.JobRestController.*(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint){
        try{
            long start = System.currentTimeMillis();

            Object obj = joinPoint.proceed();
            long end = System.currentTimeMillis();
            logger.info("Time taken by "+joinPoint.getSignature().getName()+" : "+(end-start)+"ms"    ) ;
            return obj;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

}
