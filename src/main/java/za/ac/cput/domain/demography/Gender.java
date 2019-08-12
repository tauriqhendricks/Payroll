package za.ac.cput.domain.demography;

public class Gender {

    private String genderId;
    private String gender;

    private Gender(){}

    private Gender(Builder builder){
        this.genderId = builder.genderId;
        this.gender = builder.gender;
    }

    public String getGenderId() {
        return genderId;
    }

    public String getGender() {
        return gender;
    }

    public static class Builder {
        private String genderId;
        private String gender;

        public Builder genderId(String genderId) {
            this.genderId = genderId;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder copy(Gender gender) {
            this.genderId = gender.genderId;
            this.gender = gender.gender;
            return this;
        }

        public Gender build() {
            return new Gender(this);
        }
    }

    @Override
    public String toString() {
        return "Gender{" +
                "genderId='" + genderId + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
