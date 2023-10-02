package com.hanniel.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDAO{
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");

        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + ": I'm going to sleep now...");

    }
}
