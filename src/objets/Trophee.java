package objets;

import personnages.Gaulois;

public class Trophee {

    // Attributs
    private Gaulois gaulois;
    private Equipement equipement;

    // Constructeur
    public Trophee(Gaulois gaulois, Equipement equipement) {
        this.gaulois = gaulois;
        this.equipement = equipement;
    }

    // Getters
    public Gaulois getGaulois() {
        return gaulois;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    // Méthode donnerNom
    public String donnerNom() {
        return gaulois.getNom();
    }
}