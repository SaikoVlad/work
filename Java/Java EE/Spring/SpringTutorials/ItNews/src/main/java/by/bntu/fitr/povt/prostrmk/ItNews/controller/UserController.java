package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import by.bntu.fitr.povt.prostrmk.ItNews.model.entity.User;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.DataBaseWork;
import by.bntu.fitr.povt.prostrmk.ItNews.model.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
