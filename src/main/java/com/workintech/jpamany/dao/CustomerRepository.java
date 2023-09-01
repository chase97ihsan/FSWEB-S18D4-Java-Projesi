package com.workintech.jpamany.dao;

import com.workintech.jpamany.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
