package com.oxuegen.securitybank.controller;

import com.oxuegen.securitybank.model.Customer;
import com.oxuegen.securitybank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        try {
            var savedCustomer = customerRepository.save(customer);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Given user successfully registered");
        }
        catch (Exception ex){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to" + ex.toString());
        }
    }

}
