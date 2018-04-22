package by.bntu.fitr.povt.prostrmk.model;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {

    private int id;
    private String msg;
    private Date date;

    private DateFormat dateFormat;



    public Event(String msg, Date date, DateFormat dateFormat){
        this.date = date;
        this.dateFormat = dateFormat;
        this.msg = msg;
        id = new Random().nextInt(100);
    }

    public Event(Date date, DateFormat dateFormat){
        this.date = date;
        this.dateFormat = dateFormat;
        id = new Random().nextInt(100);
    }

    public Event(int id, String msg, Date date, DateFormat dateFormat) {
        this.id = id;
        this.msg = msg;
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public static boolean isDay(){
        Date date = new Date();
        return date.getHours() > 8 && date.getHours() < 17;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Event{")
                .append("\n\t id=").append(id)
                .append("\n\t msg=").append(msg)
                .append("\n\t date=").append(dateFormat.format(date))
                .append("\n}").toString();
    }
}
