package by.bntu.fitr.povt.cng.controller;

import by.bntu.fitr.povt.cng.model.entity.abstracts.Toy;
import by.bntu.fitr.povt.cng.model.util.FileUtil;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws Exception {
        String word = "java";
        IoWorker.writeInFile("outfile.txt","\n\tThere are " + IoWorker.sumOfEntrance("newfile.txt", word) + " entrance of word " + word) ;

    }

}


class IoWorker{




    static int sumOfEntrance(String filename, String word){
        int counter = 0;
        var text = readFromFile(filename);
        String[] mas = text.split(" ");
        for (String ma : mas) {
            if (ma.equals(word)){
                counter++;
            }
        }
        return counter;
    }

    private static final Logger LOGGER = Logger.getLogger(IoWorker.class);

    public static String readFromFile(String filename){
        FileReader fr = null;
        var sb = new StringBuilder();
        try{
            fr = new FileReader(filename);
            int i;
            while((i = fr.read())!=-1){
                sb.append((char)i);
            }
        } catch (IOException e) {
            LOGGER.warn("No such file!");
        }
        return sb.toString();
    }

    static void writeInFile(String fileName, String text){
        FileWriter fileWriter =null;
        try {
            fileWriter = new FileWriter(fileName,true);
            fileWriter.write(text);

        } catch (IOException e) {
            LOGGER.warn("No such file");
        }finally {
            if (fileWriter!=null){
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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