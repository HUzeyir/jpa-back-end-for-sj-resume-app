package com.mycompany.main;

import com.mycompany.entity.Education;
import com.mycompany.entity.Language;
import com.mycompany.entity.Phone;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserDetail;
import com.mycompany.entity.UserSkill;
import com.mycompany.entity.util.PhoneType;
import com.mycompany.jpaFactory.JpaFactory;
import com.mycompany.service.PhoneService;
import com.mycompany.service.SkillService;
import com.mycompany.service.UserDetailService;
import com.mycompany.service.UserService;
import com.mycompany.service.UserSkillService;
import com.mycompany.serviceImpl.PhoneServiceImpl;
import com.mycompany.serviceImpl.SkillServiceImpl;
import com.mycompany.serviceImpl.UserDetailServiceImpl;
import com.mycompany.serviceImpl.UserServiceImpl;
import com.mycompany.serviceImpl.UserSkillServiceImpl;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        JpaFactory f=new JpaFactory() {};
//        setSkilsToDB();
//        UserService userService = new UserServiceImpl();
//        User user = new User("Uzeyir", "Huseynov", "huseynoow@gmail.com", "6119845u");
//        userService.addUser(user);
//        UserDetailService udService = new UserDetailServiceImpl();

//        UserDetail ud = new UserDetail("i am a junior java developer, but not i am strong on this, something getting wrong some time", customDate(1990, 02, 10));
//        User user = userService.findUser(1);
//        user.setUserDetail(ud);
//        userService.updateUser(user);
//        Education edu = new Education("Bdu", "Geology", "faydali qazinti yataqlarinin axtarisi ve kesfiyyati", customDate(2007, 06, 05), customDate(2011, 6, 6));
//        UserDetail ud = udService.findUserDetail(1);
//        ud.addEducation(edu);
//        udService.updateUserDetail(ud);
//        System.out.println(ud);
//        SkillService ss = new SkillServiceImpl();
//        Skill s1 = ss.getSkillById(1);
//        Skill s2 = ss.getSkillById(2);
//        Skill s3 = ss.getSkillById(3);
//        Skill s4 = ss.getSkillById(4);
//        Skill s5 = ss.getSkillById(5);
//        UserSkillService uskilService = new UserSkillServiceImpl();
//        UserSkill userSkill1 = uskilService.findUserSkill(1);
//        userSkill1.setUserDetail(ud);
//        UserSkill userSkill2 = uskilService.findUserSkill(2);
//        userSkill2.setUserDetail(ud);
//        UserSkill userSkill3 = uskilService.findUserSkill(3);
//        userSkill3.setUserDetail(ud);
//        UserSkill userSkill4 = uskilService.findUserSkill(4);
//        userSkill4.setUserDetail(ud);
//        UserSkill userSkill5 = uskilService.findUserSkill(5);
//        userSkill5.setUserDetail(ud);
//        UserSkill uskill1 = new UserSkill((byte) 8, s1);
//        UserSkill uskill2 = new UserSkill((byte) 9, s2);
//        UserSkill uskill3 = new UserSkill((byte) 7, s3);
//        UserSkill uskill4 = new UserSkill((byte) 6, s4);
//        UserSkill uskill5 = new UserSkill((byte) 8, s5);
//        ud.addUserSkill(uskill1);
//        ud.addUserSkill(uskill2);
//        ud.addUserSkill(uskill3);
//        ud.addUserSkill(uskill4);
//        ud.addUserSkill(uskill5);
//        uskilService.updateUserSkill(userSkill1);
//        uskilService.updateUserSkill(userSkill2);
//        uskilService.updateUserSkill(userSkill3);
//        uskilService.updateUserSkill(userSkill4);
//        uskilService.updateUserSkill(userSkill5);
//        User user = userService.findUser(1);
//        System.out.println(user+"\n");
//        UserDetail ud = user.getUserDetail();
//        System.out.println(ud+"\n");
//        
//        List<UserSkill> us = ud.getUserSkills();
//        us.forEach(System.out::println);
//        Phone phone = new Phone();
//        phone.addNumber(PhoneType.MOBILE, "055 611 98 45");
//        phone.addNumber(PhoneType.MOBILE, "055 292 11 42");
//        phone.addNumber(PhoneType.HOME, "021 256 42 45");
//
//        PhoneService ps = new PhoneServiceImpl();
//        ps.addPhone(phone);

    }

    public static void setSkilsToDB() {
        SkillService service = new SkillServiceImpl();
        Skill skill = new Skill("Java");
        service.addSkills(skill);
        Skill skill2 = new Skill("C++");
        service.addSkills(skill2);
        Skill skill3 = new Skill("C#");
        service.addSkills(skill3);
        Skill skill4 = new Skill("Python");
        service.addSkills(skill4);
        Skill skill5 = new Skill("Mysql");
        service.addSkills(skill5);
        Skill skill6 = new Skill("Oracle sql");
        service.addSkills(skill6);
        Skill skill7 = new Skill("Spring");
        service.addSkills(skill7);
        Skill skill8 = new Skill("Hibernate");
        service.addSkills(skill8);
        Skill skill9 = new Skill("PHP");
        service.addSkills(skill9);
        Skill skill10 = new Skill("Django");
        service.addSkills(skill10);
        Skill skill11 = new Skill("Swing");
        service.addSkills(skill11);
        Skill skill12 = new Skill("JSP&Servlet");
        service.addSkills(skill12);
        Skill skill13 = new Skill("Design Patterns");
        service.addSkills(skill13);
        Skill skill14 = new Skill("Ajax");
        service.addSkills(skill14);
        Skill skill15 = new Skill("C");
        service.addSkills(skill15);

    }

    public static Date customDate(int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        Date d = Date.valueOf(date);
        return d;
    }

}
