package com.oxuegen.securitybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @GetMapping(path = "/myBalance")
    public String getBalanceDetails(){
        return "My balance";
    }
}

