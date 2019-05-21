package zuul;

public class ZuulCoin extends Gegenstand{

    private int menge;

    public ZuulCoin(String name, String beschreibung,double gewicht, int menge) {

        super(name, beschreibung, menge);
        this.menge=menge;
    }

    public int getBonus() {
        return this.menge;
    }
} 