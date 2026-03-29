package village_gaulois;

import personnages.Gaulois;

public class Village {
	
    // Define
	public static final int NB_VILLAGEOIS_MAX = 30;

	// Attributs
    private String nom;
    private int nbVillageois = 0;
    private Gaulois chef;
    private Gaulois[] villageois;
    
    // Constructeurs 
    
 	// Contructeur de village
 	public Village(String nom, Gaulois chef) {
 		this.nom = nom;
 		this.chef = chef;
        this.villageois = new Gaulois[NB_VILLAGEOIS_MAX]; // A enelever pour voir ERR
        this.chef.setVillage(this);

 	}
	
	// Méthodes 
	
	// ajouterVillageois
	public void ajouterVillageois(Gaulois gaulois) {
		// Faut pas dépasser le nb de villageois max
	    if (nbVillageois < NB_VILLAGEOIS_MAX) {
	        villageois[nbVillageois] = gaulois;
	        nbVillageois++;
	        // J'ajoute ce gaulois au village 
	        gaulois.setVillage(this);
	    }
	}
	
	// trouverVillageois
	public Gaulois trouverVillageois(int numVillageois) {
		// Il faut que le numéro soit entre 1 et 30 
	    if (numVillageois > 0 && numVillageois <= NB_VILLAGEOIS_MAX) {
	    	// Je retourne sa valeur -1 car on est de i = 0 à i = 29
	        return villageois[numVillageois - 1];
	    } else {
	    	// Sinon il n'est pas dans le village
	        System.out.println("Il n’y a pas autant d’habitants dans notre village !");
	        return null;
	    }
	}

	
	// afficherVillageois
	public void afficherVillageois() {
		// Si y'a pas de chef
	    if (chef == null) {
	    	// Affichage pas de villageois 
	        System.out.println("Le village n'a pas de chef !");
	        return;
	    }
	    // Affichage du nom du chef
	    System.out.println("Dans le village \"" + nom + "\" du chef " + chef.getNom());
	    System.out.println("vivent les légendaires gaulois :");

	    // Si y'a bien des villageois
	    if (villageois != null) {
	    	// Boucle en fonction du nombre de villageois et on les affichent
	        for (int i = 0; i < villageois.length; i++) {
	            if (villageois[i] != null) {
	                System.out.println("- " + villageois[i].getNom());
	            }
	        }
	    }
	}

	// main
	public static void main(String[] args) {
	    // Création du chef Abraracourcix
	    Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);

	    // Création du village
	    Village village = new Village("Village des Irréductibles", abraracourcix);

	    // Test sans erreur
	    village.trouverVillageois(30);

	    // Création d'Astérix et ajout au village
	    Gaulois asterix = new Gaulois("Astérix", 8);
	    village.ajouterVillageois(asterix);

	    // Création d'Obélix et ajout au village
	    Gaulois obelix = new Gaulois("Obélix", 25);
	    village.ajouterVillageois(obelix);

	    // Affichage des villageois
	    village.afficherVillageois();

	    // Création de Doublepolémix (sans village)
	    Gaulois doublePolemix = new Gaulois("Doublepolémix", 4);

	    // Présentation
	    abraracourcix.sePresenter();
	    asterix.sePresenter();
	    doublePolemix.sePresenter();
	}
	
	
    // Getters 
    public String getNom() {
		return this.nom;
	}
    
    public Gaulois getChef() {
		return this.chef;
	}
    
	// Setters
	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setChef(Gaulois chef) {
		this.chef = chef;
	}
}
    
    