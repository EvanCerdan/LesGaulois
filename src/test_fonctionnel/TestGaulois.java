package test_fonctionnel;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;


public class TestGaulois {

	// Méthode Main
	public static void main(String[] args) {
		
		// Attibuts Asterix & Obelix
		Gaulois asterix = new Gaulois("Astérix", 8);
        Gaulois obelix = new Gaulois("Obélix", 16);
        
        // Attribut minus
        Romain minus = new Romain("Minus", 6);
        
        
        // Attribut panoramix
        Druide panoramix = new Druide("Panoramix", 2);
        
        Romain brutus = new Romain("Brutus", 14);
        
        panoramix.fabriquerPotion(4, 3);
        panoramix.booster(obelix);
        panoramix.booster(asterix);
        
        // Boucle de 3 avec 3 appels de la méthode frapper sur minus 
        for (int i = 0; i < 3; i++) {
			asterix.frapper(brutus);
        }

	}


}
