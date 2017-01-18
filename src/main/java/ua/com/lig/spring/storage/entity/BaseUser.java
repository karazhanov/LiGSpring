package ua.com.lig.spring.storage.entity;

import java.util.Date;

/**
 * @author karazhanov on 17.01.17.
 */
public class BaseUser {
    private int id;
    private String name;
    private String last_name;
    private String nickname;
    private String middle_name;
    private Date birthday;
    private boolean sexMale;
    private Date registredOn;
    private String avatarUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSexMale() {
        return sexMale;
    }

    public void setSexMale(boolean sexMale) {
        this.sexMale = sexMale;
    }

    public Date getRegistredOn() {
        return registredOn;
    }

    public void setRegistredOn(Date registredOn) {
        this.registredOn = registredOn;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
