package com.workintech.jpamany.service;

import com.workintech.jpamany.dao.AddressRepository;
import com.workintech.jpamany.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(int id) {
        Optional<Address> address = addressRepository.findById(id);
        if (address.isPresent()) {
            return address.get();
        }
        return null;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address delete(Address address) {

        addressRepository.delete(address);
        return address;
    }
}
