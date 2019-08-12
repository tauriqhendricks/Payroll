package za.ac.cput.domain.demography;

public class Race {

    private String raceId;
    private String race;

    private Race() {
    }

    private Race(Builder builder) {
        this.raceId = builder.raceId;
        this.race = builder.race;
    }

    public String getRaceId() {
        return raceId;
    }

    public String getRace() {
        return race;
    }

    public static class Builder {
        private String raceId;
        private String race;

        public Builder raceId(String raceId) {
            this.raceId = raceId;
            return this;
        }

        public Builder race(String race) {
            this.race = race;
            return this;
        }

        public Builder copy(Race race) {
            this.raceId = race.raceId;
            this.race = race.race;
            return this;
        }

        public Race build() {
            return new Race(this);
        }
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId='" + raceId + '\'' +
                ", race='" + race + '\'' +
                '}';
    }
}