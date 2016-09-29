package com.whu.hong.greeting.advices;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Description:
 * Created by lvhw on 2016/9/21 22:36.
 */
public class GreetingBeforeAndAfterAdvice implements MethodBeforeAdvice, AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After!");
    }

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before!");
    }
}
