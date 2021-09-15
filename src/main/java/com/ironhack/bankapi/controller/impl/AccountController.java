package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.controller.interfaces.IAccountController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements IAccountController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String home(){
        return "Hello Stranger!";
    }
}
