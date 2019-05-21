package zuul;

public class WorldGenerator {
    private Raum lichtung, waldstueck, taverne, hexenhaus, dorfplatz, kellerDerTaverne, geheimgang, taverneErsterStock, piratenHoehle,casinoHoehle;

    public WorldGenerator() {
        this.raeumeAnlegen();
        this.setzeAusgaenge();
        this.addGegenstaende();
        
    }

    private void raeumeAnlegen() {
        lichtung = new Raum("auf einer Lichtung, umgeben von dunklen Tannen");
        waldstueck = new Raum("im dunklen Wald");
        taverne = new Raum("in der Taverne, mit zwielichten Gestalten an der Theke");
        hexenhaus = new Raum("im Hexenhaus");
        dorfplatz = new Raum("auf dem Dorfplatz");
        piratenHoehle = new Raum("in einer alten Piratenh�hle");
        kellerDerTaverne = new Raum("im Keller der Taverne");
        geheimgang = new Raum("in einem schmalen modrigen Geheimgang");
        taverneErsterStock=new Raum("bei den den G�stezimmern im ersten Stock der Taverne");
        casinoHoehle=new Raum("in der Casinohöhle. Herzlich Willkommen haben sie auch genug ZuulCoins mit?"); //Später noch bekleidung einfügen
        
    }

    private void setzeAusgaenge() {

        // die Ausg�nge initialisieren
        lichtung.setAusgang("down", piratenHoehle);
        lichtung.setAusgang("east", waldstueck);
        lichtung.setAusgang("up", casinoHoehle);
        waldstueck.setAusgang("west", lichtung);
        waldstueck.setAusgang("south", dorfplatz);
        dorfplatz.setAusgang("west", hexenhaus);
        dorfplatz.setAusgang("north", waldstueck);
        dorfplatz.setAusgang("south", taverne);
        dorfplatz.setAusgang("down", casinoHoehle);
        hexenhaus.setAusgang("east", dorfplatz);
        taverne.setAusgang("north", dorfplatz);
        taverne.setAusgang("up", taverneErsterStock);
        taverne.setAusgang("down", kellerDerTaverne);
        taverneErsterStock.setAusgang("down", taverne);
        taverneErsterStock.setAusgang("window", dorfplatz);
        kellerDerTaverne.setAusgang("up", taverne);
        kellerDerTaverne.setAusgang("north", geheimgang);
        geheimgang.setAusgang("south", kellerDerTaverne);
        geheimgang.setAusgang("east", piratenHoehle);
        piratenHoehle.setAusgang("west", geheimgang);
        piratenHoehle.setAusgang("up", lichtung);
        casinoHoehle.setAusgang("down", lichtung);
        casinoHoehle.setAusgang("up", dorfplatz);

    }

/** 
 * 
 * 
 * Gegenstand wird erstellt und in der Welt abgelegt.
 */
    private void addGegenstaende() {
        taverne.gegenstandAblegen(new Gegenstand("Bierkrug", "ein leckeres dunkles Pils in einem edlen Krug", 2));
        taverne.gegenstandAblegen(new Gegenstand("Teller", "ein Teller mit deftigem Wildschweinfleisch mit Soße", 5 ));
        piratenHoehle.gegenstandAblegen(new Gegenstand("Schatztruhe", "eine mit Golf gefüllte Holzkiste", 40));
        piratenHoehle.gegenstandAblegen(new Gegenstand("Schwert", "das Schwert des alten Piratenkapitäns", 10));
        waldstueck.gegenstandAblegen(new Essen("Pilz", "ein seltsam aussehender Pilz", 1, 20));
        lichtung.gegenstandAblegen(new Gegenstand("Korb", "ein Weidenkorb gefüllt mit Brot", 4));
        lichtung.gegenstandAblegen(new Essen("Muffin", "lecker lecker", 1, 5));
        taverne.gegenstandAblegen(new ZuulCoin("Start Coin","Gl�nzt ein bisschen", 10, 0.7));
    }

    public Raum getStartRaum() {
        return this.lichtung;
    }


}
