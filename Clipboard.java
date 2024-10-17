
public class Clipboard {
    private String contenu;

    public void copier(String texte) {
        this.contenu = texte;
    }

    public String obtenirContenu() {
        return contenu;
    }
}
