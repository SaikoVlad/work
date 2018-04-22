package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.ArticleProcess;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.Date;
import java.util.List;

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
        List search = DataBaseWork.search(article.getTitle());
        ModelAndView modelAndView = new ModelAndView("news");
        modelAndView.addObject("articles", search);
        modelAndView.addObject("searchArticle", new Article());
        return modelAndView;
    }





    @RequestMapping(value = "/saveNewArticle", method = RequestMethod.GET)
    public ModelAndView getGetPage(){
        ModelAndView modelAndView = new ModelAndView("picSaverInDB");

        modelAndView.addObject("article", new Article());
        modelAndView.addObject("file", new File(new Date().toString() + ".jpg"));
        return modelAndView;
    }


}
