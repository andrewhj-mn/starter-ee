package com.example.service;

import com.example.model.Customer;

import java.util.List;

/**
 * Exportable Service definition for Customers
 */

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer createCustomer(Customer customer);
}
