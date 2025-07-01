package com.teams.project.core.utilities.loggers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyLogger {
    Logger logger = LoggerFactory.getLogger(MyLogger.class.getName());


    public void logAfterThrowing(JoinPoint joinPoint, Throwable error ){
            logger.error("Error in : {} | Method: {} | Massage: {} " ,
                    error.getClass().getName(),
                    joinPoint.getSignature().getName()
                    ,error.getMessage());}

    public Object logAroundThrowing(ProceedingJoinPoint joinPoint) throws Throwable {
            long startTime = System.currentTimeMillis();
            logger.info("Method is calling: {}",joinPoint.getSignature().getName());
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            logger.info("Method is successfully executed: {} | Time: {} ms",joinPoint.getSignature().getName(),(endTime - startTime));
            return result;
        }
}

