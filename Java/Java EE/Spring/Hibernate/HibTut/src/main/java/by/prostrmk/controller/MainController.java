package by.prostrmk.controller;

import by.prostrmk.model.UserBase;
import by.prostrmk.model.entity.User;
import by.prostrmk.model.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class MainController {

    public static void main(String[] args) {

        User user = new User("Anton", "SomeAnton");
        UserBase userBase = new UserBase();
        userBase.removeUser(user);
        List allUsers = userBase.getAllUsers();
        for (Object u : allUsers){
            System.out.println(u);
        }
        return;

    }

}
