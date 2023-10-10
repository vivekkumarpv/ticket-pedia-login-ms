package com.ticketpedia.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ticketpedia.usermanagement.model.Customer;
import com.ticketpedia.usermanagement.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public Customer signup(@RequestBody Customer customer) {
        return customerService.signup(customer);
    }

    @PostMapping("/login")
    public Customer login(@RequestBody Customer customer) {
        return customerService.login(customer.getUsername(), customer.getPassword());
    }
}
