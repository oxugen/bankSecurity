package com.oxuegen.securitybank.controller;


import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.oxuegen.securitybank.model.Customer;
import com.oxuegen.securitybank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
		Customer savedCustomer = null;
		ResponseEntity response = null;
		try {
			String hashPwd = passwordEncoder.encode(customer.getPwd());
			customer.setPwd(hashPwd);
			customer.setCreateDt(LocalDate.now());
			savedCustomer = customerRepository.save(customer);
			if(savedCustomer.getId() > 0){
				response = ResponseEntity
						.status(HttpStatus.CREATED)
						.body("Given user details are successfully registered");
			}
		}
		catch (Exception ex){
			response = ResponseEntity
					.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured " + ex.getMessage());
		}
		return response;
	}

	@RequestMapping("/user")
	public Customer getUserDetailsAfterLogin(Principal user) {
		List<Customer> customers = customerRepository.findByEmail(user.getName());
		if (customers.size() > 0) {
			return customers.get(0);
		}else {
			return null;
		}
		
	}

}
