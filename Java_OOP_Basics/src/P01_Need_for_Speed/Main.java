package P01_Need_for_Speed;

import P01_Need_for_Speed.models.CarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Austin on 12/03/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CarManager carManager = new CarManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while(!"Cops Are Here".equals(input = reader.readLine())){
            String[] commands = input.split("\\s+");

            String command = commands[0];
            switch (command){
                case"register":
                    int id = Integer.parseInt(commands[1]);
                    String type = commands[2];
                    String brand = commands[3];
                    String model = commands[4];
                    int year = Integer.parseInt(commands[5]);
                    int horsePower = Integer.parseInt(commands[6]);
                    int acceleration = Integer.parseInt(commands[7]);
                    int suspension = Integer.parseInt(commands[8]);
                    int durability = Integer.parseInt(commands[9]);

                    carManager.register(id, type, brand, model, year, horsePower, acceleration, suspension, durability);
                    break;
                case"open":
                    carManager.open(Integer.parseInt(commands[1]),
                            commands[2],
                            Integer.parseInt(commands[3]),
                            commands[4],
                            Integer.parseInt(commands[5]));
                    break;
                case"participate":
                    carManager.participate(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                    break;
                case"park":
                    carManager.park(Integer.parseInt(commands[1]));
                    break;
                case"unpark":
                    carManager.unpark(Integer.parseInt(commands[1]));
                    break;
                case"tune":
                    carManager.tune(Integer.parseInt(commands[1]), commands[2]);
                    break;
                case"check":
                    System.out.print(carManager.check(Integer.parseInt(commands[1])));
                    break;
                case"start":
                    int raceId = Integer.parseInt(commands[1]);
                    if(carManager.getClosedRaces().containsKey(raceId)){
                        break;
                    }

                    if(carManager.getRace(raceId).getParticipants().isEmpty()){
                        System.out.print("Cannot start the race with zero participants.\n");
                        break;
                    }

                    System.out.print(carManager.start(raceId));
                    break;
            }

        }
    }

}
