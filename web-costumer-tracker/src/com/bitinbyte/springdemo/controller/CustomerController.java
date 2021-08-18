package com.bitinbyte.springdemo.controller;

import com.bitinbyte.springdemo.dao.CustomerDAO;
import com.bitinbyte.springdemo.entity.Customer;
import com.bitinbyte.springdemo.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    // private CustomerDAO customerDAO;
    // Now we're using the service
    private CustomerService customerService;

    // @RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        // Get customers from the DAO
        // List<Customer> theCustomers = customerDAO.getCustomers();
        // Get customers from the Service
        List<Customer> theCustomers = customerService.getCustomers();
        // Add the customer to the model
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

}
