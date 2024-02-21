package com.oxuegen.securitybank.repository;

import com.oxuegen.securitybank.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loans, Long> {
    //@PreAuthorize("hasRole('ROOT')")
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
