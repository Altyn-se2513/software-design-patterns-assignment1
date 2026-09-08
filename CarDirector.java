public class CarDirector {

    public void constructSportsCar(Car.Builder builder) {
        builder.setSeats(2)
               .setEngine("V8 Turbo")
               .enableGps()
               .enableTripComputer();
    }

    public void constructCityCar(Car.Builder builder) {
        builder.setSeats(4)
               .setEngine("1.6L Eco")
               .enableGps();
    }

    public void constructBaseCar(Car.Builder builder) {
        builder.setSeats(5)
               .setEngine("Standard Engine");
    }
}
