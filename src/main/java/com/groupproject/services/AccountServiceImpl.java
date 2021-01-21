package com.groupproject.services;

import static com.groupproject.constants.Constants.DEFAULT_INITIAL_COINS;
import static java.util.Objects.isNull;
import com.groupproject.entities.Account;
import com.groupproject.entities.Role;
import com.groupproject.repository.AccountRepository;
import com.groupproject.requests.AccountRequest;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements IAccountService, UserDetailsService {


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

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
        log.info("Ready to insert a new Account . The request is {}", request);
        Role role = new Role(2L, "USER");
        Account account = new Account(request.getUsername(), request.getPassword(), request.getFirstName(), request.getLastName(),
                request.getDateOfBirth(), request.getEmail(), request.getGender(), DEFAULT_INITIAL_COINS, role);
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        Account newAccount = accountRepository.save(account);
        log.info("The new account is {}", newAccount);
        log.info("The account has been inserted to the DB");
        return true;
    }

    @Override
    public Account updateAccount(Long id, AccountRequest request) {
        log.info("Ready to update an existing account");
        Account existingAccount = accountRepository.findById(id).orElse(null);
        if (isNull(existingAccount)) {
            log.info("The account does not exists");
            return null;
        }
        existingAccount.setFirstName(request.getFirstName());
        existingAccount.setLastName(request.getLastName());
        existingAccount.setUsername(request.getUsername());
        existingAccount.setPassword(request.getPassword());
        existingAccount.setDateOfBirth(request.getDateOfBirth());
        existingAccount.setEmail(request.getEmail());
        existingAccount.setGender(request.getGender());
        existingAccount.setCoins(request.getCoins());
        existingAccount.setRole(request.getRole());
        Account updatedAccount = accountRepository.save(existingAccount);
        log.info("The updated account is {}", updatedAccount);
        log.info("The updated account has been inserted to the DB");
        return updatedAccount;
    }

    @Override
    public boolean deleteById(Long id) {
        log.info("Ready to delete an account");
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            log.info("account deleted successfully");
            return true;
        }
        log.info("account has not deleted successfully");
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account applicationUser = accountRepository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        Role role = applicationUser.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getType()));
        System.out.println(role.getType());
        log.info("loadUserByUsername: found match, returning "
                + applicationUser.getUsername() +" With role " +authorities.toString()
        );
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), authorities);

    }

}
