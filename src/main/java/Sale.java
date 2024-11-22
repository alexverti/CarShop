public class Sale {
    private Car car;
    private Customer customer;

    public Sale(Car car, Customer customer) {
        this.car = car;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Sale: " + car + " sold to " + customer;
    }
}

