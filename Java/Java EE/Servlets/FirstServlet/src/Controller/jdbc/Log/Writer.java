package Controller.jdbc.Log;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void inTxtFile(String in) {
        try (FileWriter writer = new FileWriter("log.txt", false)) {
            writer.write(in);
            writer.flush();
        } catch (IOException ex) {
            System.err.println(ex.getMessage().toUpperCase());
        }
    }

    public static void writeStatus(boolean status) {
        try (FileWriter writer = new FileWriter("log.txt", false)) {
            if (status){writer.write("Status: okay".toUpperCase());}
            else{writer.write("Status: exception".toUpperCase());}
            writer.flush();
        } catch (IOException ex) {
            System.err.println(ex.getMessage().toUpperCase());
        }

    }

}
