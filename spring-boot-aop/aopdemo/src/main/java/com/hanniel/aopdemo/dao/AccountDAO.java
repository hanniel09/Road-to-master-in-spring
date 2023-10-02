package com.hanniel.aopdemo.dao;

import com.hanniel.aopdemo.Account;

public interface AccountDAO {
    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
