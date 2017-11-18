package com.han.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by high on 2017. 11. 10..
 */
@Aspect
@Component
@Slf4j
public class AspectOriented {

    @Around("within(@com.han.common.annotation.AspectPrograming *) && execution(* com.han.services.*Service.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info("aop 입니당 : " + className);
        log.info("aop 입니당 before : " + methodName);
        joinPoint.proceed();
        log.info("aop 입니당 after : " + methodName);
    }
}