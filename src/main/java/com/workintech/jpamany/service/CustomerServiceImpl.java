package com.workintech.jpamany.service;

import com.workintech.jpamany.dao.CustomerRepository;
import com.workintech.jpamany.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        Optional<Customer> customer1 = customerRepository.findById(id);
        if (customer1.isPresent()) {
            return customer1.get();
        }
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer delete(int id) {
        Customer customer = getById(id);
        customerRepository.delete(customer);
        return customer;
    }
}
