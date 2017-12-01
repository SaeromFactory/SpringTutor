package com.han.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by high on 2017. 11. 10..
 */
@Aspect
@Component
public class AspectOriented {

    @Around("within(@com.han.common.annotation.AspectPrograming *) && execution(* com.han.services.*Service.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        joinPoint.proceed();
    }
}