package by.bntu.fitr.povt.prostrmk.weather.Model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by prostrmk on 10.1.18.
 */

public class ParsingWeather {

    public static String getWeather(){
        StringBuilder stringBuilder = new StringBuilder();


        return stringBuilder.toString();
    }


    private static void hz() throws IOException {
        Document page = getPageFromUrl();
        Element table = page.select("a[class=link day-parts-next__list]").first();
        Elements names = table.select("div[class=future-h]");
        StringBuilder sb = new StringBuilder();
        for(Element i : names){
            sb.append(i.toString());

        }
    }

    private static Document getPageFromUrl() throws IOException {
        String url = "https://yandex.by/pogoda/minsk";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }

    private static void getText(){
        Pattern pattern = Pattern.compile("[а-яА-Я]");

//        Matcher matcher = pattern.matcher();
    }

    /*
    public static Document getPage() throws IOException {
        String url = "https://pogoda.tut.by/city/minsk/2week.html";
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }


    public static String getCorrectTime(String in) throws Exception {
        Matcher matcher = pattern.matcher(in);
        if (matcher.find()){

            return matcher.group();
        }else{
            throw new Exception("Can't extract data!");
        }
    }

     */

}
