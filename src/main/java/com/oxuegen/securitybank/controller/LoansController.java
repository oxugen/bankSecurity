package com.oxuegen.securitybank.controller;

import java.util.List;

import com.oxuegen.securitybank.model.Customer;
import com.oxuegen.securitybank.model.Loans;
import com.oxuegen.securitybank.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
	
	@Autowired
	private LoanRepository loanRepository;

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/myLoans")
	public List<Loans> getLoanDetails(@RequestBody Customer customer) {
		List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
		if (loans != null ) {
			return loans;
		}else {
			return null;
		}
	}

}
