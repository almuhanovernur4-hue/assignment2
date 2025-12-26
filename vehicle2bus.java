public class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        return basePrice * 0.08 + getAge(2025) * 200;
    }

    @Override
    public void performService() {
        System.out.println("Bus service: full technical inspection");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }
}