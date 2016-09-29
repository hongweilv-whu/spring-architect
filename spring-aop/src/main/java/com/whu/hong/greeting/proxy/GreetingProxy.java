package com.whu.hong.greeting.proxy;


import com.whu.hong.greeting.Greeting;

/**
 * Description:
 * Created by lvhw on 2016/9/21 21:41.
 */
public class GreetingProxy implements Greeting {

    private Greeting greeting;

    public GreetingProxy(Greeting greeting) {
        this.greeting = greeting;
    }

    public void sayHello(String name) {
        before();
        greeting.sayHello(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
