package com.hanniel.aopdemo;

import com.hanniel.aopdemo.dao.AccountDAO;
import com.hanniel.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
        return runner -> {
//			demoTheBeforeAdvice(theAccountDAO, membershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO);
//          demoTheAfterThrowingAdvice(theAccountDAO);

            demoTheAfterAdvice(theAccountDAO);
        };
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;

        try {
            boolean tripWire = false;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain program: ... caught exception: " + e);
        }

        System.out.println("\n\nMain program: demoTheAfterReturningAdvice");
        System.out.println("-----");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;

        try {
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("\n\nMain program: ... caught exception: " + e);
        }

        System.out.println("\n\nMain program: demoTheAfterReturningAdvice");
        System.out.println("-----");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = theAccountDAO.findAccounts();

        System.out.println("\n\nMain program: demoTheAfterReturningAdvice");
        System.out.println("-----");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        Account myAccount = new Account();
        myAccount.setName("Madhu");
        myAccount.setLevel("Platinum");

        theAccountDAO.addAccount(myAccount, true);
        theAccountDAO.doWork();

        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        theMembershipDAO.addSillyMember();
        theMembershipDAO.goToSleep();

    }

}
