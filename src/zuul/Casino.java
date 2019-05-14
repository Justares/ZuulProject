package zuul;

import java.util.Scanner;
/**
 * Hier ist die Casino Klasse
 * @author cedric
 *
 */
public class Casino{
	Scanner scanner = new Scanner(System.in);
	/**
	 * Begrüßungs text und abfrage ob man spielen möchte
	 */
	public void begrueßung() {
		
		System.out.println("Willkommen im Casino möchten sie eine runde Spielen?");
		String antwort = scanner.next();
		switch(antwort){
        case "Ja":
            System.out.println("test");
            break;
        case "Yes":
            System.out.println("test");
            break;
        case "J":
            System.out.println("test");
            break;
        case "Y":
            System.out.println("test");
            break;
        default:
            System.out.println("Keine Gültige antwort");
        } 
	}
	/**
	 * Das Blackjack spiel
	 */
	private void Blackjack() {
		
	}
	
}
