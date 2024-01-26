package com.oxuegen.securitybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping(path = "/myCards")
    public String getCardDetailts(){
        return "my card";
    }
}
