package village_gaulois;

import objets.Trophee;
import objets.Equipement;
import personnages.Gaulois;

public class Musee {

	// Attributs
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;

	// Méthode donnerTrophees
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {

		if (nbTrophee < 200) {
			trophees[nbTrophee] = new Trophee(gaulois, equipement);
			nbTrophee++;
		}
	}
	
	public String extraireInstructionsOCaml() {
	    String resultat = "let musee = [\n";

	    for (int i = 0; i < nbTrophee; i++) {
	        Trophee t = trophees[i];
	        if (t != null) {
	            resultat += "\"" + t.donnerNom() + "\", \"" 
	                      + t.getEquipement().toString().toLowerCase() + "\"";

	            if (i < nbTrophee - 1) {
	                resultat += ";\n";
	            }
	        }
	    }

	    resultat += "\n]";
	    return resultat;
	}
}
