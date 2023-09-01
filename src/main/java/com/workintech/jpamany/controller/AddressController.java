package com.workintech.jpamany.controller;

import com.workintech.jpamany.entity.Address;
import com.workintech.jpamany.entity.Customer;
import com.workintech.jpamany.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PostMapping("/")
    public Address post(@RequestBody Address address) {
        return addressService.save(address);

    }

    @PutMapping("/{id}")
    public Address put(@PathVariable int id, @RequestBody Address address) {
        Address address1 = addressService.getById(id);
        if (address1 != null) {
            address.setId(id);
        }
        return addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable int id) {
        Address address = addressService.getById(id);
        return addressService.delete(address);
    }
}
