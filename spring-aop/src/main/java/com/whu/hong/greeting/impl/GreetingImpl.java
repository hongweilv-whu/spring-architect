package com.whu.hong.greeting.impl;

import com.whu.hong.greeting.Greeting;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by lvhw on 2016/9/21 21:39.
 */
@Component
public class GreetingImpl implements Greeting {

    public void sayHello(String name) {
        //before();
        System.out.println("Hello! " + name);
        //throw new RuntimeException("Error"); // 故意抛出一个异常，看看异常信息能否被拦截到
        //after();
    }

    public void goodMorning(String name) {
        System.out.println("Good Morning! " + name);
    }

    public void goodNight(String name) {
        System.out.println("Good Night! " + name);
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
