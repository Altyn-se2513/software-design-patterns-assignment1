public class Main {
    public static void main(String[] args) {
        CarDirector director = new CarDirector();

        Car.Builder sportsBuilder = new Car.Builder();
        director.constructSportsCar(sportsBuilder);
        Car sportsCar = sportsBuilder.build();

        Car.Builder cityBuilder = new Car.Builder();
        director.constructCityCar(cityBuilder);
        Car cityCar = cityBuilder.build();

        Car customCar = new Car.Builder()
                .setSeats(7)
                .setEngine("V6 Diesel")
                .enableTripComputer()
                .build();

        System.out.println("Sports Car: " + sportsCar);
        System.out.println("City Car:   " + cityCar);
        System.out.println("Custom Car: " + customCar);
    }
}
