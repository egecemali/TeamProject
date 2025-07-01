package com.teams.project.core.utilities.loggers;

import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class  ControllerLogger{

    Logger logger = LoggerFactory.getLogger(ControllerLogger.class);

    @Pointcut( "execution(* com.teams.project.api.controllers.*.*(..))")
    public void controllerMethod(){}



    @AfterThrowing(pointcut = "controllerMethod()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("Error in controller: {} | Method: {} | Massage: {} " ,
                error.getClass().getName(),
                joinPoint.getSignature().getName()
                ,error.getMessage());
    }


    @Around("controllerMethod()")
    public Object logAroundThrowing(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("Controller Method is calling: {}",joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
         logger.info("Controller Methos is successfully executed: {} | Time: {} ms",joinPoint.getSignature().getName(),(endTime - startTime));
        return result;
    }
}
