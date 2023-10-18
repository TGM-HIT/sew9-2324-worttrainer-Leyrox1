package project;

import java.io.*;
import java.util.Scanner;

/**
 * The class for the Worttrainer, which contains the load and save methods for the Worttrainer
 * @author Luka Condric
 * @version 2023-10-18
 */
public class LoadAndSave implements WorttrainerInterface {
    /**
     * Loads a Worttrainer from a JSON file
     * @param filename The Path to the file
     * @return The loaded Worttrainer
     * @throws IOException If there are Problems when loading the file from disk.
     * @throws IllegalArgumentException If the passed Argument for the path is NULL;
     */
    @Override
    public Worttrainer load(String filename) throws IOException{
        Worttrainer t = new Worttrainer();
        try (Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (s.hasNext() && !(s.hasNextInt())) {
                Wort w = new Wort(s.nextLine(), s.next());
                t.addWort(w);
            }
            int richtigeWorte = s.nextInt();
            int falscheWorte = s.nextInt();
            t.setRichtig(0);
            t.setFalsch(0);
            return t;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Saves a Worttrainer to a JSON file
     * @param filename The Path to the file
     * @param trainer The Worttrainer to save
     * @throws IOException If there are Problems when saving the file to disk.
     */
    @Override
    public void save(String filename, Worttrainer trainer) throws IOException {
        File f = new File(filename);
        PrintWriter outputstream = null;
        try {
            outputstream = new PrintWriter(f);
            for (int i = 0; i < trainer.getList().size(); i++) {
                Wort akt = trainer.getWortpaar(i);
                outputstream.println(akt.getWort());
                outputstream.println(akt.getUrl());
            }
            outputstream.println(trainer.getRichtig());
            outputstream.println(trainer.getFalsch());
            outputstream.println(trainer.getGesamt());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (outputstream != null) {
                outputstream.close();
            }
        }
    }
}