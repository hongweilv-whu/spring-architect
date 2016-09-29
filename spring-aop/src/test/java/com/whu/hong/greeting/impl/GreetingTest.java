package com.whu.hong.greeting.impl;

import com.whu.hong.greeting.Apology;
import com.whu.hong.greeting.Greeting;
import com.whu.hong.greeting.advices.GreetingAfterAdvice;
import com.whu.hong.greeting.advices.GreetingAroundAdvice;
import com.whu.hong.greeting.advices.GreetingBeforeAdvice;
import com.whu.hong.greeting.advices.GreetingBeforeAndAfterAdvice;
import com.whu.hong.greeting.proxy.CGLibDynamicProxy;
import com.whu.hong.greeting.proxy.GreetingProxy;
import com.whu.hong.greeting.proxy.JDKDynamicProxy;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Description:
 * Created by lvhw on 2016/9/21 21:44.
 */
public class GreetingTest {

    @Test
    public void testSayHello() throws Exception {

        Greeting greetingProxy = new GreetingProxy(new GreetingImpl());
        greetingProxy.sayHello("Jack");
    }

    @Test
    public void testJDKProxySayHello() throws Exception {

        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(new GreetingImpl());
        Greeting greetingProxy = (Greeting)jdkDynamicProxy.getProxy();
        greetingProxy.sayHello("Jack");
    }

    @Test
    public void testCGLibProxySayHello() throws Exception {

        CGLibDynamicProxy cglibDynamicProxy = CGLibDynamicProxy.getInstance();
        Greeting greetingProxy = (Greeting)cglibDynamicProxy.getProxy(GreetingImpl.class);
        greetingProxy.sayHello("Jack");
    }

    @Test
    public void testAdviceSayHello() throws Exception {

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new GreetingBeforeAdvice());
        proxyFactory.addAdvice(new GreetingAfterAdvice());
        proxyFactory.setTarget(new GreetingImpl());

        Greeting greetingProxy = (Greeting)proxyFactory.getProxy();

        greetingProxy.sayHello("Jack");
    }

    @Test
    public void testAroundAdviceSayHello() throws Exception {

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new GreetingBeforeAndAfterAdvice());
        proxyFactory.setTarget(new GreetingImpl());

        Greeting greetingProxy = (Greeting)proxyFactory.getProxy();

        greetingProxy.sayHello("Jack");
    }

    @Test
    public void testAliAroundAdviceSayHello() throws Exception {

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new GreetingAroundAdvice());
        proxyFactory.setTarget(new GreetingImpl());

        Greeting greetingProxy = (Greeting)proxyFactory.getProxy();

        greetingProxy.sayHello("Jack");
    }


    @Test
    public void testConfigBasedSayHello() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); // 获取 Spring Context
        Greeting greeting = (Greeting) context.getBean("greetingProxy");                        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        greeting.sayHello("Jack");

        //greeting.sayNothing();

    }

    @Test
    public void testThrowAdviceSayHello() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); // 获取 Spring Context
        Greeting greeting = (Greeting) context.getBean("greetingProxy");                        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        greeting.sayHello("Jack");
    }

    @Test
    public void testIntroAdviceSayHello() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); // 获取 Spring Context
        GreetingImpl greetingImpl = (GreetingImpl) context.getBean("greetingProxy");                        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        greetingImpl.sayHello("Jack");

        //greetingImpl.sayNothing();

        Greeting greeting = (Greeting)greetingImpl;
        greeting.sayHello("Jack");

        Apology apology = (Apology)greetingImpl;
        apology.saySorry("Jack");
    }

    @Test
    public void testMethodBasedSayHello() throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); // 获取 Spring Context
        GreetingImpl greeting = (GreetingImpl) context.getBean("greetingProxy");                        // 从 Context 中根据 id 获取 Bean 对象（其实就是一个代理）
        greeting.sayHello("Jack");
        greeting.goodMorning("Jack");
        greeting.goodNight("Jack");

        //greeting.sayNothing();

    }
}