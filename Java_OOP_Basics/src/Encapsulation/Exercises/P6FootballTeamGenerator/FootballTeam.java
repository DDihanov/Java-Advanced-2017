package Encapsulation.Exercises.P6FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class FootballTeam {
    private String name;
    private List<Player> players;

    public FootballTeam(String[] name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String[] name) {
        if (name.length == 1) {
            throw new IllegalArgumentException("A name should not be empty.");
        }

        if(name[1].isEmpty()||name[1].trim().length()==0){
            throw new IllegalArgumentException("A name should not be empty.");
        }

        this.name = name[1];
    }

    public double getRating() {
        if(this.players.size() == 0){
            return 0;
        }

//        return  this.players
//                .stream()
//                .mapToDouble(p->p.getOverallSkill())
//                .average()
//                .getAsDouble();

        double avg = 0;
        for (Player player :
                this.players) {
            avg += player.getOverallSkill();
        }
        return avg/this.players.size();
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String player){
        if(!this.players.stream().anyMatch(p->p.getName().equals(player))){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.getName()));
        }

        for (Player p:
                this.players) {
            if(p.getName().equals(player)){
                this.players.remove(p);
                break;
            }
        }
    }
}
