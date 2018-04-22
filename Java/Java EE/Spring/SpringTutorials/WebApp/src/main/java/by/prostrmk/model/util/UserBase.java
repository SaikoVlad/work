package by.prostrmk.model.util;

import by.prostrmk.model.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

public class UserBase {



    public void addUser(User user){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {session.close(); }
        }
    }

    public void checkUser(User user){
        user.setPasswordAgain(user.getPassword());
        user.setPassword(Hash.getHash(user.getPassword()));
        System.out.println("Pass" + user.getPassword());
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
//        Query query = session.createQuery("select * from UserOnWebApp where mail = :email");
        Query query = session.createQuery("from UserOnWebApp where mail = 'qwe'");
//        query.setParameter("email", user.getMail());
        List list = query.list();
        for (Object o : list) {
            System.out.println(o);
        }
        session.getTransaction().commit();
        session.close();

    }

    //todo methods for db

}
