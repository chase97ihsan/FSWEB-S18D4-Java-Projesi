package com.workintech.jpamany.dao;

import com.workintech.jpamany.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
