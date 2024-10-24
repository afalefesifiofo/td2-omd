package version1;
public class CutCommand implements Command {
    private IHM ihm;

    public CutCommand(IHM ihm) {
        this.ihm = ihm;
    }

    @Override
    public void execute() {
        ihm.couper();
    }
}