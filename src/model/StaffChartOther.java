package model;

public class StaffChartOther {

    private String staff_name;
    private int number;

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

    public StaffChartOther() {
    }

    public StaffChartOther(String staff_name, int number) {
        this.staff_name = staff_name;
        this.number = number;
    }
}
