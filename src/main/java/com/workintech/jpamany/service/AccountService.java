package com.workintech.jpamany.service;

import com.workintech.jpamany.entity.Account;
import com.workintech.jpamany.entity.Customer;

import java.util.List;

public interface AccountService {
    List<Account> getAll();

    Account getById(int id);

    Account save(Account account);

    Account delete(Account account);
}
