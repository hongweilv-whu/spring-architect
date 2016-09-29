package com.whu.hong.greeting.advices;

import com.whu.hong.greeting.Apology;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Component;

/**
 * Description:
 * Created by lvhw on 2016/9/21 23:08.
 */
@Component
public class GreetingIntroAdvice extends DelegatingIntroductionInterceptor implements Apology {

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        return super.invoke(mi);
    }

    public void saySorry(String name) {
        System.out.println("Sorry! " + name);
    }
}
