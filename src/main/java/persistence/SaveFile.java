package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import model.Worttrainer;
public class SaveFile {
    public static void main(String[] args) {
        // Erstelle ein JSON-Objekt für die Statistik
        JSONObject statistik = new JSONObject();

        // Fülle die Statistik mit den gewünschten Daten
        JSONObject aktWort = new JSONObject();
        aktWort.put("model.Wort", "Beispielwort");
        aktWort.put("URL", "http://beispiel-url.com");
        statistik.put("aktWort", aktWort);

        // Hier angenommen, dass du Zugriff auf den Wörter-Pool in der Klasse WortTrainer hast
        Worttrainer wortTrainer = new Worttrainer();
        statistik.put("WoerterPool", wortTrainer.getWoerter());

        statistik.put("richtig", 5); // Anzahl der richtigen Antworten
        statistik.put("falsch", 2); // Anzahl der falschen Antworten

        // Speichere die Statistik in einer Datei
        try (FileWriter file = new FileWriter("/Users/luka/Desktop/GK_9a.1_WorttrainerReloaded/src/savefiles/statistik.json")) {
            file.write(statistik.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Statistik wurde erfolgreich gespeichert.");
    }
}
