package personnages;

public class Chaudron {

	// Attributs qui sont en privées ( "-" ) 
    private Integer quantitePotion;
    private Integer forcePotion;

    // Méthode remplirChaudron
    public void remplirChaudron(Integer quantite, Integer forcePotion) {
    	this.quantitePotion = quantite;
        this.forcePotion = forcePotion;
    }

    // Méthode retePotion 
    public Boolean restePotion() {
    	return quantitePotion > 0;
    }

    // Méthode prendreLouche 
    public Integer prendreLouche() {
    	if (restePotion()) {
            quantitePotion--;
            return forcePotion;
        }
        return 0;
    }
}
