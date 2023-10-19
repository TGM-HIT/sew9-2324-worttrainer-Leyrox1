import project.Wort;
import project.Worttrainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the class Worttrainer and its functionality
 * @author Luka Condric
 * @version 2023-10-19
 */
public class Trainertest  {
    @DisplayName("Tests if the constructor works")
    @Test
    public void testWortAdd() {
        Worttrainer trainer = new Worttrainer();
        assertThrows(IllegalArgumentException.class, () ->{trainer.addWort(null);});
    }

    @DisplayName("Tests if the index of the Wort is valid")
    @Test
    public void testIndexOutsideOfRange() {
        Worttrainer trainer = new Worttrainer();
        Wort wort = new Wort("Dog", "https://www.hindustantimes.com/ht-img/img/2023/08/25/1600x900/international_dog_day_1692974397743_1692974414085.jpg");
        trainer.addWort(wort);
        assertEquals(wort,trainer.getWortpaar(0));
        assertThrows(IllegalArgumentException.class, () -> {trainer.getWortpaar(2);});
    }
    @DisplayName("Tests if the current eingabe can be set correctly")
    @Test
    public void testSetEingabe() {
        Worttrainer trainer = new Worttrainer();
        Wort wort = new Wort("Dog", "https://www.hindustantimes.com/ht-img/img/2023/08/25/1600x900/international_dog_day_1692974397743_1692974414085.jpg");
        trainer.addWort(wort);
        assertThrows(IllegalArgumentException.class, () -> {trainer.setEingabe(null);});
    }

    @DisplayName("Tests the check of the current eingabe")
    @Test
    public void testCheckEingabe() {
        Worttrainer trainer = new Worttrainer();
        Wort wort = new Wort("Dog", "https://www.hindustantimes.com/ht-img/img/2023/08/25/1600x900/international_dog_day_1692974397743_1692974414085.jpg");
        trainer.addWort(wort);
        trainer.setEingabe("Cat");
        assertFalse(trainer.check(trainer.getWortpaar(0)));
        trainer.setEingabe("Dog");
        assertTrue(trainer.check(trainer.getWortpaar(0)));
    }

    @DisplayName("Tests the statistics of the Worttrainer")
    @Test
    public void testStatistics() {
        Worttrainer trainer = new Worttrainer();
        Wort wort = new Wort("Dog", "hhttps://www.hindustantimes.com/ht-img/img/2023/08/25/1600x900/international_dog_day_1692974397743_1692974414085.jpg");
        Wort wort2 = new Wort("Cat","https://www.hindustantimes.com/ht-img/img/2023/08/25/1600x900/international_dog_day_1692974397743_1692974414085.jpg");
        trainer.addWort(wort);
        trainer.addWort(wort2);
        trainer.setEingabe("Whale");
        trainer.check(trainer.getWortpaar(0));
        trainer.setEingabe("Dog");
        trainer.check(trainer.getWortpaar(0));
        trainer.setEingabe("Cat");
        trainer.check(trainer.getWortpaar(1));
        assertEquals(trainer.getFalsch(), 1);
        assertEquals(trainer.getRichtig(),2);
        assertEquals(trainer.getGesamt(),3);
    }
}