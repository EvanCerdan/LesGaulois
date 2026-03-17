package personnages;

import village_gaulois.Village;

public class Gaulois {
	
	// Attributs 
	public String nom;
	private Integer force;
	private Integer effetPotion = 1;
	private Village village;
	
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
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	// Print de l'objet asterix
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}

	// Méthode de réecriture du toString dans la classe 
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + "]";
	}
	
	// Méthode frapper un romain 
	public void frapper(Romain romain) {
	    int forceCoup = (force * effetPotion) / 3;

	    System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());

	    romain.recevoirCoup(forceCoup);

	    if (effetPotion > 1) {
	        effetPotion--;
	    }
	}
	
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
	
	
	
	
	
	
		
	
}
