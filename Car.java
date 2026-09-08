import java.util.Objects;

/**
 * Класс Car, реализующий паттерн Builder с соблюдением принципов Clean Code.
 */
public final class Car {
    private final int seats;
    private final String engine;
    private final boolean hasGps;
    private final boolean hasTripComputer;

    // Приватный конструктор: объект Car можно создать ТОЛЬКО через Builder
    private Car(Builder builder) {
        this.seats = builder.seats;
        this.engine = builder.engine;
        this.hasGps = builder.hasGps;
        this.hasTripComputer = builder.hasTripComputer;
    }

    // Геттеры (Clean Code: понятные имена, отсутствие побочных эффектов)
    public int getSeats() { return seats; }
    public String getEngine() { return engine; }
    public boolean hasGps() { return hasGps; }
    public boolean hasTripComputer() { return hasTripComputer; }

    @Override
    public String toString() {
        return String.format("Car [Seats: %d, Engine: '%s', GPS: %b, Trip Computer: %b]",
                seats, engine, hasGps, hasTripComputer);
    }

    // =========================================================================
    // Вложенный класс Builder
    // =========================================================================
    public static class Builder {
        private int seats = 4; // Значение по умолчанию
        private String engine = "Standard Engine";
        private boolean hasGps = false;
        private boolean hasTripComputer = false;

        // Clean Code: методы маленькие, принимают по 1 аргументу и возвращают this
        public Builder setSeats(int seats) {
            if (seats <= 0) {
                throw new IllegalArgumentException("Количество мест должно быть больше 0");
            }
            this.seats = seats;
            return this;
        }

        public Builder setEngine(String engine) {
            this.engine = Objects.requireNonNull(engine, "Двигатель не может быть null");
            return this;
        }

        // Clean Code: вместо передачи boolean-флагов сделаны отдельные выразительные методы
        public Builder enableGps() {
            this.hasGps = true;
            return this;
        }

        public Builder enableTripComputer() {
            this.hasTripComputer = true;
            return this;
        }

        // Финальный метод сборки объекта
        public Car build() {
            return new Car(this);
        }
    }
}