package ru.lanit.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * ru.lanit.services.MyService.*(..))")
    public void callAtMyServicePublic() { }

    @Before("callAtMyServicePublic()")
    public void beforeCallAtMethod1(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(a -> a.toString())
                .collect(Collectors.joining(","));
        logger.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    @After("callAtMyServicePublic()")
    public void afterCallAt(JoinPoint jp) {
        logger.info("after " + jp.toString());
    }

    @AfterReturning(pointcut="execution(* ru.lanit.services.MyService.check(..))", returning="returnValue")
    public void afterReturningCallAt(JoinPoint jp, boolean returnValue) {
        System.out.println();
        logger.info("Inside RunAfterExecution.afterReturning() method...");
        logger.info("inserted after : " + jp.getSignature().getName());
        logger.info("Method returned value is : " + returnValue);
    }

}
