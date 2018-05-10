package by.bntu.fitr.povt.cng.controller;

import by.bntu.fitr.povt.cng.model.util.FileUtil;
import by.bntu.fitr.povt.cng.model.util.logging.CacheLogger;
import by.bntu.fitr.povt.cng.model.util.logging.CombinedLogger;
import by.bntu.fitr.povt.cng.model.util.logging.ConsoleLogger;
import by.bntu.fitr.povt.cng.model.util.logging.FileLogger;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

//        Garland garland = new Garland(1,1,1,1,1,"123123");
//        StuffedToys stuffedToys = new StuffedToys(2,3,3,"3","man",3);
//        Lights lights = new Lights(6,2,2,2,2,2);

        var logger = new FileLogger("check1.txt");
        var logger1 = new FileLogger("check.txt");
        for (int i = 0; i < 10; i++) {
            logger.logEvent(i + "\n");
            logger1.logEvent(  "\n");
        }

        System.out.println(FileUtil.compareFiles("check1.txt", "check.txt"));


    }

}

class NewList{

    static void split(ArrayList<Integer> one, ArrayList<Integer> two){
        var size = one.size() > two.size() ? one.size() : two.size();
        var i = 0;
        var j = 0;
        while (j < size){
            if (i < one.size() - 1 && one.get(i).compareTo(two.get(j)) < 0){
                i++;
            }else{
                if (one.get(i).compareTo(two.get(j)) < 0){
                    one.add(two.get(j));
                }else{
                    one.add(i,two.get(j));
                }
                j++;
            }
        }

    }


}