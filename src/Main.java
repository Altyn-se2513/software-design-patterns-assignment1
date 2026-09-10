public class Main {

    public static void main(String[] args) {
        CarDirector director = new CarDirector();

        // Build a sports car using Director
        Car.Builder sportsBuilder = new Car.Builder();
        director.constructSportsCar(sportsBuilder);
        Car sportsCar = sportsBuilder.build();

        System.out.println("Sports Car:");
        System.out.println(sportsCar);
        System.out.println();

        // Build a city car using Director
        Car.Builder cityBuilder = new Car.Builder();
        director.constructCityCar(cityBuilder);
        Car cityCar = cityBuilder.build();

        System.out.println("City Car:");
        System.out.println(cityCar);
        System.out.println();

        // Build a base car using Director
        Car.Builder baseBuilder = new Car.Builder();
        director.constructBaseCar(baseBuilder);
        Car baseCar = baseBuilder.build();

        System.out.println("Base Car:");
        System.out.println(baseCar);
        System.out.println();

        // Demonstrate Director with separate Builder instances
        Car.Builder directorSportsBuilder = new Car.Builder();
        director.constructSportsCar(directorSportsBuilder);
        Car directorSportsCar = directorSportsBuilder.build();

        System.out.println("Sports Car built by Director:");
        System.out.println(directorSportsCar);
        System.out.println();

        // ИСПРАВЛЕНО: Создаем НОВЫЙ builder вместо повторного использования старого
        Car.Builder directorBaseBuilder = new Car.Builder();
        director.constructBaseCar(directorBaseBuilder);
        Car directorBaseCar = directorBaseBuilder.build();

        System.out.println("Base Car built by Director:");
        System.out.println(directorBaseCar);
        System.out.println();

        // Demonstrate validation
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
