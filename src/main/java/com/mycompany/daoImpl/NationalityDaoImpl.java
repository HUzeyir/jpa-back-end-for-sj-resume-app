///*
// * Here comes the text of your license
// * Each line should be prefixed with  * 
// */
//package com.mycompany.daoImpl;
//
//import com.mycompany.entity.Nationality;
//import com.mycompany.daoInter.NationalityDaoInter;
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
//public class NationalityDaoImpl extends AbstractDao implements NationalityDaoInter {
//
//    @Override
//    public List<Nationality> getAllNationality() {
//
//         String query="select * from nationality";
//        Nationality nat=null;
//        List<Nationality> nats=new ArrayList<>();
//        try(Connection con=getConnection(); PreparedStatement ps=con.prepareStatement(query)){
//            ResultSet rs=ps.executeQuery();
//            
//            while(rs.next()){
//                
//                int natId=rs.getInt("nat_id");
//                String birthPlace=rs.getString("birth_place");
//                String country=rs.getString("country");
//                nat=new Nationality(natId, birthPlace, country);
//                nats.add(nat);
//            }
//            
//            System.out.println("nationalities obtained");
//            return nats;
//            
//        }catch(SQLException ex){
//            ex.printStackTrace();
//        }
//        
//        return null;
//    }
//
//    @Override
//    public boolean addNationality(Nationality n) {
//        String query = "insert into nationality (birth_place, country) values(?,?)";
//        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
//            ps.setString(1, n.getBirthPlace());
//            ps.setString(2, n.getCountry());
//            ps.executeUpdate();
//            System.out.println("Natinality added");
//            return true;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteNationality(String NatName) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean updateNationality(Nationality n) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Nationality getNationalityById(int id) {
//        
//        String query="select * from nationality where nat_id=?";
//        Nationality nat=null;
//        try(Connection con=getConnection(); PreparedStatement ps=con.prepareStatement(query)){
//            ps.setInt(1, id);
//            ResultSet rs=ps.executeQuery();
//            
//            if(rs.next()){
//                
//                int natId=rs.getInt("nat_id");
//                String birthPlace=rs.getString("birth_place");
//                String country=rs.getString("country");
//                nat=new Nationality(natId, birthPlace, country);
//            }
//            
//            System.out.println(id+" nationality obtained");
//            return nat;
//            
//        }catch(SQLException ex){
//            ex.printStackTrace();
//        }
//        
//        return null;
//    }
//
//}
