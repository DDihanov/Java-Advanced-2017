package P01_Need_for_Speed.models.races;

import P01_Need_for_Speed.models.cars.Car;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Austin on 12/03/2017.
 */
public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        List<Car> winners = super.getParticipants().values().stream().sorted((c1,c2) -> {
            return Integer.compare(c2.getSuspensionPerformance(), c1.getSuspensionPerformance());
        }).limit(3).collect(Collectors.toList());

        sb.append(super.toString());
        int counter = 1;
        for (Car car :
                winners) {
            sb.append(String.format("%d. %s %s %dPP - $%s\n", counter, car.getBrand(), car.getModel(),
                    car.getSuspensionPerformance(), super.determinePrize(counter)));
            counter++;
        }

        return sb.toString();
    }
}
