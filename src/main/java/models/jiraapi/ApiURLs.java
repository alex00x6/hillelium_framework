package models.jiraapi;

/**
 * Created by Storm on 13.12.2016.
 */
public enum ApiURLs {

    LOGIN("/rest/auth/1/session"),
    ISSUE("/rest/base.api/2/issue"),
    SEARCH("/rest/base.api/2/search"), ;

    private String uri;

    ApiURLs(String url) {
        this.uri = url;
    }

    public String getUri() {
        return this.uri;
    }

    public String getUri(String suffix) {
        return this.uri + "/" + suffix;
    }

}
