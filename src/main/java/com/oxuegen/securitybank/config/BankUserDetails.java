package com.oxuegen.securitybank.config;

import com.oxuegen.securitybank.model.Customer;
import com.oxuegen.securitybank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankUserDetails implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String name, password = null;
        List<GrantedAuthority> authorities = null;
        List<Customer> customers = customerRepository.findByEmail(email);
        if(customers.size() == 0){
            throw new UsernameNotFoundException("User details not found for the user" + email);
        }
        name = customers.get(0).getEmail();
        password = customers.get(0).getPwd();
        authorities = new ArrayList();
        authorities.add(new SimpleGrantedAuthority(customers.get(0).getRole()));
        return new User(name, password, authorities);

    }
}
