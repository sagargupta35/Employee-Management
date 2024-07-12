package com.luv2code.springboot.thymeleafdemo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    public void forController(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    public void forService(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    public void forDao(){}

    @Pointcut("forController() || forService() || forDao()")
    public void appFlow(){}

    @Before("appFlow()")
    public void beforeAdvice(JoinPoint joinPoint){

        // display method signature
        logger.info("=====>>> executing @Before: calling method: " + joinPoint.getSignature().toShortString());

        // display arguments
        Object [] args = joinPoint.getArgs();
        for (Object arg : args){
            logger.info("Argument: " + arg);
        }

    }

    @AfterReturning(pointcut = "appFlow()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result){

        // display method signature
        logger.info("=====>>> executing @Before: calling method: " + joinPoint.getSignature().toShortString());

        logger.info("Result of method: " + result);

    }

}
























