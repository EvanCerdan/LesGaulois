package navire;

public class Element {

    private boolean touche = false;

    public boolean isTouche() {
        return touche;
    }

    public void toucher() {
        touche = true;
    }
}