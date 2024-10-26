package version2;

public class IHM {
    private Buffer buffer;
    private Clipboard clipboard;
    private CommandHistory commandHistory;

    public IHM(Buffer buffer, Clipboard clipboard, CommandHistory commandHistory) {
        this.buffer = buffer;
        this.clipboard = clipboard;
        this.commandHistory = commandHistory;
    }

    public void run() {
        // Implementare il ciclo di input/gestione dei comandi qui
    }

    public String saisirTexte() {
        // Metodo per acquisire testo dall'utente
        return "";
    }

    public void afficherTexte(Buffer buffer) {
        buffer.afficher();
    }

    public void gererSelection(int debut, int fin) {
        buffer.selectionner(debut, fin);
    }
}
