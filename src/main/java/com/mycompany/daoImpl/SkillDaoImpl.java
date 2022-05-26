///*
// * Here comes the text of your license
// * Each line should be prefixed with  * 
// */
//package com.mycompany.daoImpl;
//
//import com.mycompany.entity.Skill;
//import com.mycompany.daoInter.SkillDaoInter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author user private Integer skillsId; private String skillsName; private int
// * power; private List<User> users;
// */
//public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {
//
//    @Override
//    public void addSkills(Skill skill) {
//
//        String query = "insert into jdbctest.skill(skill_name, power) values (?,?)";
//        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
//
//            ps.setString(1, skill.getSkillsName());
//
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void addSkillsBatch(List<Skill> skill) {
//
//        String query = "insert into jdbctest.skill(skills_name) values (?)";
//        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
//
//            for (Skill s : skill) {
//                ps.setString(1, s.getSkillsName());
//                ps.addBatch();
//            }
//            System.out.println("Added");
//            ps.executeBatch();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public void updateSkills(Skill skill) {
//        String query = "update skill s set skills_name=? where skill_id=?";
//        try (Connection con = getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
//
//            pstm.setString(1, skill.getSkillsName());
//            pstm.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    @Override
//    public Skill getSkillByName(String name) {
//
//        return null;
//    }
//
//    @Override
//    public Skill getSkillById(int id) {
//        String query = "select * from skill where skill_id=?";
//        Skill skill = null;
//        try (Connection con = getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {
//
//            pstm.setInt(1, id);
//            ResultSet rs = pstm.executeQuery();
//            if (rs.next()) {
//                int idd = rs.getInt("skill_id");
//                String skillName = rs.getString("skills_name");
//                skill = new Skill(idd, skillName);
//            }
//
//            return skill;
//        } catch (SQLException ex) {
//
//            ex.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<String> getAllSkills() {
//
//        return null;
//    }
//
//    @Override
//    public boolean deleteSkillsByName(String name) {
//        return false;
//    }
//
//    @Override
//    public List<Skill> getSkillsByUserId(int id) {
//
//        return null;
//    }
//
//}
