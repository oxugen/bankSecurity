package com.oxuegen.securitybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping(path = "/myLoans")
    public String getLoanDetails(){
        return "my loans";
    }
}
