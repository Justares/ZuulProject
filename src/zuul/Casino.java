package zuul;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Hier ist die Casino Klasse
 * 
 * @author cedric
 *
 */
public class Casino {
	Spieler sp = new Spieler();
	Scanner scanner = new Scanner(System.in);
	ArrayList<String> npc = new ArrayList<>();
	int npcKartenWert = 0;
	ArrayList<String> player = new ArrayList<>();
	int playerKartenWert = 0;
	int endgueltigerEinsatz;
	int abzug;
	boolean schleifeBeg = true;
	String antwort;
	boolean startLoop = true;
	int einsatz;
	HashMap<String,Integer> spielKarten = new HashMap();
	Object randomNamePLAYER;
	Object randomNameNPC;
	boolean schleifeGame = false;

	/**
	 * Begrüßungs text und abfrage ob man spielen möchte
	 */
	public void begrueßung() {

		while (schleifeBeg) {
			System.out.println("Willkommen im Casino möchten sie eine runde Spielen?");
			antwort = scanner.next();
			switch (antwort) {
			case "Ja":
				this.Blackjack();
				schleifeBeg =  false;
				break;
			case "Yes":
				this.Blackjack();
				schleifeBeg =  false;
				break;
			case "J":
				this.Blackjack();
				schleifeBeg =  false;
				break;
			case "Y":
				this.Blackjack();
				schleifeBeg =  false;
				break;
			case "ja":
				this.Blackjack();
				schleifeBeg =  false;
				break;
			case "yes":
				this.Blackjack();
				schleifeBeg =  false;
				break;
			case "j":
				this.Blackjack();
				schleifeBeg =  false;
				break;
			case "y":
				this.Blackjack();
				schleifeBeg =  false;
				break;
			default:
				System.out.println("Keine Gültige antwort");
			}
		}
	}

