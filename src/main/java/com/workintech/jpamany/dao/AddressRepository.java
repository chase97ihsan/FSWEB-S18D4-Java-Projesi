package com.workintech.jpamany.dao;

import com.workintech.jpamany.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
