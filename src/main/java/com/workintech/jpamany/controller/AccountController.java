package com.workintech.jpamany.controller;

import com.workintech.jpamany.entity.Account;
import com.workintech.jpamany.entity.Customer;
import com.workintech.jpamany.service.AccountService;
import com.workintech.jpamany.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;
    private CustomerService customerService;

    @Autowired

    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }


    @GetMapping("/")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id) {
        return customerService.getById(id);
    }

    @PutMapping("/{customerId}")
    public Account post(@RequestBody Account account, @PathVariable int customerId) {
        Customer customer1 = customerService.getById(customerId);
        Account account1 = customer1.getAccounts().stream().
                filter(c -> c.getId() == account.getId()).collect(Collectors.toList()).get(0);
        int index = customer1.getAccounts().indexOf(account1);
        customer1.getAccounts().set(index, account);
        account.setCustomer(customer1);
        return accountService.save(account);
    }

    @PostMapping("/{customerId}")
    public Account post(@PathVariable int customerId, @RequestBody Account account) {
        Customer customer1 = customerService.getById(customerId);
        customer1.addAccount(account);
        account.setCustomer(customer1);
        return accountService.save(account);

    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable int id) {
        Account account1 = accountService.getById(id);
        return accountService.delete(account1);

    }
}
