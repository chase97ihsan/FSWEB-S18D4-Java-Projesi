package com.workintech.jpamany.service;

import com.workintech.jpamany.dao.AddressRepository;
import com.workintech.jpamany.entity.Account;
import com.workintech.jpamany.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll();

    Address getById(int id);

    Address save(Address address);

    Address delete(Address address);
}
