package prostmk.Model.Threads;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FIleThreadsReader implements Runnable{

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public FIleThreadsReader(String filename) {

        this.filename = filename;
    }


    @Override
    public void run() {
        try {
            FileReader fr = new FileReader(filename);
            int i = 0;
            while((i = fr.read()) != -1){
                System.out.println((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
