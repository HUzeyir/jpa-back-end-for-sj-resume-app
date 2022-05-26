///*
// * Here comes the text of your license
// * Each line should be prefixed with  * 
// */
//package com.mycompany.daoImpl;
//
//import com.mycompany.entity.Address;
//import com.mycompany.daoInter.AddressDaoInter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author user
// */
//public class AddressDaoIml extends AbstractDao implements AddressDaoInter {
//
//    @Override
//    public List<Address> address() {
//        List<Address> addresses = new ArrayList<>();
//        String qurey = "select * from address";
//        ResultSet rs = null;
//        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(qurey)) {
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                short addressId = rs.getShort("address_id");
//                String city = rs.getString("city");
//                String town = rs.getString("town");
//                String street = rs.getString("street");
//                Address ad = new Address(addressId, city, town, street);
//                addresses.add(ad);
//            }
//
//            return addresses;
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public boolean addAddress(Address address) {
//        String query = "insert into address (city, town, street) values(?,?,?)";
//        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setString(1, address.getCity());
//            ps.setString(2, address.getTown());
//            ps.setString(3, address.getStreet());
//            ps.executeUpdate();
//            System.out.println("address added");
//            return true;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteAddressById(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean updateAddress(Address address) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Address getAddressById(int id) {
//        Address address = null;
//        String qurey = "select * from address where address_id=?";
//        ResultSet rs = null;
//        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(qurey)) {
//            ps.setInt(1, id);
//            rs = ps.executeQuery();
//            if (rs.next()) {
//                short addressId = rs.getShort("address_id");
//                String city = rs.getString("city");
//                String town = rs.getString("town");
//                String street = rs.getString("street");
//                address = new Address(addressId, city, town, street);
//            }
//            System.out.println("Obtained address");
//            return address;
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//}
