public class car extends Vehicle implements Rentable {
    private boolean hasGPS;

    public car(String vehicleId, String model, double baseRentalRate, boolean hasGPS) {
        super(vehicleId, model, baseRentalRate);
        this.hasGPS = hasGPS;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days;
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
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Sorry, this car is currently not available for rental.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Car returned successfully!");
    }

    @Override
    public String toString() {
        return String.format("Car [ID: %s, Model: %s, Rate: %.2f, GPS: %s]",
            getVehicleId(), getModel(), getBaseRentalRate(), hasGPS ? "Yes" : "No");
    }
}
