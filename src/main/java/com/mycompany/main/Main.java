package com.mycompany.main;

import com.mycompany.entity.Skill;
import com.mycompany.entity.UserDetail;
import com.mycompany.jpaFactory.JpaFactory;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        
        JpaFactory factory=new JpaFactory() {
        };

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

    public static List<UserDetail> getUsers() {

        List<UserDetail> users = new ArrayList();

        return users;
    }

    public static List<UserDetail> getUsers2() {

        List<UserDetail> users = new ArrayList();

        return users;
    }

    public static Date getAge(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        Date d = Date.valueOf(date);
        return d;
    }

}
