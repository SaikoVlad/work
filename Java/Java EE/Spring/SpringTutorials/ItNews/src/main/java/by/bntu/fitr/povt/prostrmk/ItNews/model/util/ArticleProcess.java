package by.bntu.fitr.povt.prostrmk.ItNews.model.util;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.IArticles;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.TempArticle;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArticleProcess {

    public static Object getArticleById(long id, Class clazz){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(clazz);
        criteria.add(Restrictions.eq("id",id));
        return criteria.uniqueResult();
    }



    public static List getLatestNews(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria articleCriteria = session.createCriteria(Article.class);
        Long rowCount = (Long.parseLong(session.createCriteria(Article.class).setProjection(Projections.rowCount()).uniqueResult().toString()));
        List<Article> list = articleCriteria.list();
        Collections.reverse(list);
        return list;
    }

    public static Long getCountOfArticles(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Long.parseLong(session.createCriteria(Article.class).setProjection(Projections.rowCount()).uniqueResult().toString()));
    }

    public static List getOfferedNews(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TempArticle.class);
        return (List<TempArticle>) criteria.list();
    }

    public static Article getArticleByTitle(String title) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria articleCriteria = session.createCriteria(Article.class);
        articleCriteria.add(Restrictions.eq("title",title));
        Article article = (Article) articleCriteria.uniqueResult();
        session.close();
        return article;
    }

    public static Article checkTestArticles(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Article.class);
        criteria.add(Restrictions.eq("id",id));
        return (Article) criteria.uniqueResult();
    }

    public static boolean savePic(MultipartFile file, IArticles article){
        if (!file.isEmpty()){
            try{
                byte []bytes = file.getBytes();
                String name = file.getOriginalFilename();
                String rootPath = System.getProperty("catalina.home");
                File directory = new File( "src/main/webapp/resources/pics/");
                if (!directory.exists()){
                    directory.mkdirs();
                }
                String pathName = directory.getAbsolutePath() + File.separator + name;
                File uploadedFile = new File(pathName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                pathName = "resources/pics/" + name;
                article.setPathToFile(pathName);
                stream.flush();
                stream.close();
                return true;
            }catch (Exception e){
                System.err.println(e);
            }
        }
        return false;
    }



    public static List getArticlesByType(String type){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Article.class);
        criteria.add(Restrictions.eq("type", type));
        return criteria.list();
    }

}
