import java.util.Random;
public class Worttrainer {
    private int richtig;
    private int falsch;
    private Random random;
    private Wort[] woerter;
    private Wort aktWort;

    public Worttrainer() {
        this.richtig = 0;
        this.falsch = 0;
        generator();
        auswahl();
    }

    public int getRichtig() {
        return richtig;
    }

    public int getFalsch() {
        return falsch;
    }
    public Wort getAktWort() {
        return aktWort;
    }
    public Wort[] getWoerter() {
        return woerter;
    }
    public void auswahl() {
        aktWort = woerter[random.nextInt(10)];
    }

    public boolean check(String wort) {
        if(wort.equals(aktWort.getWort())) {
            richtig++;
            auswahl();
            return true;
        }
        falsch++;
        return false;
    }
    private void generator() {
            woerter[0] = new Wort("Dog", "https://www.hindustantimes.com/ht-img/img/2023/08/25/1600x900/international_dog_day_1692974397743_1692974414085.jpg");
            woerter[1] = new Wort("Cat", "https://www.thesprucepets.com/thmb/uQnGtOt9VQiML2oG2YzAmPErrHo=/5441x0/filters:no_upscale():strip_icc()/all-about-tabby-cats-552489-hero-a23a9118af8c477b914a0a1570d4f787.jpg");
            woerter[2] = new Wort("Jellyfish", "https://niwa.co.nz/sites/niwa.co.nz/files/images/teasers/Jiggling-jellyfish-tile.jpg");
            woerter[3] = new Wort("Whale", "https://scitechdaily.com/images/Young-Humpback-Whale.jpg");
            woerter[4] = new Wort("Lion", "https://cdn.britannica.com/29/150929-050-547070A1/lion-Kenya-Masai-Mara-National-Reserve.jpg");
            woerter[5] = new Wort("Tiger", "https://upload.wikimedia.org/wikipedia/commons/b/b0/Bengal_tiger_%28Panthera_tigris_tigris%29_female_3_crop.jpg");
            woerter[6] = new Wort("Penguin", "data:image/jpeg;base64,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");
            woerter[7] = new Wort("Giraffe", "https://image.geo.de/30042236/t/3X/v3/w2048/r0/-/giraffe-gross-jpg--17137-.jpg");
            woerter[8] = new Wort("Horse", "https://www.horsedeal24.com/page/wp-content/uploads/2021/11/american-quarter-horse-pferderasse.jpg");
            woerter[9] = new Wort("Coala", "data:image/jpeg;base64,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");
    }
}