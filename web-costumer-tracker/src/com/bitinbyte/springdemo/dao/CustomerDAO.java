package com.bitinbyte.springdemo.dao;

import java.util.List;

import com.bitinbyte.springdemo.entity.Customer;

/**
 * CustomerDAO
 */
public interface CustomerDAO {

    public List<Customer> getCustomers();
}
