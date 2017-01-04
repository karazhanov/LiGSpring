package ua.com.lig.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author karazhanov on 04.01.17.
 */
public class Event {

    private final static Random random = new Random();

    private int id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        id = Math.abs(random.nextInt());
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                '}';
    }
}
