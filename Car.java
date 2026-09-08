import java.util.Objects;

public final class Car {
    private final int seats;
    private final String engine;
    private final boolean hasGps;
    private final boolean hasTripComputer;

    private Car(Builder builder) {
        this.seats = builder.seats;
        this.engine = builder.engine;
        this.hasGps = builder.hasGps;
        this.hasTripComputer = builder.hasTripComputer;
    }

    public int getSeats() { return seats; }
    public String getEngine() { return engine; }
    public boolean hasGps() { return hasGps; }
    public boolean hasTripComputer() { return hasTripComputer; }

    @Override
    public String toString() {
        return String.format("Car [Seats: %d, Engine: '%s', GPS: %b, Trip Computer: %b]",
                seats, engine, hasGps, hasTripComputer);
    }

    public static class Builder {
        private int seats = 4;
        private String engine = "Standard Engine";
        private boolean hasGps = false;
        private boolean hasTripComputer = false;

        public Builder setSeats(int seats) {
            if (seats <= 0) {
                throw new IllegalArgumentException("Seats count must be greater than 0");
            }
            this.seats = seats;
            return this;
        }

        public Builder setEngine(String engine) {
            this.engine = Objects.requireNonNull(engine, "Engine cannot be null");
            return this;
        }

        public Builder enableGps() {
            this.hasGps = true;
            return this;
        }

        public Builder enableTripComputer() {
            this.hasTripComputer = true;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
