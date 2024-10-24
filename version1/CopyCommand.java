package version1;
public class CopyCommand implements Command {
    private IHM ihm;

    public CopyCommand(IHM ihm) {
        this.ihm = ihm;
    }

    @Override
    public void execute() {
        ihm.copier();
    }
}