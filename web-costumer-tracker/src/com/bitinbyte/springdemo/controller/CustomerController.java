package com.bitinbyte.springdemo.controller;

import com.bitinbyte.springdemo.dao.CustomerDAO;
import com.bitinbyte.springdemo.entity.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * CustomerController
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    // Need to inject the customer DAO
    // Spring will scan for a component that
    // implements CustomerDAO interface
    @Autowired
    private CustomerDAO customerDAO;

    @RequestMapping("/list")
    public String listCustomers(Model theModel) {
        // Get customers from the DAO
        List<Customer> theCustomers = customerDAO.getCustomers();
        // Add the customer to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

}
