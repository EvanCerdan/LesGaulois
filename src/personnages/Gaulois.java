package personnages;

import village_gaulois.Village;
import objets.Equipement;

public class Gaulois {
	
	// Attributs 
	private String nom;
	private int effetPotion = 1;
	private Village village;
	// attributs rajoutés
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	
	// Contructeur de Gaulois 
	public Gaulois(String nom, int force) {
		
		this.nom = nom;
		this.force = force;
	}
	
	// Setters village
	public void setVillage(Village village) {
	    this.village = village;
	}

	
	// Méthodes 
	
	// Méthode getNom
	public String getNom() {
		return nom;
	}
	// Méthode parler
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	// Méthode prendreParole
	/* private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}  
	*/
	
	
	// Print de l'objet asterix
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}

	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", effetPotion=" + effetPotion + ", force=" + force + "]";
	}
	
	
	// Méthode frapper un romain 
	/*
	public void frapper(Romain romain) {
	    int forceCoup = (force * effetPotion) / 3;

	    System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());

	    romain.recevoirCoup(forceCoup);

	    if (effetPotion > 1) {
	        effetPotion--;
	    }
	} 
	*/
	
	// Méthode boirePotion
	public void boirePotion(Integer forcePotion) {
	    effetPotion = forcePotion;
	}
	


	// Méthode sePrésenter
	public void sePresenter() {
	    System.out.print("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ". ");

	    // Cas 1 : sans village
	    if (village == null) {
	        System.out.println("Je voyage de villages en villages.\"");
	    }
	    // Cas 2 : chef du village
	    else if (village.getChef() == this) {
	        System.out.println("Je suis le chef du village : " + village.getNom() + ".\"");
	    }
	    // Cas 3 : habitant normal
	    else {
	        System.out.println("J'habite le village : " + village.getNom() + ".\"");
	    }
	}
	
	// méthodoe rajoutée (TP3)
	private String prendreParole() {
	    return "Le gaulois " + nom + " : ";
	}
	
	// méthode rajoutée (TP3)	
	public void frapper(Romain romain) {
	    System.out.println(nom + " envoie un grand coup dans la mâchoire de "
	            + romain.getNom());

	    Equipement[] tropheesGagnes = romain.recevoirCoup((force / 3) * effetPotion);

	    effetPotion--;

	    if (effetPotion < 1) {
	        effetPotion = 1;
	    }

	    if (tropheesGagnes != null) {
	        for (int i = 0; i < tropheesGagnes.length; i++) {
	            this.trophees[nbTrophees] = tropheesGagnes[i];
	            nbTrophees++;
	        }
	    }
	}
	
	
	
		
	
}
