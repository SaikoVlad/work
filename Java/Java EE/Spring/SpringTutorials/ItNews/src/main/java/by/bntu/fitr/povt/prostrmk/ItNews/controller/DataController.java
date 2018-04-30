package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.ArticleProcess;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.*;

@Controller
@RequestMapping(value = "/articles")
public class DataController {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ModelAndView getPageById(@PathVariable Long id){
        Article article = ArticleProcess.getArticleById(id);
        if (article == null){
            return new ModelAndView("error","text","Incorrect link");
        }
        return new ModelAndView("news","article", article);
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public ModelAndView getRequests(Article article){
        List search = DataBaseWork.search("title", article.getTitle());
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("titleOfPage", "Search");
        modelAndView.addObject("articles", search);
        modelAndView.addObject("searchArticle", new Article());
        return modelAndView;
    }


}
