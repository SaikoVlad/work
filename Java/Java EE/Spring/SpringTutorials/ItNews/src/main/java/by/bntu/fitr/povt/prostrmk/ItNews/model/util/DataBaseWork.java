package by.bntu.fitr.povt.prostrmk.ItNews.model.util;

import org.hibernate.Query;
import org.hibernate.Session;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class DataBaseWork {

    public static void addToDataBase(Object entity){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {session.close(); }
        }
    }

    public static List search(String title){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("FROM Article A WHERE title = :title");
            query.setString("title", title);
            return query.list();
        }catch (Exception e){
            return new ArrayList();
        }
    }

}
