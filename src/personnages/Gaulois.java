package personnages;

public class Gaulois {
	
	// Attributs 
	public String nom;
	private Integer force;
	private Integer effetPotion = 1;
	
	
	// Contructeur de Gaulois 
	public Gaulois(String nom, int force) {
		
		this.nom = nom;
		this.force = force;
	}
	

	
	// Méthode avoir le nom
	public String getNom() {
		return nom;
	}
	// Méthode parler
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	// Méthode prendre parole
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	// Print de l'objet astgerix
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
	
	
	
	
	
		
	
}
