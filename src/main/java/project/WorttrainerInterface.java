package project;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * The interface for the Worttrainer, which contains the load and save methods for the Worttrainer
 * @author Luka Condric
 * @version 2023-10-18
 */
public interface WorttrainerInterface {
    Worttrainer load(String pfad) throws IOException;
    void save(String pfad, Worttrainer trainer) throws IOException;

}
