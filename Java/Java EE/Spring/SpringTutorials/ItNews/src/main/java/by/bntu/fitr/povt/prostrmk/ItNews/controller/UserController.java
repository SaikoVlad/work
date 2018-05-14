package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.Article;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.TempArticle;
import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.User;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.ArticleProcess;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    User user;

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public ModelAndView getRegPage() {
        return new ModelAndView("registration", "user", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView checkRegistration(User user) {
        if (user.getPassword() == null || user.getUsername() == null) {
            return new ModelAndView("error", "text", "Password or Username is incorrect");
        }
        user.setPassword(HibernateUtil.hashString(user.getPassword()));

        DataBaseWork.addToDataBase(user);
        logger.info("New User Registered");
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/offer", method = RequestMethod.GET)
    public ModelAndView offerArticle(){
        ModelAndView modelAndView = new ModelAndView("offerArticle");
        modelAndView.addObject("searchArticle", new Article());
        modelAndView.addObject("article", new TempArticle());
        return modelAndView;
    }

    @RequestMapping(value = "/offer", method = RequestMethod.POST)
    @ResponseBody
    public String addTempArticle(@RequestParam("file") MultipartFile file, TempArticle article){
        if (article.getType().equals("NO")) {
            return "No type selected!";
        }
        if (ArticleProcess.savePic(file, article)) {
            article.setContent(article.getContent() + "\n" + article.getUserName());
            article.setType(article.getType().toLowerCase());
            DataBaseWork.addToDataBase(article);
            logger.info("New Article Offered");
            return "All fine, check out your new article!";
        } else {
            return "HM, something went wrong!";
        }
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView getAuthPage() {
        return new ModelAndView("auth", "user", user);
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ModelAndView checkAuth(User newUser) {
        if (DataBaseWork.checkUser(newUser)) {
            user = newUser;
            logger.info("Someone Signed In");
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("error", "text", "no such user");
        }

    }


}
