public class Truck extends Vehicle implements Rentable {
    private double loadCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, double loadCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (loadCapacity * 0.1);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            customer.addRental(this, days);
            System.out.println("Truck rented successfully.");
        } else {
            System.out.println("This truck is currently not available.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Truck returned successfully.");
    }

    @Override
    public String toString() {
        return String.format("Truck [ID: %s, Model: %s, Rate: %.2f, Load Capacity: %.2f tons]", 
                             getVehicleId(), getModel(), getBaseRentalRate(), loadCapacity);
    }
}