	/**
	 * Das Blackjack spiel
	 */
	private void Blackjack() {
		System.out.println("Wie viel möchten sie einsetzen ? 5,10,20");



		while (startLoop) {
			einsatz = scanner.nextInt();
			if (einsatz >= sp.getCoins()) {
				System.out.println("Du besitzt leider nicht genug Münzen komme später wieder");
			}else {
				abzug = sp.getCoins() - einsatz;
				switch (einsatz) {
				case 5:
					startLoop = false;
					sp.setCoins(abzug);
					endgueltigerEinsatz = einsatz;
					break;
				case 10:
					startLoop = false;
					sp.setCoins(- einsatz);
					endgueltigerEinsatz = einsatz;
					break;
				case 20:
					startLoop = false;
					sp.setCoins(- einsatz);
					endgueltigerEinsatz = einsatz;
					break;
				default:
					System.out.println("Das ist kein Gültiger einsatz bitte versuchen sie es erneut Gültig sind 5,10,20");
				}


				/**
				 * gdas Kartendeck
				 * @return spielKarten
				 */
				spielKarten.put("Herz König", 10);
				spielKarten.put("Pik König", 10);
				spielKarten.put("Karo König", 10);
				spielKarten.put("Kreuz König", 10);
				spielKarten.put("Herz Dame", 10);
				spielKarten.put("Pik Dame", 10);
				spielKarten.put("Karo Dame", 10);
				spielKarten.put("Kreuz Dame", 10);
				spielKarten.put("Herz Bube", 10);
				spielKarten.put("Pik Bube", 10);
				spielKarten.put("Karo Bube", 10);
				spielKarten.put("Kreuz Bube", 10);
				spielKarten.put("Herz 2", 2);
				spielKarten.put("Pik 2", 2);
				spielKarten.put("Karo 2", 2);
				spielKarten.put("Kreuz 2", 2);
				spielKarten.put("Herz 3", 3);
				spielKarten.put("Pik 3", 3);
				spielKarten.put("Karo 3", 3);
				spielKarten.put("Kreuz 3", 3);
				spielKarten.put("Herz 4", 4);
				spielKarten.put("Pik 4", 4);
				spielKarten.put("Karo 4", 4);
				spielKarten.put("Kreuz 4", 4);
				spielKarten.put("Herz Ass", 0);
				spielKarten.put("Pik Ass", 0);
				spielKarten.put("Karo Ass", 0);
				spielKarten.put("Kreuz Ass", 0);

				System.out.println("\n\n");

				for(int i = 0;i<2; i++) {
					npcKarte(); 
				}

				System.out.println(npcAusgabe()+"\n");
				for(int i = 0;i<2; i++) {
					playerKarte();
				}
				System.out.println(playerAusgabe());

				if(playerKartenWert <= npcKartenWert ) {
					System.out.println("\n Möchten sie noch eine Ziehen? (Ja,Nein)");
					antwort = scanner.next();
					while(schleifeGame == false) {
						if(npcKartenWert != playerKartenWert){
							if(antwort.toString().equalsIgnoreCase("Ja")) {
								playerKarte();
								System.out.println(playerAusgabe());
								schleifeGame = true;
							}else if(antwort.toString().equalsIgnoreCase("Nein")) {
								if(npcKartenWert <= 19) {
									npcKarte();
									System.out.println(npcAusgabe());
									schleifeGame = true;
								} 	
							}
						}else {
							endgueltigerEinsatz = endgueltigerEinsatz / 2;
							endgueltigerEinsatz = sp.getCoins() + endgueltigerEinsatz;
							sp.setCoins(endgueltigerEinsatz);
						}
					}
				}else {
					while(npcKartenWert < playerKartenWert) {
					if(npcKartenWert <= 19) {
						npcKarte();
						System.out.println(npcAusgabe());
					}
					System.out.println(playerAusgabe());
				}
				}

			}
		}
	}
	/**
	 * zieht eine Karte für den spieler aus
	 * @return playerKarte()
	 */
	private void playerKarte() {
		randomNamePLAYER = spielKarten.keySet().toArray()[new Random().nextInt(spielKarten.keySet().toArray().length)];
		player.add(randomNamePLAYER.toString());

		if(npc.contains("Kreuz Ass")) {
			if(playerKartenWert <= 11) { spielKarten.put("Kreuz Ass", 10);}else {spielKarten.put("Kreuz Ass", 1);}
		}else if(npc.contains("Karo Ass")) {
			if(playerKartenWert <= 11) { spielKarten.put("Karo Ass", 10);}else {spielKarten.put("Karo Ass", 1);}
		}else if(npc.contains("Pik Ass")) {
			if(playerKartenWert <= 11) { spielKarten.put("Pik Ass", 10);}else {spielKarten.put("Pik Ass", 1);}
		}else if(npc.contains("Herz Ass")) {
			if(playerKartenWert <= 11) { spielKarten.put("Herz Ass", 10);}else {spielKarten.put("Herz Ass", 1);}
		}
		playerKartenWert = playerKartenWert + spielKarten.get(randomNamePLAYER);


	}
	/**
	 * Zieht eine Karte für den NPC
	 * @return npcKarte()
	 */
	private void npcKarte() {
		randomNameNPC = spielKarten.keySet().toArray()[new Random().nextInt(spielKarten.keySet().toArray().length)];
		npc.add(randomNameNPC.toString());

		if(npc.contains("Kreuz Ass")) {
			if(npcKartenWert <= 11) { spielKarten.put("Kreuz Ass", 10);}else {spielKarten.put("Kreuz Ass", 1);}
		}else if(npc.contains("Karo Ass")) {
			if(npcKartenWert <= 11) { spielKarten.put("Karo Ass", 10);}else {spielKarten.put("Karo Ass", 1);}
		}else if(npc.contains("Pik Ass")) {
			if(npcKartenWert <= 11) { spielKarten.put("Pik Ass", 10);}else {spielKarten.put("Pik Ass", 1);}
		}else if(npc.contains("Herz Ass")) {
			if(npcKartenWert <= 11) { spielKarten.put("Herz Ass", 10);}else {spielKarten.put("Herz Ass", 1);}
		}
		npcKartenWert = npcKartenWert + spielKarten.get(randomNameNPC);

	}
	/**
	 * gibt die karten des Npc aus
	 * @return npcAusgabe()
	 */
	private String npcAusgabe() {
		return "\nDer NPC besitz die Karten " + npc.toString() + "\nder Wert der Karten des NPC's beträgt = " + npcKartenWert;

	};
	/**
	 * gibt die karten des Spielers aus
	 * @return playerAusgabe()
	 */
	private String playerAusgabe() {
		return "Du besitz die Karten " + player.toString() + "\nder Wert deiner Karten beträgt = " + playerKartenWert;
	};
}
