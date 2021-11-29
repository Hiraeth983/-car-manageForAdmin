package model;

public class StaffChart {
    private String staff_id;
    private String staff_name;
    private int number;

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public StaffChart(String staff_id, String staff_name, int number) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.number = number;
    }

    public StaffChart() {
    }
}
