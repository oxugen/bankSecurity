package com.oxuegen.securitybank.repository;

import com.oxuegen.securitybank.model.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {

    Accounts findByCustomerId(int customerId);

}
