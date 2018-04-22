package by.bntu.fitr.povt.prostrmk.model.loggers;

import by.bntu.fitr.povt.prostrmk.model.Event;

import java.util.ArrayList;

public class CacheFileLogger extends FileEventLogger{

    private int cacheSize;
    private ArrayList<Event> cache = new ArrayList<Event>();

    public CacheFileLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    public CacheFileLogger(String fileName){
        super(fileName);
        this.cacheSize = 5;
    }

    public void logEvent(Event event){
        cache.add(event);
        System.out.println(cache.toString());
        if (cache.size()==cacheSize){
            writeDataFromCash();
            cache.clear();
        }
    }

    private void writeDataFromCash(){
        for (Event event : cache){
            super.logEvent(event);
        }
    }

    private void destroy(){
        if (!cache.isEmpty()){
            writeDataFromCash();
        }
    }

}
