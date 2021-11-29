package model;

public class CarChart {
    private String car_id;
    private int error_count;

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public int getError_count() {
        return error_count;
    }

    public void setError_count(int error_count) {
        this.error_count = error_count;
    }

    public CarChart() {
    }

    public CarChart(String car_id, int error_count) {
        this.car_id = car_id;
        this.error_count = error_count;
    }
}
