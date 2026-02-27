package navire;

import java.util.Arrays;

import personnages.Gaulois;

public class Bateau {
	
	private String nom;
	private int taille;
	private Element[] elements;

	public Bateau(String nom, int taille) {
		this.nom = nom;
		this.taille = taille;
		this.elements = new Element[taille];
	}

	@Override
	public String toString() {
		return "Bateau [nom=" + nom + ", taille=" + taille
				+ ", elements=" + Arrays.toString(elements) + "]";
	}


	public static void main(String[] args) {
		
		Gaulois g1 = new Gaulois("Louis", 23);
		Gaulois g2 = new Gaulois("Evan", 22);
		Bateau b1 = new Bateau("BateauLouis", 50);
		Bateau b2 = new Bateau("BateauEvan", 60);
		
		Bateau[] tabBateau = { b1, b2 }; 
		Gaulois[] tabGaulois = { g1, g2 };
				
	}
	
	public void attaquer(int numElement) {
		elements[numElement - 1].toucher();
	}

}

