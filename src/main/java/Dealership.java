import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> inventory = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();

    public void addCar(Car car) {
        inventory.add(car);
    }

    public List<Car> getInventory() {
        return inventory;
    }

    public boolean sellCar(Car car, Customer customer) {
        if (inventory.remove(car)) {
            sales.add(new Sale(car, customer));
            return true;
        }
        return false;
    }

    public List<Sale> getSales() {
        return sales;
    }
}
