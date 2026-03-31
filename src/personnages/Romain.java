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

	// Méthode pour parler
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	// Méthode pour prendre la parole 
	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}
	
	// Méthode pour recevoir un coup
	/* public void recevoirCoup(int forceCoup) {
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
	*/
	
	// Méthode privée d'Invariant
	private boolean isInvariantVerified() {
	    return force >= 0;
	}
	
	// méthode rajoutée
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
	
	// méthode recevoirCoup 
	public Equipement[] recevoirCoup(int forceCoup) {
	    Equipement[] equipementEjecte = null;

	    forceCoup = calculResistanceEquipement(forceCoup);
	    
	    if (forceCoup < 0) {
	        forceCoup = 0;
	    }

	    force -= forceCoup;

	    if (force <= 0) {
	        force = 0;
	        parler("J'abandonne...");
	        equipementEjecte = ejecterEquipement();
	    } else {
	        parler("Aïe");
	    }

	    return equipementEjecte;
	}

	
	 // Calcul résistance 
	 private int calculResistanceEquipement(int forceCoup) {
		    String texte = "Ma force est de " + this.force +
		            ", et la force du coup est de " + forceCoup;

		    int resistanceEquipement = 0;

		    if (nbEquipements != 0) {
		        texte += "\nMais heureusement, grâce à mon équipement sa force est diminuée de ";

		        for (int i = 0; i < nbEquipements; i++) {
		            if (equipements[i] == Equipement.BOUCLIER) {
		                resistanceEquipement += 6;
		            } else {
		                resistanceEquipement += 3;
		            }
		        }

		        texte += resistanceEquipement + "!";
		    }

		    parler(texte);

		    int resultat = forceCoup - resistanceEquipement;

		    if (resultat < 0) {
		        resultat = 0;
		    }

		    return resultat;
		}

	    // Ejecter équipement
	    private Equipement[] ejecterEquipement() {
	        Equipement[] equipementEjecte = new Equipement[nbEquipements];

	        System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

	        int nbEquipementEjecte = 0;

	        for (int i = 0; i < nbEquipements; i++) {
	            if (equipements[i] != null) {
	                equipementEjecte[nbEquipementEjecte++] = equipements[i];
	                equipements[i] = null;
	            }
	        }

	        nbEquipements = 0;

	        return equipementEjecte;
	    }
	
	
	// Main
	public static void main(String[] args) {
	    Romain minus = new Romain("Minus", 6);
	    
	    Romain r1 = new Romain("Minus", 10);
	    //r1.recevoirCoup(-5); // erreur pour forcecoup négative
	    
	    System.out.println(Equipement.CASQUE);
	    System.out.println(Equipement.BOUCLIER);
	     
	}

	// Getters
    public String getNom() {
        return nom;
    }

    public int getForce() {
        return force;
    }

    // Setters 
    public void setForce(int force) {
        this.force = force;
    }
}
