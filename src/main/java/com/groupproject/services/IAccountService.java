package com.groupproject.services;


import com.groupproject.entities.Account;
import com.groupproject.requests.AccountRequest;

import java.util.List;

public interface IAccountService {

    //list for all accounts
    List<Account> getAll();

    //account with id
    Account getAccountById(Long id);

    //new account
    boolean createAccount(AccountRequest request);

    //update account with id
    boolean updateAccount(AccountRequest request);

    //delete account with id
    void deleteById(Long id);

}
