package by.bntu.fitr.povt.prostrmk.ItNews.model.util;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

    public static List search(String column, String searchString){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            String hql = new StringBuilder().append("FROM Article A WHERE ").append(column).append(" LIKE '%").append(searchString).append("%'").toString();//
            Query query = session.createQuery(hql);//
            return query.list();
        }catch (Exception e){
            return new ArrayList();
        }finally {
            assert session != null;
            session.close();
        }
    }

    public static boolean checkUser(User user){
        user.setPassword(HibernateUtil.hashString(user.getPassword()));
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username",user.getUsername()));
        List list = criteria.list();
        User inBaseUser;
        try{
            inBaseUser = (User) list.get(0);
        }catch (Exception e){
            return false;
        }
        System.out.println(user);
        System.out.println(inBaseUser);
        return inBaseUser.equals(user);
    }

}
