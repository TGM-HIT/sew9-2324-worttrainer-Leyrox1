import project.Wort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the class Wort
 * @author Luka Condric
 * @version 2023-10-18
 */
public class WortpaarTest {
    @DisplayName("Tests if the constructor works")
    @Test
    public void testWort(){
        Wort wort= new Wort("wort","https://scitechdaily.com/images/Young-Humpback-Whale.jpg");
        assertThrows(IllegalArgumentException.class, () ->{wort.setWort("");});
        assertThrows(IllegalArgumentException.class, () -> {wort.setWort(null);});
    }

    @DisplayName("Testen ob ungültige URL erkannt wird")
    @Test
    public void testUrl() {
        Wortpaar wp= new Wortpaar("wort", "https://www.tgm.ac.at/");
        assertThrows(IllegalArgumentException.class, () ->{wp.setUrl("");});
        assertThrows(IllegalArgumentException.class, () -> {wp.setUrl(null);});
        assertThrows(IllegalArgumentException.class, () -> {wp.setUrl("Url");});
    }
    @DisplayName("Testen ob check eines un/gültigen URL funktioniert")
    @Test
    public void testWordValidierung() {
        Wortpaar wp= new Wortpaar("wort", "https://www.tgm.ac.at/");
        assertTrue(wp.checkWord("Auto"));
        assertFalse(wp.checkWord(""));
        assertFalse(wp.checkWord(null));
    }

    @DisplayName("Testen ob check einer un/gültigen URL funktioniert")
    @Test
    public void testUrlValidierung() {
        Wortpaar wp= new Wortpaar("wort", "https://www.tgm.ac.at/");
        assertTrue(wp.checkURL("https://www.wienerlinien.at/"));
        assertFalse(wp.checkURL("wefgshdjkghljk"));
        assertFalse(wp.checkURL(null));
    }
}