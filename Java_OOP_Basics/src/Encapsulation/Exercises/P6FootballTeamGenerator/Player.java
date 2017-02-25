package Encapsulation.Exercises.P6FootballTeamGenerator;

public class Player {
    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;


    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty()||name.trim().length()==0){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public double getEndurance() {
        return endurance;
    }

    private void setEndurance(double endurance) {
        if(endurance<0 || endurance > 100){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    public double getSprint() {
        return sprint;
    }

    private void setSprint(double sprint) {
        if(sprint<0 || sprint > 100){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    public double getDribble() {
        return dribble;
    }

    private void setDribble(double dribble) {
        if(dribble<0 || dribble > 100){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    public double getPassing() {
        return passing;
    }

    private void setPassing(double passing) {
        if(passing<0 || passing > 100){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    public double getShooting() {
        return shooting;
    }

    private void setShooting(double shooting) {
        if(shooting<0 || shooting > 100){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public double getOverallSkill(){
        return (this.getDribble()+this.getEndurance()+this.getPassing()+this.getShooting()+this.getSprint())/5d;
    }
}
