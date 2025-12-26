import java.util.ArrayList;
import java.util.Scanner;

public class FleetApp {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;

        while (running) {
            System.out.println("\nFleet Management System");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Add new car");
            System.out.println("3. Add new bus");
            System.out.println("4. Show total yearly insurance fees");
            System.out.println("5. Show vehicles older than N years");
            System.out.println("6. Perform service for all vehicles");
            System.out.println("7. Quit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> printAllVehicles();
                case 2 -> addNewCar();
                case 3 -> addNewBus();
                case 4 -> showTotalInsuranceFees();
                case 5 -> showOlderVehicles();
                case 6 -> performServiceAll();
                case 7 -> running = false;
                default -> System.out.println("Invalid choice!");
            }
        }

        System.out.println("Exiting Fleet Management System...");
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    private void addNewCar() {
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter base price: ");
        double basePrice = scanner.nextDouble();
        System.out.print("Enter number of doors: ");
        int doors = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(model, year, basePrice, doors);
        vehicles.add(car);
        System.out.println("Car added successfully!");
    }

    private void addNewBus() {
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        System.out.print("Enter base price: ");
        double basePrice = scanner.nextDouble();
        System.out.print("Enter passenger capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        Bus bus = new Bus(model, year, basePrice, capacity);
        vehicles.add(bus);
        System.out.println("Bus added successfully!");
    }

    private void showTotalInsuranceFees() {
        double total = 0;
        for (Vehicle v : vehicles) {
            total += v.calculateInsuranceFee();
        }
        System.out.println("Total yearly insurance fees: " + total);
    }

    private void showOlderVehicles() {
        System.out.print("Enter current year: ");
        int currentYear = scanner.nextInt();
        System.out.print("Enter minimum age (N): ");
        int n = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicles older than " + n + " years");
        }
    }

    private void performServiceAll() {
        for (Vehicle v : vehicles) {
            if (v instanceof Servicable s) {
                s.performService();
            }
        }
    }

    public static void main(String[] args) {
        FleetApp app = new FleetApp();
        app.run();
    }
}