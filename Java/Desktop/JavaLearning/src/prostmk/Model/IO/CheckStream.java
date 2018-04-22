package prostmk.Model.IO;

import java.io.*;

public class CheckStream {

    public static void writeToFile(String text, String pathAndFileName){

        try(FileWriter fileWriter =  new FileWriter(pathAndFileName)){
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String readFromFile(String file){
        StringBuilder stringBuilder = new StringBuilder();
        try(FileInputStream fileInputStream = new FileInputStream(file)){
            byte []buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer,0,fileInputStream.available());
            for (byte aBuffer : buffer) {
                stringBuilder.append((char) aBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }




}
