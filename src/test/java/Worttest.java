import project.Wort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Tests the class Wort
 * @author Luka Condric
 * @version 2023-10-18
 */
public class Worttest {
    @DisplayName("Tests if the constructor works")
    @Test
    public void testWort(){
        Wort wort= new Wort("wort","https://scitechdaily.com/images/Young-Humpback-Whale.jpg");
        assertThrows(IllegalArgumentException.class, () ->{wort.setWort("");});
        assertThrows(IllegalArgumentException.class, () -> {wort.setWort(null);});
    }
}