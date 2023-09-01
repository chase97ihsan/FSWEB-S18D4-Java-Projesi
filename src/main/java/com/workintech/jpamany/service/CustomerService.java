package com.workintech.jpamany.service;

import com.workintech.jpamany.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Customer getById(int id);

    Customer save(Customer customer);

    Customer delete(int id);


}
