package version1;
public class PasteCommand implements Command {
    private IHM ihm;

    public PasteCommand(IHM ihm) {
        this.ihm = ihm;
    }

    @Override
    public void execute() {
        ihm.coller();
    }
}