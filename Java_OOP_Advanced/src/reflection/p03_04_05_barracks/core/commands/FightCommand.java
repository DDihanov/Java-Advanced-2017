package reflection.p03_04_05_barracks.core.commands;

public class FightCommand extends Command {

    protected FightCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
