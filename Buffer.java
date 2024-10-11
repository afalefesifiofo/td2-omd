package td2_omd;
public class Buffer {
    private String text;
    private int selection_debut;
    private int selection_fin;

    public Buffer() {
        this.text = "";
        this.selection_debut = 0;
        this.selection_fin = 0;
    }

    // Méthode pour sélectionner du texte
    public void selectionner(int debut, int fin) {
        this.selection_debut = debut;
        this.selection_fin = fin;
    }

    // Méthode pour copier le texte sélectionné
    public String copier() {
        if (selection_debut < selection_fin && selection_fin <= text.length()) {
            return text.substring(selection_debut, selection_fin);
        }
        return "";
    }

    // Méthode pour couper le texte sélectionné
    public String couper() {
        String texteCoupe = copier();
        if (!texteCoupe.isEmpty()) {
            text = text.substring(0, selection_debut) + text.substring(selection_fin);
            selection_fin = selection_debut;
        }
        return texteCoupe;
    }

    // Méthode pour coller du texte
    public void coller(String texte) {
        text = text.substring(0, selection_debut) + texte + text.substring(selection_fin);
        selection_fin = selection_debut + texte.length();
    }

    // Obtenir le texte entier
    public String getText() {
        return text;
    }

    // Ajouter du texte au buffer
    public void ajouterTexte(String texte) {
        text += texte;
    }
}
