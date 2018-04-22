import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Weather {

    public static String getWeather(String url, String tablestr, String elstr) throws Exception {
        Document page = Weather.getPage(url);
        Element table = page.select(tablestr).first();
        Elements names = table.select(elstr);
        StringBuilder sb = new StringBuilder();
        for(Element i : names){
            sb.append(i.toString());
        }
        String mas[] = split(getCorrectTime(sb.toString()));
        System.out.println((getCorrectDegree(sb.toString(),mas)));
        return (getCorrectDegree(sb.toString(),mas));
    }

    private static Document getPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url),3000);
        return page;
    }

    private static String getCorrectTime(String in) throws Exception {
        Pattern pattern = Pattern.compile("[а-яА-Я]+<br");
        Matcher matcher = pattern.matcher(in);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()){
            stringBuilder.append(matcher.group());
        }
        if (stringBuilder.toString().equals("")){
            throw new Exception("No matches");
        }else{
            return stringBuilder.toString();
        }
    }

    private static String getCorrectDegree(String in, String []mas){
        Pattern pattern = Pattern.compile("(-|\\+| )[0-9]+");

        Matcher matcher = pattern.matcher(in);
        StringBuilder sb = new StringBuilder();
        byte i = 0,j = 0;
        while(matcher.find()){

            if (matcher.group().toCharArray()[0] == '-' || matcher.group().toCharArray()[0] == '+' || matcher.group().toCharArray()[0] == '0'){

                if (i==0){sb.append(mas[j]);}
                sb.append("\n");
            }
            sb.append(matcher.group());
            if (j==3){j=0;}
            i++;j++;
            if (i==1){sb.append(" <- Минимальная температура");}
            else if (i==2){sb.append(" <- Максимальная температура\n");i = 0;}
        }
        return sb.toString();
    }

    private static String[] split(String in){
//        StringBuilder sb = new StringBuilder();
        String []mas = in.split("<br");
        return mas;
    }

}

