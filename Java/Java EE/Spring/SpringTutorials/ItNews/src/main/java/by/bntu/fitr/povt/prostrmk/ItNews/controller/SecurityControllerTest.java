package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/security")
public class SecurityControllerTest {

    @RequestMapping("/public")
    @ResponseBody
    public String publicMapping(){
        return "This is public";
    }

    @RequestMapping("/protected")
    @ResponseBody
    public String protectedMapping(){
        return "This is protected";
    }

    @RequestMapping("/private")
    @ResponseBody
    public String privateMapping(){
        return "This is private";
    }


}
