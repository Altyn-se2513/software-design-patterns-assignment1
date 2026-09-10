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

    public int getSeats() {
        return seats;
    }

    public String getEngine() {
        return engine;
    }

    public boolean hasGps() {
        return hasGps;
    }

    public boolean hasTripComputer() {
        return hasTripComputer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seats=" + seats +
                ", engine='" + engine + '\'' +
                ", hasGps=" + hasGps +
                ", hasTripComputer=" + hasTripComputer +
                '}';
    }

    public static class Builder {
        private int seats = 4;
        private String engine = "Standard Engine";
        private boolean hasGps = false;
        private boolean hasTripComputer = false;

        public Builder setSeats(int seats) {
            this.seats = seats;
            return this;
        }

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setGps(boolean hasGps) {
            this.hasGps = hasGps;
            return this;
        }

        public Builder setTripComputer(boolean hasTripComputer) {
            this.hasTripComputer = hasTripComputer;
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
            if (seats <= 0) {
                throw new IllegalStateException(
                        "Cannot build Car: Seats count must be greater than 0"
                );
            }

            if (engine == null || engine.isBlank()) {
                throw new IllegalStateException(
                        "Cannot build Car: Engine must not be empty"
                );
            }

            return new Car(this);
        }
    }
}