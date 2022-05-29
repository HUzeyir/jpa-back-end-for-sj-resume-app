package com.mycompany.daoImpl;

import com.mycompany.daoInter.AddressDaoInter;
import com.mycompany.entity.Address;
import com.mycompany.jpaFactory.JpaFactory;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

public class AddressDaoIml extends JpaFactory implements AddressDaoInter {

    @Override
    public List<Address> getAlladdress() {

        try {
            TypedQuery<Address> namedQuery = getManager().createNamedQuery("Address.findAll", Address.class);
            List<Address> adress = namedQuery.getResultList();
            return adress;
        } catch (RuntimeException e) {
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Address addAddress(Address address) {

        try {
            if (address != null) {
                getManager().getTransaction().begin();
                getManager().persist(address);
                getManager().getTransaction().commit();
                return address;
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                System.out.println(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public Address updateAddress(Address address) {

        try {
            if (address != null) {
                getManager().getTransaction().begin();
                getManager().merge(address);
                getManager().flush();
                getManager().getTransaction().commit();
                return address;
            }
        } catch (RuntimeException e) {
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                System.out.println(e2.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean deleteAddressById(Integer id) {
        try {
            if (id != null) {
                Query query = getManager().createNamedQuery("Address.deleteAddressById");
                query.setParameter("id", id);
                return true;
            }
        } catch (RuntimeException e) {
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public Address deleteAddress(final Address address) {

        try {
            if (address != null && getManager().contains(address)) {
                getManager().remove(address);
                return address;
            } else if (address != null) {
                Address address2 = getAddressById(address.getAddressId());
                getManager().remove(address2);
                return address2;
            }
        } catch (RuntimeException e) {
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Address getAddressById(Integer id) {

        try {
            Address address = getManager().find(Address.class, id);
            return address;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            try {
                getManager().getTransaction().rollback();
            } catch (RollbackException e2) {
                System.out.println(e2.getMessage());
            }
        }
        return null;
    }

}
