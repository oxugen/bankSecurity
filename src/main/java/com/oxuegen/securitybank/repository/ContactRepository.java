package com.oxuegen.securitybank.repository;

import com.oxuegen.securitybank.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
}
