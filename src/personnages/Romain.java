package personnages;

public class Romain {
	
	// Attributs 
	private String nom;
	private int force;
	
	// Constructeur de Romain
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
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
		// Un romain perd de la force après un coup
		force = force - forceCoup;
		
		if (force < 1) {
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}
	}

}
