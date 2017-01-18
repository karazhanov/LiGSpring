package ua.com.lig.spring.storage.entity;

import java.util.Date;

/**
 * @author karazhanov on 17.01.17.
 */
public class UserMessages {
    private int id;
    private int userIdFrom;
    private int userIdTo;
    private Date sendedOn;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(int userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    public int getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(int userIdTo) {
        this.userIdTo = userIdTo;
    }

    public Date getSendedOn() {
        return sendedOn;
    }

    public void setSendedOn(Date sendedOn) {
        this.sendedOn = sendedOn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
