package com.groupproject.services;


import com.groupproject.entities.Account;
import com.groupproject.repository.AccountRepository;
import com.groupproject.requests.AccountRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<Account> getAll() {
        log.info("Ready to get all the Accounts");
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        log.info("Ready to get an account from the given id");
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public boolean createAccount(AccountRequest request) {
        log.info("Ready to insert a new Account . The request is {}",request);
        Account account=new Account(request.getUsername(), request.getPassword(), request.getFirstName(), request.getLastName(),
                request.getDateOfBirth(), request.getEmail(), request.getGender());
        Account newAccount= accountRepository.save(account);
        log.info("The new account is {}",newAccount);
        log.info("The account has been inserted to the DB");
        return true;
    }

    @Override
    public boolean updateAccount(AccountRequest request) {
        return false;
    }

    @Override
    public void deleteById(Long id) {

    }
}
