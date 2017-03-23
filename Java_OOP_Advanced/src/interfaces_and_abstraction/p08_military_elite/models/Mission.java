package interfaces_and_abstraction.p08_military_elite.models;

import interfaces_and_abstraction.p08_military_elite.interfaces.IMission;

public class Mission implements IMission {
    private String codeName;
    private String state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (!state.equals("Finished") && !state.equals("inProgress")) {
            return;
        }
        this.state = state;
    }

    @Override
    public void completeMission() {
        this.setState("Finished");
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s\n", this.getCodeName(), this.getState());
    }
}
