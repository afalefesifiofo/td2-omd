package version2;

import java.util.ArrayList;
import java.util.List;

public class ReplayCommand {
    private List<Command> commandList = new ArrayList<>();

    public void record(Command cmd) {
        commandList.add(cmd);
    }

    public void replay() {
        for (Command cmd : commandList) {
            cmd.execute();
        }
    }
}
