public class CarDirector {

    public void constructSportsCar(Car.Builder builder) {
        builder.setSeats(2)
               .setEngine("V8 Turbo")
               .setGps(true)
               .setTripComputer(true);
    }

    public void constructCityCar(Car.Builder builder) {
        builder.setSeats(4)
               .setEngine("1.6L Eco")
               .setGps(true)
               .setTripComputer(false);
    }

    public void constructBaseCar(Car.Builder builder) {
    builder.setSeats(5)
           .setEngine("Standard Engine")
           .setGps(false)
           .setTripComputer(false); // Добавлен явный сброс параметров
}
}
