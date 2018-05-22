package by.bntu.fitr.povt.prostrmk.ItNews.dao;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Comment;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CommentDao {

    public static List getCommentsByArticleId(long articleId){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Comment.class);
        criteria.add(Restrictions.eq("articleId", articleId));
        return criteria.list();
    }



}
