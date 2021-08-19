package com.bitinbyte.springdemo.controller;

import com.bitinbyte.springdemo.dao.CustomerDAO;
import com.bitinbyte.springdemo.entity.Customer;
import com.bitinbyte.springdemo.service.CustomerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // Create model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        // Save the customer using our service
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
        // Get the customer from the service
        Customer theCustomer = customerService.getCustomer(theId);
        // Set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);
        // Send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        // Delete the customer
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }

}
