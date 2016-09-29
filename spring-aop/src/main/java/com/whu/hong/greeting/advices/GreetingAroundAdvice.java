package com.whu.hong.greeting.advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by lvhw on 2016/9/21 22:39.
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }}
