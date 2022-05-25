/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.daoImpl;

//import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.entity.Address;
import com.mycompany.entity.Nationality;
import com.mycompany.entity.PrivateInformation;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.bean.UserSkill;
import com.mycompany.daoInter.UserDaoInter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    private BCrypt.Hasher hasher = BCrypt.withDefaults();

    @Override
    public void addUser(User u) {

        String query = "insert into user (user_name, sur_name, email, user_password, about, age, add_date, update_date, is_online)"
                + " values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(query);
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSur_name());
            stmt.setString(3, u.getEmail());
            String pass=hasher.hashToString(4, u.getPassword().toCharArray());
            stmt.setString(4, pass);
            stmt.setString(5, u.getAbout());
            stmt.setDate(6, u.getAge());
            stmt.setTimestamp(7, u.getAddDate());
            stmt.setTimestamp(8, u.getUpdateDate());
            stmt.setBoolean(9, u.isIsOnline());
            stmt.execute();
            System.out.println("named " + u.getName() + " user added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                getConnection().close();
            } catch (SQLException ex) {
                System.out.println("Connection cant finished " + ex);
            }
        }
    }

    @Override
    public boolean updateUser(User u) {
        String query = "update user u set u.user_name=?, u.sur_name=?, u.email=?, u.user_password=?,u.age=?, u.about=?,"
                + " u.update_date=?,u.is_online=? where u.user_id=?";
        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(query);) {

            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSur_name());
            stmt.setString(3, u.getEmail());
            stmt.setString(4, hasher.hashToString(4, u.getPassword().toCharArray()));
            stmt.setDate(5, u.getAge());
            stmt.setString(6, u.getAbout());
            Instant ins = Instant.now();
            stmt.setTimestamp(7, Timestamp.from(ins));
            stmt.setBoolean(8, true);
            stmt.setInt(9, u.getUserId());

