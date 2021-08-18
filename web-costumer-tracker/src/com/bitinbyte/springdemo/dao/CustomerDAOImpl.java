package com.bitinbyte.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitinbyte.springdemo.entity.Customer;

/**
 * CustomerDAOImpl
 */
// Spring will be able to component scan and
// handle the exception translation for us,
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // Need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    // @Transactional
    // Transactional is now performed in the service layer
    public List<Customer> getCustomers() {
        // Get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        // Create a query ... sort by last name
        Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
        // Execute query and get result list
        // This get us a list of objects from a database,
        // map it over to the appropriate type and then
        // return it as a list.
        List<Customer> customers = theQuery.getResultList();
        // Return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        // Get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        System.out.println(theCustomer);
        // Save the customer ... finally LOL
        currentSession.save(theCustomer);

    }

}
