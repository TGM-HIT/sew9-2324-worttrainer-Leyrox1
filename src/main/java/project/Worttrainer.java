package project;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * the Logic behind the Worttrainer, which contains a list of words and the statistics of the user
 * @author Luka Condric
 * @version 2023-10-18
 */
public class Worttrainer {
    private List<Wort> worter;
    private String eingabe;
    private int index = 0;
    private int richtig;
    private int falsch;


    /**
     * Constructor for the Worttrainer
     */
    public Worttrainer() {
        this.worter = new LinkedList<>();
    }

    /**
     * Adds a word to the list of words
     * @param wort the word to add
     */
    public void addWort(Wort wort) {
        if(wort != null) {
            this.worter.add(wort);
        } else {
            throw new IllegalArgumentException("Wort can't be null!");
        }
    }

    /**
     * Gets a word from the list of words
     * @param index of the word to get
     */
    public Wort getWortpaar(int index) {
        if(index <= worter.size() - 1) {
            return this.worter.get(index);
        } else {
            throw new IllegalArgumentException("Invalid index");
        }
    }


    /**
     * Checks if the word is valid
     * @param wort the current word
     * @return true, if the word is valid, false otherwise
     */
    public boolean check(Wort wort) {
        if(this.eingabe.equals(wort.getWort())){
            this.richtig++;
            return true;
        } else {
            this.falsch++;
            return false;
        }
    }
    /**
     * Returns the list of words
     * @return the list of words
     */
    public List<Wort> getList() {
        return this.worter;
    }
    /**
     * Returns the number of correct and incorrect words
     * @return the number of correct and incorrect words
     */
    public int getGesamt() {
        return this.richtig + this.falsch;
    }

    /**
     * Returns the number of correct words
     * @return the number of correct words
     */
    public int getRichtig() {
        return richtig;
    }

    /**
     * Sets the number of correct words
     * @param richtig the number of correct words
     */
    public void setRichtig(int richtig) {
        this.richtig = richtig;
    }

    /**
     * Returns the number of incorrect words
     * @return the number of incorrect words
     */
    public int getFalsch() {
        return falsch;
    }

    /**
     * Sets the number of incorrect words
     * @param falsch the number of incorrect words
     */
    public void setFalsch(int falsch) {
        this.falsch = falsch;
    }

    /**
     * Returns the current input of the user
     * @return current input
     */
    public String getEingabe() {
        return eingabe;
    }

    /**
     * Sets the current input of the user
     * @param eingabe the current input
     */
    public void setEingabe(String eingabe) {
        if (eingabe != null) {
            this.eingabe = eingabe;
        } else {
            throw new IllegalArgumentException("Eingabe can't be null!");
        }
    }

    /**
     * Gibt das aktuell gewählte Wortpaar zurück
     * @return Das aktuell gewählte Wortpaar
     */
    public Wort getWortAkt() {
        return getWortpaar(index);
    }
    /**
     * Gibt die Anzahl der zu übenden Wörter zurück
     * @return Länge der Liste der gespeicherten Wortpaare
     */
    public int getListLength() {
        return this.worter.size();
    }

    /**
     * Liefert ein zufälliges Wortpaar aus der Liste an Wortpaaren
     * @return ein Wortpaar aus der Liste
     */
    public Wort getRandom() {
        Random rand = new Random();
        int min = 0;
        int max = this.worter.size() - 1;
        int rn = rand.nextInt((max - min) + 1) + min;
        this.index = rn;
        return this.worter.get(rn);
    }
}