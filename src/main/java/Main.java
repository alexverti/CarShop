import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dealership dealership = new Dealership();
        Scanner scanner = new Scanner(System.in);

        // Добавим несколько автомобилей
        dealership.addCar(new Car("Toyota", "Corolla", 2020, 20000));
        dealership.addCar(new Car("Honda", "Civic", 2021, 22000));
        dealership.addCar(new Car("Ford", "Focus", 2019, 18000));

        System.out.println("Welcome to the Dealership!");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Show Inventory\n2. Sell Car\n3. Show Sales\n4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Inventory:");
                    for (Car car : dealership.getInventory()) {
                        System.out.println(car);
                    }
                    break;
                case 2:
                    System.out.println("Enter car index to sell:");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= dealership.getInventory().size()) {
                        System.out.println("Invalid index!");
                        break;
                    }
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter customer name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter customer phone:");
                    String phone = scanner.nextLine();
                    Customer customer = new Customer(name, phone);
                    if (dealership.sellCar(dealership.getInventory().get(index), customer)) {
                        System.out.println("Car sold successfully!");
                    } else {
                        System.out.println("Error selling car.");
                    }
                    break;
                case 3:
                    System.out.println("Sales:");
                    for (Sale sale : dealership.getSales()) {
                        System.out.println(sale);
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}