package prostmk.Controller;

import prostmk.Model.Threads.FIleThreadsReader;
import prostmk.Model.Threads.FileThreadsWriter;

import java.io.*;

public class MainClass {


    public static void main(String[] args) throws IOException {


        FileThreadsWriter writer = new FileThreadsWriter("threads.txt", "threadsthreadsthreadsthreadsthreadsthreadsthreadsthreads");
        new Thread(writer).start();
        FIleThreadsReader reader = new FIleThreadsReader("threads.txt");
        new Thread(reader).start();

    }

}
class CheckIO {

    static void write(String text, String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName,true);
        fw.write(text);
        fw.flush();
        fw.close();
    }

    static String read(String fileName) throws IOException {
        FileReader fs = new FileReader(fileName);
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while ((i = fs.read()) != -1){
            sb.append((char)i);
        }
        fs.close();
        return sb.toString();

    }

}