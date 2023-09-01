package com.workintech.jpamany.controller;

import com.workintech.jpamany.entity.Customer;
import com.workintech.jpamany.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @PostMapping("/")
    public Customer post(@RequestBody Customer customer) {
        return customerService.save(customer);

    }

    @PutMapping("/{id}")
    public Customer put(@PathVariable int id, @RequestBody Customer customer) {
        Customer customer1 = customerService.getById(id);
        if (customer1 != null) {
            customer.setId(id);
        }
        return customerService.save(customer);
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable int id) {
        return customerService.delete(id);
    }


}
