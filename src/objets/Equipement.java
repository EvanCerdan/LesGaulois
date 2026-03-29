package objets;

public enum Equipement {
    CASQUE("casque"),
    BOUCLIER("bouclier");

	// Attribut 
    private String nom;

    // Constructeur d'équipement
    private Equipement(String nom) {
        this.nom = nom;
    }

    // Méthodes :
    
    // Méthode toString
    @Override
    public String toString() {
        return nom;
    }
}