package zuul;

public class ZuulCoin extends Gegenstand{

    private int menge;

    public ZuulCoin(String name, String beschreibung, int gewicht, int menge) {

        super(name, beschreibung, gewicht);
        this.menge=menge;
    }

    public int getBonus() {
        return this.menge;
    }
}
