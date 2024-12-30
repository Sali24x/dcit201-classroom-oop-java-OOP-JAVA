public class Motorcycle extends Vehicle implements Rentable {
    private boolean hasSidecar;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean hasSidecar) {
        super(vehicleId, model, baseRentalRate);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 0.9;
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
            System.out.println("Motorcycle rented successfully for " + days + " days.");
        } else {
            System.out.println("The motorcycle " + getModel() + " is not available at the moment.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Thank you for returning the motorcycle: " + getModel() + ".");
    }

    @Override
    public String toString() {
        return String.format("Motorcycle [ID: %s, Model: %s, Rate: %.2f, Sidecar: %s]", 
                             getVehicleId(), getModel(), getBaseRentalRate(), hasSidecar ? "Yes" : "No");
    }
}