//            SkillDaoInter sdi=Context.instanceSkillDao();
//            sdi.updateSkills(skill);
            stmt.executeUpdate();
            System.out.println("Updated saccesfully");
            return true;

        } catch (SQLException ex) {
            System.out.println("Cant updated: " + ex);
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(int id) {

        String query = "delete from user where user_id=?";
        try (Connection con = getConnection(); PreparedStatement pstm = con.prepareCall(query)) {

            pstm.setInt(1, id);
            pstm.executeUpdate();
            System.out.println(id + " user deleted");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserbyId(int id) {

        String sql = "select u.user_id, u.user_name, u.sur_name, u.email, u.user_password, u.about, u.age, u.add_date, u.update_date, u.is_online, "
                + "us.power, s.skills_name, a.city, a.town, a.street, n.birth_place, n.country, p.phones, l.links  from user u "
                + "left join user_skill us on u.user_id=us.user_id left join skill s on us.skill_id=s.skill_id "
                + "left join user_address ua on u.user_id=ua.user_id left join address a on ua.address_id=a.address_id "
                + "left join nationality n on u.user_id=n.user_id left join private_information pin on u.pi_info_id=pin.pi_id "
                + "left join phone p on p.pi_id=pin.pi_id left join link l on l.pi_id=pin.pi_id where u.user_id=?";
        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            User user = null;
            List<Skill> skills = new ArrayList<>();
            PrivateInformation pi = null;
            List<String> links = new ArrayList<>();
            List<String> phones = new ArrayList<>();
            Nationality nat = null;
            List<Address> addresses = new ArrayList<>();

            boolean hal = true;
            while (rs.next()) {

                if (hal) {
                    int user_id = rs.getInt("user_id");
                    String name = rs.getString("user_name");
                    String sur_name = rs.getString("sur_name");
                    String email = rs.getString("email");
                    String password = rs.getString("user_password");
                    String about = rs.getString("about");
                    Date age = rs.getDate("age");
                    Timestamp add_date = rs.getTimestamp("add_date");
                    Timestamp update_date = rs.getTimestamp("update_date");
                    boolean isOnline = rs.getBoolean("is_online");
                    hal = false;
                    user = new User(user_id, name, sur_name, email, password, about, age, add_date, update_date, isOnline);
                }

                int power1 = rs.getInt("power");
                UserSkill power = new UserSkill(power1);

                String skillName = rs.getString("skills_name");
                Skill s = new Skill(skillName);

                s.setUserSkill(power);
                skills.add(s);

                //nationality
                String birthPlace = rs.getString("birth_place");
                String country = rs.getString("country");
                nat = new Nationality(birthPlace, country);

                //privateInformation
                String link = rs.getString("links");
                links.add(link);
                String phone = rs.getString("phones");
                phones.add(phone);

                //address
                String city = rs.getString("city");
                String town = rs.getString("town");
                String street = rs.getString("street");

                Address adress = new Address(city, town, street);
                addresses.add(adress);
            }

            pi = new PrivateInformation(phones, links);

            user.setPrivateInformation(pi);
            user.setNationality(nat);
            user.setSkills(skills);
            user.setAdresses(addresses);
            System.out.println(user.getName() + " obtained from db");

            return user;
        } catch (SQLException ex) {
            System.out.println("Not Found: " + ex);
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public User serchUserByEmail(String email) {
        try (Connection con = getConnection()) {

            String query = "select * from user u where u.email=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, email);

            ResultSet rs = pstm.executeQuery();
            User user = null;

            if (rs.next()) {

                int user_id = rs.getInt("user_id");
                String name = rs.getString("user_name");
                String sur_name = rs.getString("sur_name");
                String email2 = rs.getString("email");
                String password2 = rs.getString("user_password");
                String about = rs.getString("about");
                Date age = rs.getDate("age");
                Timestamp add_date = rs.getTimestamp("add_date");
                Timestamp update_date = rs.getTimestamp("update_date");
                boolean isOnline = rs.getBoolean("is_online");
                user = new User(user_id, name, sur_name, email2, password2, about, age, add_date, update_date, isOnline);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User serchUserByEmailAndPassword(String email, String password) {

        try (Connection con = getConnection()) {

            String query = "select * from user u where u.email=? and u.user_password=?";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, email);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();
            User user = null;

            if (rs.next()) {

                int user_id = rs.getInt("user_id");
                String name = rs.getString("user_name");
                String sur_name = rs.getString("sur_name");
                String email2 = rs.getString("email");
                String password2 = rs.getString("user_password");
                String about = rs.getString("about");
                Date age = rs.getDate("age");
                Timestamp add_date = rs.getTimestamp("add_date");
                Timestamp update_date = rs.getTimestamp("update_date");
                boolean isOnline = rs.getBoolean("is_online");
                user = new User(user_id, name, sur_name, email2, password2, about, age, add_date, update_date, isOnline);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> serchUsersByName(String name) {

        return null;
    }

    @Override
    public List<User> getAllUsers() {

        return null;
    }

    @Override
    public void addBatchUser(List<User> users) {

        String query = "insert into user (user_name, sur_name, email, user_password, about, age, add_date, update_date, is_online)"
                + " values(?,?,?,?,?,?,?,?,?)";

        try (Connection con = getConnection(); PreparedStatement pstm = con.prepareStatement(query)) {

            for (User u : users) {

                if (u != null) {
                    pstm.setString(1, u.getName());
                    pstm.setString(2, u.getSur_name());
                    pstm.setString(3, u.getEmail());
                    pstm.setString(4, u.getPassword());
                    pstm.setString(5, u.getAbout());
                    pstm.setDate(6, u.getAge());
                    pstm.setTimestamp(7, u.getAddDate());
                    pstm.setTimestamp(8, u.getUpdateDate());
                    pstm.setBoolean(9, u.isIsOnline());
                    pstm.addBatch();
                }
            }

            pstm.executeBatch();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<User> serchUsersByNameAndSurname(String userName, String surName) {

        String sql = "select u.user_id, u.user_name, u.sur_name, u.email, u.user_password, u.about, u.age,"
                + " u.add_date, u.update_date, u.is_online, n.birth_place, n.country from user u "
                + "left join nationality n on u.user_id=n.user_id "
                + "where u.user_name like '%" + userName + "%' and u.sur_name like '%" + surName + "%'";
        try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(sql);) {

            ResultSet rs = stmt.executeQuery();
            List<User> users = new ArrayList<User>();
            User user = null;
//                List<Skill> skills = new ArrayList<>();
//                PrivateInformation pi = null;
//                List<String> links = new ArrayList<>();
//                List<String> phones = new ArrayList<>();
            Nationality nat = null;
//                List<Address> addresses = new ArrayList<>();

            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String name = rs.getString("user_name");
                String sur_name = rs.getString("sur_name");
                String email = rs.getString("email");
                String password = rs.getString("user_password");
                String about = rs.getString("about");
                Date age = rs.getDate("age");
                Timestamp add_date = rs.getTimestamp("add_date");
                Timestamp update_date = rs.getTimestamp("update_date");
                boolean isOnline = rs.getBoolean("is_online");
                user = new User(user_id, name, sur_name, email, password, about, age, add_date, update_date, isOnline);
                String birthPlace = rs.getString("birth_place");
                String country = rs.getString("country");
                nat = new Nationality(birthPlace, country);

                user.setNationality(nat);
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            System.out.println("Not Found: " + ex);
            ex.printStackTrace();
        }

        return null;
    }

}
