package td2_omd;
public class Clipboard {
    private String contenu;

    public Clipboard() {
        this.contenu = "";
    }

    // Copier du texte dans le presse-papier
    public void copier(String texte) {
        this.contenu = texte;
    }

    // Obtenir le contenu du presse-papier
    public String obtenirContenu() {
        return contenu;
    }
}
