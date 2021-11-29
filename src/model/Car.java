package model;

public class Car {
    private String car_id;
    private String car_modle;
    private String car_age;
    private String car_owner;
    private String endorsement_YorN;
    private String recently_AS;

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public String getCar_modle() {
        return car_modle;
    }

    public void setCar_modle(String car_modle) {
        this.car_modle = car_modle;
    }

    public String getCar_age() {
        return car_age;
    }

    public void setCar_age(String car_age) {
        this.car_age = car_age;
    }

    public String getCar_owner() {
        return car_owner;
    }

    public void setCar_owner(String car_owner) {
        this.car_owner = car_owner;
    }

    public String getEndorsement_YorN() {
        return endorsement_YorN;
    }

    public void setEndorsement_YorN(String endorsement_YorN) {
        this.endorsement_YorN = endorsement_YorN;
    }

    public String getRecently_AS() {
        return recently_AS;
    }

    public void setRecently_AS(String recently_AS) {
        this.recently_AS = recently_AS;
    }

    public Car() {
    }

    public Car(String car_id, String car_modle, String car_age, String car_owner, String endorsement_YorN, String recently_AS) {
        this.car_id = car_id;
        this.car_modle = car_modle;
        this.car_age = car_age;
        this.car_owner = car_owner;
        this.endorsement_YorN = endorsement_YorN;
        this.recently_AS = recently_AS;
    }
}
