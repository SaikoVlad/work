package com.example.prostrmk.demo.controller;

import com.example.prostrmk.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(Model model){
        model.addAttribute("user", new User());
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getPost(User user){
        return null;

    }

}

