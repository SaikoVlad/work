package by.prostrmk.model;

import by.prostrmk.model.entity.User;
import by.prostrmk.model.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserBase {

    public void addUser(User user){

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            if(session!=null && session.isOpen()){
                session.close();
            }
        }
    }

    @Deprecated
    public void removeUser(User user){
        Session session = null;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        if (session.isOpen()){
            session.close();
        }
    }

    public List getAllUsers(){
        Session session = null;
        List userList = new ArrayList<User>();
        session = HibernateUtil.getSessionFactory().openSession();
        userList = session.createCriteria(User.class).list();
        if (session.isOpen()){
            session.close();
        }
        return userList;
    }

}
