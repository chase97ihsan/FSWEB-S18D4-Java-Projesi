package com.workintech.jpamany.service;

import com.workintech.jpamany.dao.AccountRepository;
import com.workintech.jpamany.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(int id) {
        Optional<Account> account1= accountRepository.findById(id);
        if(account1.isPresent()){
            return account1.get();
        }
        return null;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(Account account) {
        accountRepository.delete(account);
        return account;
    }
}
