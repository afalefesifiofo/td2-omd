package version1;

public class IHM {
    private Buffer buffer;
    private Clipboard clipboard;
    
    public IHM(Buffer buffer, Clipboard clipboard) {
        this.buffer = buffer;
        this.clipboard = clipboard;
    }

    private void run() {
        // Logica di esecuzione dell'interfaccia
    }

    public String saisirTexte() {
        // Simulazione input utente
        return "Testo utente";
    }

    public void afficherTexte(Buffer buffer) {
        buffer.afficher();
    }

    public void gererSelection(int debut, int fin) {
        buffer.selectionner(debut, fin);
    }

    public void copier() {
        String textToCopy = buffer.copier();
        clipboard.copier(textToCopy);
    }

    public void couper() {
        String textToCut = buffer.couper();
        clipboard.copier(textToCut);
    }

    public void coller() {
        String textToPaste = clipboard.obtenirContenu();
        buffer.coller(textToPaste);
    }
}
