package com.oxuegen.securitybank.repository;


import com.oxuegen.securitybank.model.AccountTransactions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountTransactionsRepository extends CrudRepository<AccountTransactions, Long> {

    List<AccountTransactions> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
