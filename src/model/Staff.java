package model;


public class Staff {
    private String staff_id;
    private String staff_name;
    private String detection_id;
    private int credit_score;
    private int illegal_number;

    public Staff() {
    }

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

    public String getDetection_id() {
        return detection_id;
    }

    public void setDetection_id(String detection_id) {
        this.detection_id = detection_id;
    }

    public int getCredit_score() {
        return credit_score;
    }

    public void setCredit_score(int credit_score) {
        this.credit_score = credit_score;
    }

    public int getIllegal_number() {
        return illegal_number;
    }

    public void setIllegal_number(int illegal_number) {
        this.illegal_number = illegal_number;
    }

    public Staff(String staff_id, String staff_name, String detection_id, int credit_score, int illegal_number) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.detection_id = detection_id;
        this.credit_score = credit_score;
        this.illegal_number = illegal_number;
    }
}
