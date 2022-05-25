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

    public List<Address> address();

    public boolean addAddress(Address address);

    public boolean deleteAddressById(int id);

    public boolean updateAddress(Address address);

    public Address getAddressById(int id);

}
