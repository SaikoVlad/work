package by.bntu.fitr.povt.prostrmk.itnews.controller;


import by.bntu.fitr.povt.prostrmk.itnews.model.util.DataBaseWork;

public class MainController {

    public static String getNews(){
        return DataBaseWork.getNews();
    }

}
