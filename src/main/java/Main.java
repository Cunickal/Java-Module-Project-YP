import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Race race = new Race();

        while (true) {
            int choice = getChoice();
            switch (choice) {
                case 1:
                    Car car = getCarFromInput();
                    race.addCar(car);
                    System.out.println("Автомобиль добавлен.");
                    break;
                case 2:
                    List<Car> carList = getCarsFromInput();
                    race.addCars(carList);
                    System.out.println("Автомобили добавлены.");
                    break;
                case 3:
                    Car leader = race.getLeader();
                    if (leader != null) {
                        System.out.println("Текущий лидер: " + leader);
                    } else {
                        System.out.println("Еще нет автомобилей в гонке.");
                    }
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private static Car getCarFromInput() {
        String carName;
        int carSpeed;
        System.out.print("Введите название автомобиля: ");
        carName = scanner.nextLine();

        while (true) {
            System.out.print("Введите скорость автомобиля (0-250): ");
            if (scanner.hasNextInt()) {
                carSpeed = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                if (carSpeed >= 0 && carSpeed <= 250) {
                    break; // Correct speed, exit loop
                } else {
                    System.out.println("Неправильная скорость. Пожалуйста, введите значение от 0 до 250.");
                }
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // Consume the invalid input
            }
        }
        return new Car(carName, carSpeed);
    }

    private static List<Car> getCarsFromInput() {
        List<Car> carList = new ArrayList<>();
        System.out.print("Введите количество автомобилей для добавления: ");
        int numberOfCars;
        while (true) {
            if(scanner.hasNextInt()) {
                numberOfCars = scanner.nextInt();
                scanner.nextLine();
                if(numberOfCars > 0) {
                    break;
                } else {
                    System.out.println("Неправильный ввод. Пожалуйста, введите число больше 0");
                }
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // Consume the invalid input
            }
        }
        for(int i = 0; i < numberOfCars; i++) {
            carList.add(getCarFromInput());
        }
        return carList;

    }

    private static int getChoice() {
        int choice;
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить автомобиль");
            System.out.println("2. Добавить список автомобилей");
            System.out.println("3. Показать текущего лидера");
            System.out.println("0. Выход");

            System.out.print("Ваш выбор: ");

            if(scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                break;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                scanner.next(); // Consume the invalid input
            }

        }
        return choice;
    }
}