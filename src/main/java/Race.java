import java.util.ArrayList;
import java.util.List;
public class Race {
    private List<Car> cars;
    private Car leader;

    public Race() {
        this.cars = new ArrayList<>();
        this.leader = null;
    }

    public void addCar(Car car) {
        cars.add(car);
        updateLeader();
    }

    public void addCars(List<Car> carList) {
        this.cars.addAll(carList);
        updateLeader();
    }

    private void updateLeader() {
        if (cars.isEmpty()) {
            leader = null;
            return;
        }
        Car currentLeader = cars.get(0);
        for (Car car : cars) {
            if (car.getSpeed() > currentLeader.getSpeed()) {
                currentLeader = car;
            }
        }
        leader = currentLeader;
    }

    public Car getLeader() {
        return leader;
    }

    public List<Car> getCars() {
        return cars;
    }
}
