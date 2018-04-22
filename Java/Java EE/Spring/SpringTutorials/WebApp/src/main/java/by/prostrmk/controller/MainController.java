package by.prostrmk.controller;

import by.prostrmk.model.entity.User;
import by.prostrmk.model.util.Hash;
import by.prostrmk.model.util.UserBase;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    private ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

    @RequestMapping(value = "/front")
    public String getFront(){
        return "frontend";
    }


    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView getAuthPage(){
        return new ModelAndView("auth","user",new User());
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String isRegistered(User user){
        UserBase userBase = new UserBase();
        userBase.checkUser(user);
        return "/";
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    public String checkUserInBase(User user){
        UserBase userBase = (UserBase) context.getBean("base");
        userBase.checkUser(user);
        return "auth";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getPage(){
        return new ModelAndView("index","newUser",new User());
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String getPostPage(@ModelAttribute User user, Model model){
        if (!user.getPassword().equals(user.getPasswordAgain())){
            model.addAttribute("username", user.getMail());
            model.addAttribute("password", "PASSWORDS MISMATCH!!!");
            return "submit";
        }
        user.setPassword(Hash.getHash(user.getPassword()));
        UserBase userBase = (UserBase) context.getBean("base");
        userBase.addUser(user);
        System.out.println(user);
        model.addAttribute("username",user.getMail());
        model.addAttribute("password", user.getPassword());
        return "submit";

    }

}
