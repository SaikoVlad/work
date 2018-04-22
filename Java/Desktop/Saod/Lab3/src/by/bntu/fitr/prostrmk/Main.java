package by.bntu.fitr.prostrmk;
import by.bntu.fitr.prostrmk.collections.StringComparator;
import by.bntu.fitr.prostrmk.collections.queue.LinkedQueue;

public class Main {
    public static void main(String[] args){
        LinkedQueue<String> strings = new LinkedQueue<>(new StringComparator());
        strings.put("a string");
        strings.put("google");
        strings.put("zoo");
        strings.put("bible");
        strings.put("weather");
        strings.put("pepsi");
        strings.put("water");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}