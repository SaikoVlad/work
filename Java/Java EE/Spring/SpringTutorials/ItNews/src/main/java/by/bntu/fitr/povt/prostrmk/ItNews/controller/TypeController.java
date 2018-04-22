package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.ArticleProcess;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.StringsWork;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class TypeController {


    @RequestMapping(value = "/{titleOfType}",method = RequestMethod.GET)
    public ModelAndView getProgrammingNews(@PathVariable String titleOfType){
        ModelAndView modelAndView = new ModelAndView("index");
        List articles;
        if (titleOfType.equals("programming") ||titleOfType.equals("startup") || titleOfType.equals("science") || titleOfType.equals("other")){
            articles = ArticleProcess.getArticlesByType(titleOfType);
            Collections.reverse(articles);
        }else{
            return new ModelAndView("error", "text", "Incorrect link!");
        }
        modelAndView.addObject("titleOfPage", StringsWork.firstUpperCase(titleOfType));
        modelAndView.addObject("articles", articles);
        return modelAndView;
    }

    @RequestMapping(value = "/{titleOfType}/{id}", method = RequestMethod.GET)
    public ModelAndView getPageById(@PathVariable Long id, @PathVariable String titleOfType){
        ModelAndView modelAndView = new ModelAndView("singleNews");
        Article article = null;
        if (titleOfType.equals("programming") ||titleOfType.equals("startup") || titleOfType.equals("science") || titleOfType.equals("other")){
            List<Article> articles = ArticleProcess.getArticlesByType(titleOfType);

//            article = ArticleProcess.getArticleById(id);
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
        modelAndView.addObject("article", article);
        return modelAndView;
    }





}
