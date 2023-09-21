package model;

public class Wort {
    private String wort;
    private String url;

    public Wort(String wort, String url) {
        this.wort = wort;
        this.url = url;
    }

    public String getWort() {
        return this.wort;
    }

    public String getUrl() {
        return this.url;
    }
}
