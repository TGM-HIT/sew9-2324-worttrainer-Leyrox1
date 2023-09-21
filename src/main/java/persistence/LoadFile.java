package persistence;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class LoadFile {
    public boolean rf = false;
    private int richtig;
    private int falsch;
    private String wort;
    private String url;
    public LoadFile() {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("/Users/luka/Desktop/GK_9a.1_WorttrainerReloaded/src/savefiles/statistik.json")) {
            // Parse the JSON file
            Object obj = parser.parse(reader);

            // Cast the parsed object to a JSONObject
            JSONObject jsonObject = (JSONObject) obj;

            // Retrieve data from the loaded JSON
            JSONObject aktWort = (JSONObject) jsonObject.get("aktWort");
            wort = (String) aktWort.get("model.Wort");
            url = (String) aktWort.get("URL");

            JSONArray woerterPool = (JSONArray) jsonObject.get("WoerterPool");
            richtig = (int) jsonObject.get("richtig");
            falsch = (int) jsonObject.get("falsch");

            rf = true;
            // Use the retrieved data
            System.out.println("Aktuelles model.Wort: " + wort);
            System.out.println("URL: " + url);
            System.out.println("Wörterpool: " + woerterPool);
            System.out.println("Anzahl richtig: " + richtig);
            System.out.println("Anzahl falsch: " + falsch);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public boolean getRf() {
        return rf;
    }

    public int getRichtig() {
        return richtig;
    }
    public int getFalsch() {
        return falsch;
    }
    public String getWort() {
        return wort;
    }
    public String getUrl() {
        return url;
    }
}
