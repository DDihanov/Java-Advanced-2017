package Encapsulation.Exercises.P6FootballTeamGenerator;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, FootballTeam> teams = new HashMap<>();
        String input;

        while (!"END".equals(input = sc.readLine())) {
            String[] info = input.split(";");

            try {
                switch (info[0]) {
                    case "Team":
                        FootballTeam team = new FootballTeam(info);
                        teams.put(info[1], team);
                        break;
                    case "Add":
                        String teamToAdd = info[1];
                        String playerName = info[2];

                        double endurance = Double.parseDouble(info[3]);
                        double sprint = Double.parseDouble(info[4]);
                        double dribble = Double.parseDouble(info[5]);
                        double passing = Double.parseDouble(info[6]);
                        double shooting = Double.parseDouble(info[7]);


                        if (!teams.containsKey(teamToAdd)) {
                            System.out.printf("Team %s does not exist.\n", teamToAdd);
                        } else {
                            teams.get(teamToAdd).addPlayer(new Player(playerName, endurance, sprint, dribble, passing, shooting));
                        }
                        break;
                    case "Remove":
                        String teamToRemove = info[1];
                        String playerToRemove = info[2];

                        if (!teams.containsKey(teamToRemove)) {
                            System.out.printf("Team %s does not exist.\n", teamToRemove);
                        }

                        teams.get(teamToRemove).removePlayer(playerToRemove);
                        break;
                    case "Rating":
                        String teamToRate = info[1];

                        if (!teams.containsKey(teamToRate)) {
                            System.out.printf("Team %s does not exist.\n", teamToRate);
                            break;
                        }

                        System.out.printf("%s - %s\n", teamToRate, Math.round(teams.get(teamToRate).getRating()));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
