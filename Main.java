public class Main {

    public static void main(String[] args) {
        CarDirector director = new CarDirector();

        Car.Builder sportsBuilder = new Car.Builder();
        director.constructSportsCar(sportsBuilder);
        Car sportsCar = sportsBuilder.build();

        System.out.println("Sports Car:");
        System.out.println(sportsCar);
        System.out.println();

        Car.Builder cityBuilder = new Car.Builder();
        director.constructCityCar(cityBuilder);
        Car cityCar = cityBuilder.build();

        System.out.println("City Car:");
        System.out.println(cityCar);
        System.out.println();

        Car.Builder baseBuilder = new Car.Builder();
        director.constructBaseCar(baseBuilder);
        Car baseCar = baseBuilder.build();

        System.out.println("Base Car:");
        System.out.println(baseCar);
        System.out.println();

        try {
            new Car.Builder()
                    .setSeats(0)
                    .setEngine("Test Engine")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation test:");
            System.out.println(e.getMessage());
        }
    }
}