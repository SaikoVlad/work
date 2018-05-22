package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.dao.ArticleDao;
import by.bntu.fitr.povt.prostrmk.ItNews.dao.CommentDao;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Comment;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.User;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.StringsWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class TypeController {


    @Autowired
    User user;

    @RequestMapping(value = "/{titleOfType}",method = RequestMethod.GET)
    public ModelAndView getProgrammingNews(@PathVariable String titleOfType){
        ModelAndView modelAndView = new ModelAndView("index");
        List<Article> articles;
        if (titleOfType.equals("programming") ||titleOfType.equals("startup") || titleOfType.equals("science") || titleOfType.equals("other")){
            articles = ArticleDao.getArticlesByType(titleOfType);
            Collections.reverse(articles);
            for (int i = 0; i < articles.size(); i++) {
                if (articles.get(i).getContent().toCharArray().length > 120){
                    articles.get(i).setContent(articles.get(i).getContent().substring(0,120) + "...");
                }
            }
        }else{
            return new ModelAndView("error", "text", "Incorrect link!");
        }
        modelAndView.addObject("user", user);
        modelAndView.addObject("titleOfPage", StringsWork.firstUpperCase(titleOfType));
        modelAndView.addObject("articles", articles);
        modelAndView.addObject("searchArticle", new Article());
        return modelAndView;
    }

    @RequestMapping(value = "/{titleOfType}/{id}", method = RequestMethod.GET)
    public ModelAndView getPageById(@PathVariable Long id, @PathVariable String titleOfType){
        ModelAndView modelAndView = new ModelAndView("singleNews");
        Article article = null;
        List<Comment> comments = null;
        if (titleOfType.equals("programming") ||titleOfType.equals("startup") || titleOfType.equals("science") || titleOfType.equals("other")){
            List<Article> articles = ArticleDao.getArticlesByType(titleOfType);
            for (Article o : articles) {
                if (o.getId().equals(id)){
                    article = o;
                }
            }
            if (article == null) return new ModelAndView("error", "text", "Incorrect link!");
        }else {
            return new ModelAndView("error", "text", "Incorrect link!");
        }
        article.setTitle(StringsWork.firstUpperCase(article.getTitle()));
        article.setPathToFile("../" + article.getPathToFile());
        comments = CommentDao.getCommentsByArticleId(id);
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("article", article);
        modelAndView.addObject("searchArticle", new Article());
        modelAndView.addObject("newComment", new Comment());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/{titleOfType}/{id}", method = RequestMethod.POST)
    public String setComment(Comment comment, @PathVariable Long id, @PathVariable String titleOfType){
        comment.setArticleId(id);
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        comment.setDate(formatForDateNow.format(dateNow));
        DataBaseWork.addToDataBase(comment);
        return "redirect:/" + titleOfType + "/" + id;
    }




}
