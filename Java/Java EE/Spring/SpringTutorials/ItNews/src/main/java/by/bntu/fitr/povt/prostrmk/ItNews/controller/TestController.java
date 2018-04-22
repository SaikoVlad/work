package by.bntu.fitr.povt.prostrmk.ItNews.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

@Controller
public class TestController {



    @RequestMapping(value = "/picsaver", method = RequestMethod.GET)
    public ModelAndView getPageToSavePic() {
        return new ModelAndView("picSaverInDB", "picture", new Object());
    }

    @RequestMapping(value = "/picsaver", method = RequestMethod.POST)
    public String savePost(@RequestParam CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        byte[] bytes = file.getBytes();
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("static/articlePics/" + File.separator + new Date().toString())));) {
            stream.write(bytes);
            System.out.println("ALL IS OKAY!");
        } catch (Exception e) {
            System.err.println(e);
        }
        return "index";
    }


}
