/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbprocess;

import com.mycompany.daoImpl.AbstractDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HuzeyirPc
 */
public class AdminPanel extends AbstractDao {

    private AdminPanel() {
    }

    private void execute(String query, String message) {
        Connection con = getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.execute();
            System.out.println(message);
        } catch (SQLException ex) {
            System.out.println("Failed: :( " + ex.getMessage() + ex);
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("connection dont closed: " + ex.getMessage());
            }
        }

    }

    private void createPrivateInformationTable() {
        String query = "create table if not exists jdbctest.private_information (pi_id int not null primary key auto_increment)";
        String message = "Private Information table created succesfully";
        execute(query, message);
    }

    private void deletePrivateInformationTable() {

    }

    private void createPhoneTable() {

        String query = "create table if not exists jdbctest.phone (phone_id int not null primary key auto_increment, phones varchar(40), pi_id int not null, "
                + "foreign key (pi_id) references private_information(pi_id))";
        String message = "phone table created succesfully";
        execute(query, message);
    }

    private void createLinkTable() {

        String query = "create table if not exists jdbctest.link (link_id int not null primary key auto_increment, links varchar(240),"
                + " pi_id int not null,  foreign key (pi_id) references private_information(pi_id))";
        String link = "link table created succesfully";
        execute(query, link);
    }

    private void createDeletedTable() {

        String query = "create table if not exists jdbctest.deleted (deleted_id int not null auto_increment primary key, deleted_time timestamp not null)";
        String message = "deleted table created succesfully";
        execute(query, message);
    }

    private void createUserTable() {

        String query = " create table user (user_id int not null auto_increment primary key, user_name varchar(30), sur_name varchar(40),"
                + " email varchar(50) not null, user_password varchar(60), about text, age date, add_date timestamp not null, update_date timestamp,"
                + "is_online tinyint not null, deleted_id int, pi_info_id int, foreign key (deleted_id) references deleted (deleted_id),"
                + " foreign key(pi_info_id) references private_information(pi_id) )";

        String message = "user table created succesfully";
        execute(query, message);
    }

    private void createNationalityTable() {
        String query = "create table if not exists jdbctest.nationality (nat_id int not null primary key auto_increment, birth_place varchar(150), country varchar(50), "
                + "user_id int not null, foreign key(user_id) references user(user_id))";
        String message = "nationality table created succesfully";
        execute(query, message);
    }

    private void deleteUserTable() {

    }

    private void createAddressTable() {

        String query = "create table if not exists jdbctest.address (address_id int not null primary key auto_increment, city varchar(50), town varchar(80), street varchar (90))";
        String message = "address table created succesfully";
        execute(query, message);

    }

    private void createSkillTable() {
        String query = "create table if not exists jdbctest.skill (skill_id int not null primary key auto_increment, skills_name varchar(50))";
        String message = "skill table created succesfully";
        execute(query, message);
    }

    private void deleteAddressTable() {

        String query = "create table if not exists jdbctest.user (id int not null auto_increment primary key,"
                + " name varchar(30), sur_name varchar(40), email varchar(60) not null"
                + ", age Date, password varchar(80) not null, add_date Date not null, update_date Timestamp)";
        String message = "user table created succesfully";
        execute(query, message);

    }

    private void createUserAddressTable() {
        String query = "create table if not exists jdbctest.user_address(ua_id int not null primary key auto_increment, address_id int not null, "
                + "user_id int not null, foreign key(address_id) references address(address_id), foreign key (user_id) references user(user_id))";
        String message = "user_address table created succesfully";
        execute(query, message);
    }

    private void createUserSkillTable() {
        String query = "create table if not exists jdbctest.user_skill(us_id int not null primary key auto_increment, power int(3), skill_id int not null, "
                + "user_id int not null, foreign key(skill_id) references skill(skill_id), foreign key (user_id) references user(user_id))";
        String message = "user table created succesfully";
        execute(query, message);
    }

    private void createDB() {
        String query = "create database if not exists jdbctest character set UTF8MB4 COLLATE UTF8MB4_general_ci";
        String message = "jdbctest db created sucessfully";
        Connection con = null;
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "1234");

            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
            

            System.out.println("Connected: " + message);
        } catch (SQLException ex) {
            System.out.println("poor connection: " + ex.getMessage());
        }
    }

    private void useDB() {
        String query = "use jdbctest";
        String message = "db changed";
        Connection con = getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.executeUpdate();
            System.out.println(message);
        } catch (SQLException ex) {
            System.out.println("Failed: :( " + ex.getMessage() + ex);
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("connection dont closed: " + ex.getMessage());
            }
        }

    }

    private void deleteDB() {
        String query = "drop database if exists jdbctest";
        String message = "jdbctest database deleted succesfully";
        Connection con = getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.executeUpdate();
            System.out.println(message);
        } catch (SQLException ex) {
            System.out.println("Failed: :( " + ex.getMessage() + ex);
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("connection dont closed: " + ex.getMessage());
            }
        }

    }

    public static void initialize() {

        AdminPanel process = new AdminPanel();
        process.createDB();
        process.useDB();
        process.createPrivateInformationTable();
        process.createPhoneTable();
        process.createLinkTable();
        process.createDeletedTable();
        process.createUserTable();
        process.createNationalityTable();
        process.createAddressTable();
        process.createSkillTable();
        process.createUserAddressTable();
        process.createUserSkillTable();

    }

    public static void deInitialize() {

        AdminPanel process = new AdminPanel();
        process.deleteDB();

    }
}

//  create table private_information (pi_id int not null primary key auto_increment);
//
// create table phone (phone_id int not null primary key auto_increment, phones varchar(40), pi_id int not null, foreign key (pi_id) 
// references private_information(pi_id));
//
// create table link (link_id int not null primary key auto_increment, links varchar(240), pi_id int not null,  foreign key (pi_id) 
// references private_information(pi_id));
//
// create table deleted (deleted_id int not null auto_increment primary key, deleted_time timestamp not null);
//
// create table user (user_id int not null auto_increment primary key, user_name varchar(30), sur_name varchar(40), 
// email varchar(50) not null, user_password varchar(60), about text, age date, add_date timestamp not null, update_date timestamp,
// is_online tinyint not null, foreign key (user_id) references deleted (deleted_id), foreign key(user_id) 
// references private_information(pi_id) );
//
// create table nationality (nat_id int not null primary key auto_increment, birth_place varchar(150), country varchar(50), user_id int not null, 
// foreign key(user_id) references user(user_id));
//
// alter table user if not exists add constraint user_private_information foreign key (user_id) references private_information(pi_id);
//
// create table address (address_id int not null primary key auto_increment, city varchar(50), town varchar(80), street varchar (90));
//
// create table skill (skill_id int not null primary key auto_increment, skills_name varchar(50), power int(2));
//
// create table user_address(ua_id int not null primary key auto_increment, address_id int not null, user_id int not null, 
// foreign key(address_id) references address(address_id), foreign key (user_id) references user(user_id));
//
// create table user_skill(us_id int not null primary key auto_increment, skill_id int not null, user_id int not null, 
// foreign key(skill_id) references skill(skill_id), foreign key (user_id) references user(user_id));
