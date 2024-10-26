package version2;

public class CopyCommand implements Command {
    private Buffer buffer;
    private Clipboard clipboard;

    public CopyCommand(Buffer buffer, Clipboard clipboard) {
        this.buffer = buffer;
        this.clipboard = clipboard;
    }

    @Override
    public void execute() {
        clipboard.copier(buffer.copier());
    }

    @Override
    public void undo() {
        // Nessuna operazione per annullare la copia
    }
}
