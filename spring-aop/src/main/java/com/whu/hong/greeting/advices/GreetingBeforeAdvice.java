package com.whu.hong.greeting.advices;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Description:
 * Created by lvhw on 2016/9/21 22:29.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before!");
    }
}
