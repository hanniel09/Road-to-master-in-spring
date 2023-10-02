package com.hanniel.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//    @Before("execution(public void add*())")

    @Pointcut("execution(* com.hanniel.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n========>>> Executing @Before advice on method");
    }
}
