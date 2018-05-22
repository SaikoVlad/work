package by.bntu.fitr.povt.cng.model.features;

import by.bntu.fitr.povt.cng.model.entity.container.Tree;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWorking {

    private final static Logger LOGGER = Logger.getLogger(FileWorking.class);

    public static void writeInFile(String tree,String fileName){
        try{
            FileWriter writer = new FileWriter(fileName,false);
            writer.write(tree);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String fileName){
        try{
            FileReader reader = new FileReader(fileName);
            int symbolIndex;
            StringBuilder sb = new StringBuilder();
            while ((symbolIndex = reader.read()) != -1){
                sb.append((char)symbolIndex);
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            LOGGER.warn("File " + fileName + " Not Found");
            return e.toString();
        } catch (Exception e) {
            LOGGER.warn(e.toString());
            return e.toString();
        }
    }

    public static void writeInHtml(Tree tree){
        try{
            String firstHalf = "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n" + "    <title>Title</title>\n" + "</head>\n" + "<body>\n";
            String middle = tree.toString();
            String secondHalf = "\n" + "</body>\n" + "</html>";
            String all = firstHalf + middle + secondHalf;
            writeInFile(all,"Example.html");
        } catch (Exception e) {

        }
    }

}
