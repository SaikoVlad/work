package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.User;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.beans.Role;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.beans.UserRoles;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.ArticleProcess;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.util.List;

@Controller
public class MainController {

//    UserRoles userRoles = UserRoles.initUser(Role.ANON);

    private static final Logger logger = Logger.getLogger(MainController.class);



    @Autowired
    User user;

    @Bean
    public User getUser(){
        User user = new User();
        user.setUsername("Anon");
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getLatest() {
        List<Article> articles = ArticleProcess.getLatestNews();
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getContent().toCharArray().length > 15){
                articles.get(i).setContent(articles.get(i).getContent().substring(0,80) + "...");
            }
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("pic", new File(articles.get(0).getPathToFile()));
        modelAndView.addObject("titleOfPage", "Belarus IT News");
        modelAndView.addObject("articles", articles);
        modelAndView.addObject("searchArticle", new Article());
        modelAndView.addObject("user", user);
        logger.info("Visit main page");
        return modelAndView;
    }

    @RequestMapping(value = "/createArticle", method = RequestMethod.GET)
    public ModelAndView getCreatePage() {
        ModelAndView modelAndView = new ModelAndView("createArticle");
        modelAndView.addObject("searchArticle", new Article());
        modelAndView.addObject( "article", new Article());
        return modelAndView;
    }

    @RequestMapping(value = "/createArticle", method = RequestMethod.POST)
    @ResponseBody
    public String getPostPage(@RequestParam("file") MultipartFile file, Article article) {
        if (article.getType().equals("NO")) {
            return "No type selected!";
        }
        if (ArticleProcess.savePic(file, article)) {
            article.setType(article.getType().toLowerCase());
            DataBaseWork.addToDataBase(article);
            logger.info("New Article Added");
            return "All fine, check out your new article!";
        } else {
            return "HM, something went wrong!";
        }

    }


}
