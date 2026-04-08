package personnages;

import village_gaulois.Village;
import objets.Equipement;
import village_gaulois.Musee;

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

	// Méthodes

	// Méthode parler
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	// Print de l'objet asterix
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", effetPotion=" + effetPotion + ", force=" + force + "]";
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

	// méthode prendreParole
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	// méthode frapper un Romain
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());

		Equipement[] tropheesGagnes = romain.recevoirCoup((force / 2) * effetPotion);

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

	public void faireUneDonnation(Musee musee) {

	    if (nbTrophees == 0) {
	        return;
	    }

	    parler("Je donne au musée tous mes trophées :");

	    for (int i = 0; i < nbTrophees; i++) {
	    	Equipement equipement = trophees[i];

	        System.out.println("- " + equipement);
	        musee.donnerTrophees(this, equipement);
	    }

	    nbTrophees = 0;
	}

	// Getters & Setters

	// Setters village
	public void setVillage(Village village) {
		this.village = village;
	}

	// Getters nom
	public String getNom() {
		return nom;
	}

}
