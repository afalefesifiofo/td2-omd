package version2;

public class PasteCommand implements Command {
    private Buffer buffer;
    private Clipboard clipboard;
    private String pastedText;

    public PasteCommand(Buffer buffer, Clipboard clipboard) {
        this.buffer = buffer;
        this.clipboard = clipboard;
    }

    @Override
    public void execute() {
        pastedText = clipboard.obtenirContenu();
        buffer.coller(pastedText);
    }

    @Override
    public void undo() {
        // Rimuove il testo incollato
        buffer.couper();
    }
}
