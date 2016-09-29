package com.whu.hong.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by lvhw on 2016/9/20 0:32.
 */
@Component
@Aspect
public class PermissionCheckerAspect {

    @Pointcut("execution(* com.whu.hong.service.PersonService.addPerson(..))")
    private void pointcutBefore(){}

    @Pointcut("execution(* com.whu.hong.service.PersonService.deletePerson(..))")
    private void pointcutAfter(){}

    @Pointcut("execution(* com.whu.hong.service.PersonService.editPerson(..))")
    private void pointcutOther(){}

    @Before("pointcutBefore()")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("Before " + joinPoint.getSignature().getName());
    }

    @After("pointcutAfter()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("After " + joinPoint.getSignature().getName());
    }

    @AfterReturning("pointcutAfter()")
    public void afterReturningAdvice(JoinPoint joinPoint){
        System.out.println("AfterReturning " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("pointcutOther()")
    public void afterThrowingAdvice(JoinPoint joinPoint){
        System.out.println("AfterThrowing " + joinPoint.getSignature().getName());
    }

    @Around("pointcutOther()")
    public void aroundAdvice(ProceedingJoinPoint pjoinPoint){
        System.out.println("AfterThrowing " + pjoinPoint.getSignature().getName());
    }
}
