/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package com.mycompany.daoImpl;

import com.mycompany.entity.PrivateInformation;
import com.mycompany.daoInter.PrivateInformationDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class PrivateInformationDaoImpl extends AbstractDao implements PrivateInformationDaoInter {

    @Override
    public List<PrivateInformation> getAllPrivateInformations() {
//
//        String query = "select * from phone";
//        String query2 = "select * from link";
//        try (Connection con = getConnection();) {
//            PreparedStatement ps1 = con.prepareStatement(query);
//            ResultSet rs1 = ps1.executeQuery();
//            List<String> phones = new ArrayList<>();
//
//            PreparedStatement ps2 = con.prepareStatement(query2);
//            ResultSet rs2 = ps2.executeQuery();
//            List<String> links = new ArrayList<>();
//
//            PrivateInformation piInfo = new PrivateInformation();
//            while (rs1.next() || rs2.next()) {
//                int id=rs.getInt("phone_id");
//                String phone = rs1.getString("phones");
//                String link = rs1.getString("links");
//                if (phone != null) {
//                    phones.add(phone);
//                }
//                if (link != null) {
//                    links.add(link);
//                }
//            }
//
//            piInfo.setLinks(links);
//            piInfo.setPhones(phones);
//            
//            return piInfo;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
        return null;
    }

    @Override
    public boolean addPrivateInfo(PrivateInformation information) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletePrivateInfo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updatePrivateInfo(PrivateInformation information) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrivateInformation getPrivInfByUserId(int id) {
        
        String query = "select p.phones, l.links from user u left join private_information pi on u.pi_info_id=pi.pi_id "
                + "left join phone p on pi.pi_id=p.pi_id left join link l on pi.pi_id=l.pi_id where u.user_id=?";
        try (Connection con = getConnection();) {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<String> phones = new ArrayList<>();

            List<String> links = new ArrayList<>();

            PrivateInformation piInfo = new PrivateInformation();
            while (rs.next()) {
//                int id = rs.getInt("phone_id");
                String phone = rs.getString("phones");
                String link = rs.getString("links");
                if (phone != null) {
                    phones.add(phone);
                }
                if (link != null) {
                    links.add(link);
                }
            }

            piInfo.setLinks(links);
            piInfo.setPhones(phones);
            System.out.println(id+" users links and phones obtained");
            return piInfo;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
        
    }

}
