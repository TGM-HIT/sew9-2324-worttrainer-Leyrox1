package project;

/**
 * The word, which has a url linked to it that represents the word
 * @author Luka Condric
 * @version 2023-10-18
 */
public class Wort {
    private String wort;
    private String url;

    /**
     * Creates a new Wort object
     * @param word the word
     * @param url the url
     */
    public Wort(String word, String url) {
        this.setWort(word);
        this.setUrl(url);
    }

    /**
     * Returns the word
     * @return the word
     */
    public String getWort() {
        return wort;
    }

    /**
     * Sets the word if it is valid
     * @param wort the word to set
     */
    public void setWort(String wort) {
        if(checkWord(wort)) {
            this.wort = wort;
        } else {
            throw new IllegalArgumentException("Ungültiges Wort!");
        }
    }

    /**
     * Returns the url
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url if it is valid
     * @param url the url to set
     */
    public void setUrl(String url) {
            this.url = url ;
    }

    /**
     * Checks the word if it is valid
     * @param wort the word to check
     * @return false, if word is invalid, true otherwise
     */
    public boolean checkWord(String wort) {
        return wort != null && !wort.isEmpty();
    }
}