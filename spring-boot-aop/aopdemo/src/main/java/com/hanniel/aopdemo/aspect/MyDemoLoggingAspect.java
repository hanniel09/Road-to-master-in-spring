package com.hanniel.aopdemo.aspect;

import com.hanniel.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
//    @Before("execution(public void add*())")

    @Before("com.hanniel.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n========>>> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: " + methodSignature);

        Object[] args = theJoinPoint.getArgs();

        for (Object tempArgs : args){
            System.out.println(tempArgs);

            if(tempArgs instanceof Account) {
                Account theAccount = (Account) tempArgs;
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account name: " + theAccount.getLevel());
            }
        }
    }


}
