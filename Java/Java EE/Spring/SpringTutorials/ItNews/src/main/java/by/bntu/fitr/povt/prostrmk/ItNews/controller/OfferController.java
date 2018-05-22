package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.dao.ArticleDao;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.TempArticle;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.User;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.StringsWork;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

@Controller
public class OfferController {


    private static final Logger logger = Logger.getLogger(OfferController.class);

    @Autowired
    User user;


    @RequestMapping(value = "/offer", method = RequestMethod.GET)
    public ModelAndView offerArticle(){
        ModelAndView modelAndView = new ModelAndView("offerArticle");
        modelAndView.addObject("searchArticle", new Article());
        modelAndView.addObject("article", new TempArticle());
        modelAndView.addObject("user", user);
        logger.info("Someone want to offer new article");
        return modelAndView;
    }

    @RequestMapping(value = "/offer", method = RequestMethod.POST)
    public ModelAndView addTempArticle(@RequestParam("file") MultipartFile file, TempArticle article){
        ModelAndView mav = new ModelAndView("message");
        mav.addObject("user", new User());
        mav.addObject("searchArticle", new Article());
        if (article.getType().equals("NO")) {
            mav.addObject("message", "No type selected!");
            return mav;
        }
        if (ArticleDao.savePic(file, article)) {
            article.setContent(article.getContent() + "\t Author: " + article.getUserName());
            article.setType(article.getType().toLowerCase());
            DataBaseWork.addToDataBase(article);
            logger.info("New Article Offered");
            mav.addObject("message", "Thank you very much for your article!");
        } else {
            logger.warn("Article Did't save in database: " + article.toString());
            mav.addObject("message", "Hm, something went wrong. Sorry");
        }
        return mav;
    }



    @RequestMapping(value = "/offered", method = RequestMethod.GET)
    public ModelAndView checkArticles(){
        ModelAndView mav = new ModelAndView("offered");
        List<TempArticle> articles = ArticleDao.getOfferedNews();
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getContent().toCharArray().length > 120){
                articles.get(i).setContent(articles.get(i).getContent().substring(0,120) + "...");
            }
        }
        mav.addObject("titleOfPage", "Offered news");
        mav.addObject("articles", articles);
        mav.addObject("searchArticle", new Article());
        mav.addObject("user", user);
        logger.info("Load Offered Articles: " + articles.size());
        return mav;
    }

    @RequestMapping(value = "/offered/{id}", method = RequestMethod.GET)
    public ModelAndView getOfferedArticleById(@PathVariable Long id){
        TempArticle article = (TempArticle) ArticleDao.getArticleById(id, TempArticle.class);
        ModelAndView modelAndView = new ModelAndView("offerSinglePage");
        article.setPathToFile("../" + article.getPathToFile());
        article.setTitle(StringsWork.firstUpperCase(article.getTitle()));
        modelAndView.addObject("article", article);
        modelAndView.addObject("searchArticle", new Article());
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/offered/acceptOffer/{id}", method = RequestMethod.GET)
    public String acceptOffer(@PathVariable Long id){
        TempArticle article = (TempArticle) ArticleDao.getArticleById(id, TempArticle.class);
        Article regArticle = new Article(article.getTitle(),article.getContent(),article.getType(),article.getPathToFile());
        DataBaseWork.addToDataBase(regArticle);
        DataBaseWork.deleteFromDataBase(article);
        logger.info("Admin Accepted Article");
        return "redirect:/offered";
    }

    @RequestMapping(value = "/offered/removeOffer/{id}", method = RequestMethod.GET)
    public String removeOffer(@PathVariable Long id){
        TempArticle article = (TempArticle) ArticleDao.getArticleById(id, TempArticle.class);
        File file = new File("src/main/webapp/" + article.getPathToFile());
        file.delete();
        DataBaseWork.deleteFromDataBase(article);
        logger.info("Admin Denied Article");
        return "redirect:/offered";
    }

}
