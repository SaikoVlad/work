package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.dao.ArticleDao;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.User;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping(value = "/articles")
public class DataController {



    @Deprecated
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView getPageById(@PathVariable Long id){
        Article article = (Article) ArticleDao.getArticleById(id, Article.class);
        if (article == null){
            return new ModelAndView("error","text","Incorrect link");
        }
        return new ModelAndView("news","article", article);
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView getRequests(Article article){
        List<Article> articles = DataBaseWork.search("title", article.getTitle());
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getContent().toCharArray().length > 120){
                articles.get(i).setContent(articles.get(i).getContent().substring(0,120) + "...");
            }
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("titleOfPage", "Search");
        modelAndView.addObject("articles", articles);
        modelAndView.addObject("searchArticle", new Article());
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


}
