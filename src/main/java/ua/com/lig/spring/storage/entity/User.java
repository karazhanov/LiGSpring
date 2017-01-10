package ua.com.lig.spring.storage.entity;

import javax.persistence.*;
/**
 * @author karazhanov on 10.01.17.
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "increment")
//    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "id", length = 13, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
