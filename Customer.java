public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Vehicle vehicle, int days) {
        // Implementation for adding rental history
        System.out.println("Rental recorded: " + vehicle.getModel() + " for " + days + " days.");
    }
}
