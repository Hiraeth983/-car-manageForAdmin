package model;

import java.util.Date;

public class ExceptionResult {
    private String id;
    private String car_id;
    private Date detection_date;
    private String detection_id;
    private String test_line;
    private String error_type;
    private String error_describe;
    private String error_picture;
    private String staff_id;
    private int solve_progress;
    private Date solve_time;

    public ExceptionResult() {
    }

    public ExceptionResult(String id, String car_id, Date detection_date, String detection_id, String test_line, String error_type, String error_describe, String error_picture, String staff_id, int solve_progress, Date solve_time) {
        this.id = id;
        this.car_id = car_id;
        this.detection_date = detection_date;
        this.detection_id = detection_id;
        this.test_line = test_line;
        this.error_type = error_type;
        this.error_describe = error_describe;
        this.error_picture = error_picture;
        this.staff_id = staff_id;
        this.solve_progress = solve_progress;
        this.solve_time = solve_time;
    }

    public String getError_describe() {
        return error_describe;
    }

    public void setError_describe(String error_describe) {
        this.error_describe = error_describe;
    }

    public String getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(String staff_id) {
        this.staff_id = staff_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public Date getDetection_date() {
        return detection_date;
    }

    public void setDetection_date(Date detection_date) {
        this.detection_date = detection_date;
    }

    public String getDetection_id() {
        return detection_id;
    }

    public void setDetection_id(String detection_id) {
        this.detection_id = detection_id;
    }

    public String getTest_line() {
        return test_line;
    }

    public void setTest_line(String test_line) {
        this.test_line = test_line;
    }

    public String getError_type() {
        return error_type;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    public String getError_picture() {
        return error_picture;
    }

    public void setError_picture(String error_picture) {
        this.error_picture = error_picture;
    }

    public int getSolve_progress() {
        return solve_progress;
    }

    public void setSolve_progress(int solve_progress) {
        this.solve_progress = solve_progress;
    }

    public Date getSolve_time() {
        return solve_time;
    }

    public void setSolve_time(Date solve_time) {
        this.solve_time = solve_time;
    }
}
