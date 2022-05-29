package com.mycompany.serviceImpl;

import com.mycompany.daoImpl.AddressDaoIml;
import com.mycompany.daoInter.AddressDaoInter;
import com.mycompany.entity.Address;
import com.mycompany.service.AddressService;
import java.util.List;

public class AddressServiceImpl implements AddressService {

    private AddressDaoInter adi = new AddressDaoIml();

    @Override
    public List<Address> getAlladdress() {
        return adi.getAlladdress();
    }

    @Override
    public Address addAddress(Address address) {
        return adi.addAddress(address);
    }

    @Override
    public boolean deleteAddressById(Integer id) {
        return adi.deleteAddressById(id);
    }

    @Override
    public Address deleteAddress(Address address) {
        return adi.deleteAddress(address);
    }

    @Override
    public Address updateAddress(Address address) {
        return adi.updateAddress(address);
    }

    @Override
    public Address getAddressById(Integer id) {
        return adi.getAddressById(id);
    }

}
