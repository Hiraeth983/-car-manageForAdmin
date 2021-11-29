package model;

public class ErrorTypeChart {
    private String error_type;
    private int count;

    public String getError_type() {
        return error_type;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ErrorTypeChart() {
    }

    public ErrorTypeChart(String error_type, int count) {
        this.error_type = error_type;
        this.count = count;
    }
}
