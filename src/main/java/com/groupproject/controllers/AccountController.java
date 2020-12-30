package com.groupproject.controllers;


import com.groupproject.services.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value="/account")
@RestController
public class AccountController {

    @Autowired
    private AccountServiceImpl accountServiceImpl;
}
