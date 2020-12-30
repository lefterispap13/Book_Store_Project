package com.groupproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @RequestMapping("/")
    public ModelAndView viewHome(){
        return new ModelAndView("index");
    }

    @RequestMapping("/login")
    public ModelAndView viewLogin(){
        return new ModelAndView("login");
    }

    @RequestMapping("/register")
    public ModelAndView viewRegister(){
        return new ModelAndView("register");
    }
}
