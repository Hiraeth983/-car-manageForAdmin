package model;

import java.util.Date;

public class DetectionResult {
    private String id; //检测序号
    private Date detection_date; //检测日期
    private String detection_id; //站点编号
    private String test_line; //检测线
    private String engine; //发动机状态
    private int exhaust_funnel_num; //排气管个数
    private int exhaust_funnel_info; //尾气排放情况（黑烟）
    private int exhaust_funnel_judge; //缺失情况
    private String car_id; //车牌
    private int signal_tube; //采样管是否接
    private int door_info; //车门状态 开关
    private String car_color; //车颜色
    private String car_model; //车型
    private String tyre_info; //轮胎信息
    private String staff_id; //负责人
    private String detection_result; //检测结果是否正常

    public DetectionResult() {
    }

    public DetectionResult(String id, Date detection_date, String detection_id, String test_line, String engine, int exhaust_funnel_num, int exhaust_funnel_info, int exhaust_funnel_judge, String car_id, int signal_tube, int door_info, String car_color, String car_model, String tyre_info, String staff_id, String detection_result) {
        this.id = id;
        this.detection_date = detection_date;
        this.detection_id = detection_id;
        this.test_line = test_line;
        this.engine = engine;
        this.exhaust_funnel_num = exhaust_funnel_num;
        this.exhaust_funnel_info = exhaust_funnel_info;
        this.exhaust_funnel_judge = exhaust_funnel_judge;
        this.car_id = car_id;
        this.signal_tube = signal_tube;
        this.door_info = door_info;
        this.car_color = car_color;
        this.car_model = car_model;
        this.tyre_info = tyre_info;
        this.staff_id = staff_id;
        this.detection_result = detection_result;
    }

    public String getDetection_result() {
        return detection_result;
    }

    public void setDetection_result(String detection_result) {
        this.detection_result = detection_result;
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

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getExhaust_funnel_num() {
        return exhaust_funnel_num;
    }

    public void setExhaust_funnel_num(int exhaust_funnel_num) {
        this.exhaust_funnel_num = exhaust_funnel_num;
    }

    public int getExhaust_funnel_info() {
        return exhaust_funnel_info;
    }

    public void setExhaust_funnel_info(int exhaust_funnel_info) {
        this.exhaust_funnel_info = exhaust_funnel_info;
    }

    public int getExhaust_funnel_judge() {
        return exhaust_funnel_judge;
    }

    public void setExhaust_funnel_judge(int exhaust_funnel_judge) {
        this.exhaust_funnel_judge = exhaust_funnel_judge;
    }

    public String getCar_id() {
        return car_id;
    }

    public void setCar_id(String car_id) {
        this.car_id = car_id;
    }

    public int getSignal_tube() {
        return signal_tube;
    }

    public void setSignal_tube(int signal_tube) {
        this.signal_tube = signal_tube;
    }

    public int getDoor_info() {
        return door_info;
    }

    public void setDoor_info(int door_info) {
        this.door_info = door_info;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getTyre_info() {
        return tyre_info;
    }

    public void setTyre_info(String tyre_info) {
        this.tyre_info = tyre_info;
    }
}
