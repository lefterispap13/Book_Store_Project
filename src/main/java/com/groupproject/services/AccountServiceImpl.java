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
                request.getDateOfBirth(), request.getEmail(), request.getGender(),request.getCoins(),request.getRole());
        Account newAccount= accountRepository.save(account);
        log.info("The new account is {}",newAccount);
        log.info("The account has been inserted to the DB");
        return true;
    }

    @Override
    public AccountRequest updateAccount(Long id,AccountRequest request) {
        log.info("Ready to update an existing account");
        if (accountRepository.findById(id).isPresent()){
            Account existingAccount=accountRepository.findById(id).get();
            existingAccount.setFirstName(request.getFirstName());
            existingAccount.setLastName(request.getLastName());
            existingAccount.setUsername(request.getUsername());
            existingAccount.setPassword(request.getPassword());
            existingAccount.setDateOfBirth(request.getDateOfBirth());
            existingAccount.setEmail(request.getEmail());
            existingAccount.setGender(request.getGender());
            existingAccount.setCoins(request.getCoins());
            Account updatedAccount= accountRepository.save(existingAccount);
            log.info("The updated account is {}",updatedAccount);
            log.info("The updated account has been inserted to the DB");
            return new AccountRequest(updatedAccount.getUsername(), updatedAccount.getPassword(),
                    updatedAccount.getFirstName(), updatedAccount.getLastName(),
                    updatedAccount.getDateOfBirth(), updatedAccount.getEmail(), updatedAccount.getGender(),updatedAccount.getCoins(),updatedAccount.getRole());
        }
        log.info("The account has not been inserted to the DB");
        return null;
    }


    @Override
    public boolean deleteById(Long id) {
        log.info("Ready to delete an account");
        if (accountRepository.existsById(id)){
            accountRepository.deleteById(id);
            log.info("account deleted successfully");
            return true;
        }
        log.info("account has not deleted successfully");
        return false;
    }
}
