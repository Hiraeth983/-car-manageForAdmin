package model;

public class Record {
    private String order;
    private String idcard;
    private String fulllname;
    private String carId;
    private String address;
    private String orderTime;
    private String checkTime;
    private String result;
    private String staffname;
    private String staffId;
    private int score;
    private String process;
    private int available;

    public Record() {
    }

    public Record(String order, String idcard, String fulllname, String carId, String address, String orderTime, String checkTime, String result, String staffname, String staffId, int score, String process, int available) {
        this.order = order;
        this.idcard = idcard;
        this.fulllname = fulllname;
        this.carId = carId;
        this.address = address;
        this.orderTime = orderTime;
        this.checkTime = checkTime;
        this.result = result;
        this.staffname = staffname;
        this.staffId = staffId;
        this.score = score;
        this.process = process;
        this.available = available;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getFulllname() {
        return fulllname;
    }

    public void setFulllname(String fulllname) {
        this.fulllname = fulllname;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}
