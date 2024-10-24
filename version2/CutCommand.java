package version2;

public class CutCommand implements Command {
    private Buffer buffer;
    private Clipboard clipboard;
    private String previousText;

    public CutCommand(Buffer buffer, Clipboard clipboard) {
        this.buffer = buffer;
        this.clipboard = clipboard;
    }

    @Override
    public void execute() {
        previousText = buffer.couper();
        clipboard.copier(previousText);
    }

    @Override
    public void undo() {
        buffer.coller(previousText);
    }
}
