/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.daoInter;

import com.mycompany.entity.Address;
import java.util.List;

/**
 *
 * @author user
 */
public interface AddressDaoInter {

    public List<Address> getAlladdress();

    public Address addAddress(Address address);

    public boolean deleteAddressById(Integer id);
    
    public Address deleteAddress(Address address);

    public Address updateAddress(Address address);
    
    Address getAddressById(Integer id);


}
