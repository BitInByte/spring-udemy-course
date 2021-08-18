package com.bitinbyte.springdemo.service;

import java.util.List;

import com.bitinbyte.springdemo.entity.Customer;

/**
 * CustomerService
 */
public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
}
