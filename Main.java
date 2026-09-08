public class Main {
    public static void main(String[] args) {
        // Сборка спортивного авто через цепочку методов (Method Chaining)
        Car sportsCar = new Car.Builder()
                .setSeats(2)
                .setEngine("V8 Turbo")
                .enableGps()
                .enableTripComputer()
                .build();

        // Сборка базового авто
        Car baseCar = new Car.Builder()
                .setSeats(5)
                .build();

        System.out.println("Спортивная машина: " + sportsCar);
        System.out.println("Базовая машина: " + baseCar);
    }
}