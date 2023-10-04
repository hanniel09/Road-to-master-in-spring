package com.hanniel.aopdemo.aspect;

import com.hanniel.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.hanniel.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @After (finally) on Method: " + method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.hanniel.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFIndAccountsAdvice(
            JoinPoint theJoinPoint, Throwable theExc
    ){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n========>>> Executing @AfterThrowing on Method: " + method);

        System.out.println("\n========>>> The Exception is: " + theExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.hanniel.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result){
            String method = theJoinPoint.getSignature().toShortString();
            System.out.println("\n========>>> Executing @AfterRunning on Method: " + method);

            System.out.println("\n========>>> Executing @AfterRunning on Method: " + result);

            convertAccountNamesToUpperCase(result);

            System.out.println("\n========>>> Executing @AfterRunning on Method: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account tempAccount : result){
            String theUpperCase = tempAccount.getName().toUpperCase();

            tempAccount.setName(theUpperCase);
        }
    }

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
