import project.Wort;
import project.Worttrainer;
import project.LoadAndSave;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the function of the LoadAndSave class
 * @author Luka Condric
 * @version 2023-10-18
 */
public class Speicherntest {
    @DisplayName ("Tests if the Worttrainer is loaded correctly")
    @Test
    public void testLoad() throws IOException {
        Worttrainer trainer = new Worttrainer();
        LoadAndSave loadandsave = new LoadAndSave();
        trainer = loadandsave.load("Worttrainer.txt");
        assertEquals("Dog", trainer.getWortpaar(0).getWort());
        assertEquals("https://www.hindustantimes.com/ht-img/img/2023/08/25/1600x900/international_dog_day_1692974397743_1692974414085.jpg", trainer.getWortpaar(0).getUrl());
        assertEquals(14, trainer.getRichtig());
        assertEquals(7, trainer.getFalsch());
    }

    @DisplayName("Tests if the Worttrainer is saved correctly")
    @Test
    public void testSave() throws IOException {
        Worttrainer trainer1 = new Worttrainer();
        Wort wort1= new Wort("Dog", "https://www.hindustantimes.com/ht-img/img/2023/08/25/1600x900/international_dog_day_1692974397743_1692974414085.jpg");
        trainer1.addWort(wort1);
        trainer1.setRichtig(14);
        trainer1.setFalsch(7);
        LoadAndSave ws= new LoadAndSave();
        assertDoesNotThrow(()-> ws.save("Worttrainer.txt", trainer1), "Ungültiger Pfad");
        Worttrainer trainer2 = ws.load("Worttrainer.txt");
        assertEquals(trainer1.getWortpaar(0).getWort(), trainer2.getWortpaar(0).getWort());
        assertEquals(trainer1.getWortpaar(0).getUrl(), trainer2.getWortpaar(0).getUrl());
        assertEquals(trainer1.getRichtig(), trainer2.getRichtig());
        assertEquals(trainer1.getFalsch(), trainer2.getFalsch()) ;
    }
}