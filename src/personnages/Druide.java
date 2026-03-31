package personnages;

public class Druide {

	// Attributs 
    private String nom;
    private Integer force;
    private Chaudron chaudron;
    

    // Constructeur de Druide 
    public Druide(String nom, Integer force) {
        this.nom = nom;
        this.force = force;
        this.chaudron = new Chaudron();
    }

    // Méthodes 
    
    // Méthode parler 
    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    // Méthode privée prendreParole (- sur diagramme) 
    private String prendreParole() {
    	return "Le Druide " + nom + " : ";
    }

    // Méthode fabriquerPotion
    public void fabriquerPotion(Integer quantite, Integer forcePotion) {
    	chaudron.remplirChaudron(quantite, forcePotion);
        parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
    }

    // Méthode booster
    public void booster(Gaulois gaulois) {
        if (chaudron.restePotion()) {
            if (gaulois.getNom().equals("Obélix")) {
                parler("Non, Obélix ! Non !... Et tu le sais très bien !");
            } else {
                parler("Tiens " + gaulois.getNom() + ", un peu de potion magique.");
                gaulois.boirePotion(chaudron.prendreLouche());
            }
        } else {
            parler("Désolé " + gaulois.getNom() + ", il n'y a plus de potion !");
        }
    }
}


