package com.teams.project.core.utilities.loggers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class BusineesLogger {
        Logger logger = LoggerFactory.getLogger(BusineesLogger.class.getName());

        @AfterThrowing(pointcut = "execution(* com.teams.project.business.*.*(..))", throwing = "error")
        public void logAfterThrowing(JoinPoint joinPoint, Throwable error ){
            logger.error("Error in : {} | Method: {} | Massage: {} " ,
                    error.getClass().getName(),
                    joinPoint.getSignature().getName()
                    ,error.getMessage());}
        @Around("execution(* com.teams.project.business.*.*(..))")
        public Object logAroundThrowing(ProceedingJoinPoint joinPoint) throws Throwable {
            long startTime = System.currentTimeMillis();
            logger.info(" Service Method is calling: {}",joinPoint.getSignature().getName());
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            logger.info("Service is successfully executed: {} | Time: {} ms",joinPoint.getSignature().getName(),(endTime - startTime));
            return result;}
}
