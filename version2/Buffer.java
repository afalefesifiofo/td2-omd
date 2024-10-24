package version2;

public class Buffer {
    private String text ="";
    private int selection_debut;
    private int selection_fin;

    public void selectionner(int debut, int fin) {
        this.selection_debut = debut;
        this.selection_fin = fin;
    }

    public String copier() {
        if (selection_debut >= 0 && selection_fin <= text.length()) {
            return text.substring(selection_debut, selection_fin);
        }
        return "";
    }

    public String couper() {
        String selectedText = copier();
        text = text.substring(0, selection_debut) + text.substring(selection_fin);
        return selectedText;
    }

    public void coller(String texte) {
        text = text.substring(0, selection_debut) + texte + text.substring(selection_debut);
    }

    public void ajouterTexte(String texte) {
        text += texte;
    }

    public void afficher() {
        System.out.println(text);
    }

    public String getCilpboard() {
        return copier();
    }
}
