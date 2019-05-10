package zuul;

public class zuulCoin extends Gegenstand{

    private int menge;

    public zuulCoin(String name, String beschreibung, int gewicht, int menge) {

        super(name, beschreibung, gewicht);
        this.menge=menge;
    }

    public int getBonus() {
        return this.menge;
    }
}
