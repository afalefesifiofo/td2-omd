package version2;

public class Clipboard {
    private String contenu = "";

    public void copier(String texte) {
        contenu = texte;
    }

    public String obtenirContenu() {
        return contenu;
    }
}
