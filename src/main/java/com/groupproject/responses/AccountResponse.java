package com.groupproject.responses;

import com.groupproject.entities.Account;
import lombok.Data;

import java.util.List;

@Data
public class AccountResponse extends Response{

    private List<Account> accounts;
    private Account account;

    public AccountResponse(String msg, List<Account> accounts){
        super(msg);
        this.accounts=accounts;
    }

    public AccountResponse(String msg, Account account){
        super(msg);
        this.account=account;
    }

}
