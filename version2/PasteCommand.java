package version2;

public class PasteCommand implements Command {
    private Buffer buffer;
    private Clipboard clipboard;
    private String previousText;

    public PasteCommand(Buffer buffer, Clipboard clipboard) {
        this.buffer = buffer;
        this.clipboard = clipboard;
    }

    @Override
    public void execute() {
        previousText = clipboard.obtenirContenu();
        buffer.coller(previousText);
    }

    @Override
    public void undo() {
        buffer.couper(); // Annulla incollando ciò che era stato incollato
    }
}
