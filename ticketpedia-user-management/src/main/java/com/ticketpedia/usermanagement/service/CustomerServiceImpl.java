package com.ticketpedia.usermanagement.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ticketpedia.usermanagement.model.Customer;
import com.ticketpedia.usermanagement.repository.CustomerRepository;
import com.ticketpedia.usermanagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Customer signup(Customer customer) {
        // Encode the password before saving it
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    @Override
    public Customer login(String username, String password) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null && passwordEncoder.matches(password, customer.getPassword())) {
            return customer;
        }
        return null;
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }
}
