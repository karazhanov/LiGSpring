package ua.com.lig.spring.testing;

/**
 * @author karazhanov on 04.01.17.
 */
public class Client {

    private String id;
    private String fullName;

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
