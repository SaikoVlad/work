package by.bntu.fitr.povt.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {

    public WriteInFile(){}

    public static void write(String maintext){
        String filePath = "/home/prostrmk/Рабочий стол/labs.txt";
//        String filePath = "labs.txt";
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(maintext);
            bufferWriter.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

}
