package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.beans.Role;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.beans.UserRoles;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.ArticleProcess;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

//    NAV BAR LINKS

    UserRoles userRoles = UserRoles.initUser(Role.ANON);

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getTest(){
        return "ViewTest";
    }

//    NAV BAR LINKS


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getLatest(){
        List<Article> articles = ArticleProcess.getLatestNews();
//        for (Article article : articles) {
//            article.getPathToFile();
//
//        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pic",new File(articles.get(0).getPathToFile()));
        modelAndView.addObject("titleOfPage", "Belarus IT News");
        modelAndView.addObject("articles", articles);
        modelAndView.addObject("searchArticle", new Article());
        modelAndView.addObject("user", userRoles);
        return modelAndView;
    }

    @RequestMapping(value = "/createArticle",method = RequestMethod.GET)
    public ModelAndView getCreatePage(){
        return new ModelAndView("createArticle","article", new Article());
    }

    @RequestMapping(value = "/createArticle", method = RequestMethod.POST)
    @ResponseBody
    public String getPostPage(@RequestParam("file") MultipartFile file, Article article){
        if (article.getType().equals("NO")){
            return "No type selected!";
        }
        if (ArticleProcess.savePic(file, article)){
            article.setType(article.getType().toLowerCase());
            DataBaseWork.addToDataBase(article);
            return "All fine, check out your new article!";
        }else{
            return "HM, something went wrong!";
        }

    }




}
