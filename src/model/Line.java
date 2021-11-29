package model;

public class Line {
    private String detection_id;
    private String test_line;
    private String line_name;

    public Line() {
    }

    public Line(String detection_id, String test_line, String line_name) {
        this.detection_id = detection_id;
        this.test_line = test_line;
        this.line_name = line_name;
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

    public String getLine_name() {
        return line_name;
    }

    public void setLine_name(String line_name) {
        this.line_name = line_name;
    }
}
