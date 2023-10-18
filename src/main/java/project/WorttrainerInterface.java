package project;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * The interface for the Worttrainer, which contains the load and save methods for the Worttrainer
 * @autor Luka Condric
 * @version 2023-10-18
 */
public interface WorttrainerInterface {
    public Logik load(String pfad) throws FileNotFoundException, IOException;
    public void save(String pfad, Worttrainer trainer) throws FileNotFoundException, IOException;

}
