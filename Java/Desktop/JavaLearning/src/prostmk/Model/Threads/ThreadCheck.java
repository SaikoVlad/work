package prostmk.Model.Threads;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ThreadCheck extends Thread {

    @Override
    public void run() {

        try {
            doMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void doMethod() throws IOException {
        Document document = Jsoup.connect("http://en.wikipedia.org/").get();
        Date date = new Date();
        StringBuilder generatedtext = new StringBuilder().append(date.getDay()).append("\n").append(date.getTime()).append("\n");
        generatedtext.append(document.body().getElementById("generatedtext").text());

        File file = new File("text.txt");
        FileUtils.writeStringToFile(file,  generatedtext.toString(), "UTF-8", true);
    }

}
