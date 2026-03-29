package personnages;
import objets.Equipement;

public class Romain {
	
	// Attributs 
	private String nom;
	private int force;
	
		// tableau équipements qui à deux cases 
	private Equipement[] equipements = new Equipement[2];
		// entier nbEquiements init à 0
	private int nbEquipements = 0;
	
	// Constructeur de Romain
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() : "Force invalide (doit être >= 0)";
	}
	
	// Méthodes 
	
	// Méthode pour avoir le nom 
	public String getNom() {
		return nom;
	}

	// Méthode pour parler
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	// Méthode pour prendre la parole 
	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}
	
	// Méthode pour recevoir un coup
	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0 : "La force du coup doit être positive";
		
		// Sauvegarde de l'ancienne force
	    int ancienneForce = force;
	    
		// Un romain perd de la force après un coup
		force = force - forceCoup;
		
		if (force < 1) {
			force = 0; // éviter la force négative
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
		
		// Postcondition
	    assert force <= ancienneForce : "La force n'a pas diminué";
	    
		// Vérification de l’invariant
	    assert isInvariantVerified() : "Invariant violé : force négative";
	}
	
	// Méthode privée d'Invariant
	private boolean isInvariantVerified() {
	    return force >= 0;
	}
	
	
	public void sEquiper(Equipement equipement) {
		// si nbEquipements == n -> case n :
	    switch (nbEquipements) {

	        case 0:
	            equipements[0] = equipement;
	            nbEquipements++;
	            System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	            return;

	        case 1:
	        	// S'il a déjà, on fait rien
	            if (equipements[0] == equipement) {
	                System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
	                return;
	            }
	            // sinon on l'ajoute
	            equipements[1] = equipement;
	            nbEquipements++;
	            System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	            return;

	        case 2:
	        	// S'il a déjà deux équipements, il est déjà full equipé 
	            System.out.println("Le soldat " + nom + " est déjà bien protégé !");
	            return;
	    }
	}
	
	// Main
	public static void main(String[] args) {
	    Romain minus = new Romain("Minus", 6);
	    
	    Romain r1 = new Romain("Minus", 10);
	    //r1.recevoirCoup(-5); // erreur pour forcecoup négative
	    
	    System.out.println(Equipement.CASQUE);
	    System.out.println(Equipement.BOUCLIER);
	     
	}

}
