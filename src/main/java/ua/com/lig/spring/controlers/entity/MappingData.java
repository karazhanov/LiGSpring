package ua.com.lig.spring.controlers.entity;

import java.util.List;

/**
 * @author karazhanov on 12.01.17.
 */
public class MappingData {
    private String url;
    private String clazz;
    private String method;
    private List<String> params;

    public MappingData(String url, String clazz, String method, List<String> params) {
        this.url = url;
        this.clazz = clazz;
        this.method = method;
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public String getClazz() {
        return clazz;
    }

    public String getMethod() {
        return method;
    }

    public List<String> getParams() {
        return params;
    }
}
