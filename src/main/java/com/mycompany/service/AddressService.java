
package com.mycompany.service;

import com.mycompany.entity.Address;
import java.util.List;

public interface AddressService {

    public List<Address> getAlladdress();

    public Address addAddress(Address address);

    public boolean deleteAddressById(Integer id);
    
    public Address deleteAddress(Address address);

    public Address updateAddress(Address address);
    
    Address getAddressById(Integer id);


}
