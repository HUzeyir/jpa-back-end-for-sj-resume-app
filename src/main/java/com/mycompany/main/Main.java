package com.mycompany.main;

//import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.context.Context;
import com.mycompany.daoImpl.AbstractDao;
import com.mycompany.daoInter.SkillDaoInter;
import com.mycompany.daoInter.UserDaoInter;
import com.mycompany.dbprocess.AdminPanel;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main extends AbstractDao {

    public static void main(String[] args) {
       

        UserDaoInter udi = Context.instanceUserDao();
////        User uByEmail=udi.serchUserByEmailAndPassword("ismayilos@gmail.com", "6035604isma");
//         User u2=udi.getUserbyId(5);
//         System.out.println(u2.getEmail());

User user=new User("Test100", "Testov100", "test100@gmail.com", "1234", "this user created for test test100", getAge(1889, 5, 25), Timestamp.valueOf(LocalDateTime.now()), true);
User user2=new User("Test101", "Testov101", "test101@gmail.com", "12345", "this user created for test101", getAge(1889, 5, 25), Timestamp.valueOf(LocalDateTime.now()), true);
udi.addUser(user2);

    }

    public static List<Skill> getSkils() {

        Skill skill = new Skill("Java");
        Skill skill2 = new Skill("C++");
        Skill skill3 = new Skill("C#");
        Skill skill4 = new Skill("Python");
        Skill skill5 = new Skill("Mysql");
        Skill skill6 = new Skill("Oracle sql");
        Skill skill7 = new Skill("Spring");
        Skill skill8 = new Skill("Hibernate");
        Skill skill9 = new Skill("PHP");
        Skill skill10 = new Skill("Django");
        Skill skill11 = new Skill("Swing");
        Skill skill12 = new Skill("JSP&Servlet");
        Skill skill13 = new Skill("Design Patterns");
        Skill skill14 = new Skill("Ajax");
        Skill skill15 = new Skill("C");

        List<Skill> skills = new ArrayList<>();
        skills.add(skill);
        skills.add(skill2);
        skills.add(skill3);
        skills.add(skill4);
        skills.add(skill5);
        skills.add(skill6);
        skills.add(skill7);
        skills.add(skill8);
        skills.add(skill9);
        skills.add(skill10);
        skills.add(skill11);
        skills.add(skill12);
        skills.add(skill13);
        skills.add(skill14);
        skills.add(skill15);

        return skills;

    }

    public static List<User> getUsers() {

        List<User> users = new ArrayList();

        User user = new User("Uzeyir", "Huseynov", "huseynoow@gmail.com", "1234uzeyir", "I am a junior java programmer",
                Date.valueOf(LocalDate.of(1990, 2, 10)), Timestamp.valueOf(LocalDateTime.now()), false);
        User user2 = new User("Ismayil", "Huseynov", "ismayilos@gmail.com", "6035604isma", "I am a senior system admin",
                Date.valueOf(LocalDate.of(1991, 4, 5)), Timestamp.valueOf(LocalDateTime.now()), false);
        User user3 = new User("Aytac", "Huseynova", "aytachuseyn@gmail.com", "7771717ay", "I am a filoloq",
                Date.valueOf(LocalDate.of(2001, 2, 10)), Timestamp.valueOf(LocalDateTime.now()), false);
        User user4 = new User("Qundi", "Axundov", "qund@gmail.com", "5555qund", "I am a expert about data transfer and sience",
                Date.valueOf(LocalDate.of(1987, 9, 18)), Timestamp.valueOf(LocalDateTime.now()), false);
        User user5 = new User("Ferid", "Mustafayev", "Mustafa@mail.ru", "12345mustafa", "I am a midle topqraf",
                Date.valueOf(LocalDate.of(1988, 12, 25)), Timestamp.valueOf(LocalDateTime.now()), false);
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        return users;
    }

    public static List<User> getUsers2() {

        List<User> users = new ArrayList();

        User user = new User("Test", "Testov", "huseynoow@gmail.com", "1234uzeyir", "I am a junior java programmer",
                Date.valueOf(LocalDate.of(1990, 2, 10)), Timestamp.valueOf(LocalDateTime.now()), false);
        User user2 = new User("Test2", "Testov2", "ismayilos@gmail.com", "6035604isma", "I am a senior system admin",
                Date.valueOf(LocalDate.of(1991, 4, 5)), Timestamp.valueOf(LocalDateTime.now()), false);
        User user3 = new User("Test3", "Testov3", "aytachuseyn@gmail.com", "7771717ay", "I am a filoloq",
                Date.valueOf(LocalDate.of(2001, 2, 10)), Timestamp.valueOf(LocalDateTime.now()), false);
        User user4 = new User("Test4", "Test4ov", "qund@gmail.com", "5555qund", "I am a expert about data transfer and sience",
                Date.valueOf(LocalDate.of(1987, 9, 18)), Timestamp.valueOf(LocalDateTime.now()), false);
        User user5 = new User("Test5", "Testov5", "Mustafa@mail.ru", "12345mustafa", "I am a midle topqraf",
                Date.valueOf(LocalDate.of(1988, 12, 25)), Timestamp.valueOf(LocalDateTime.now()), false);
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        return users;
    }

    public static Date getAge(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        Date d = Date.valueOf(date);
        return d;
    }

}
