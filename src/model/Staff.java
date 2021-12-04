package model;

public class Staff {
    private String staffId;
    private String fullName;
    private String avgScore;
    private String orderSum;
    private String stationId;
    private String isAble;

    public Staff() {
    }

    public Staff(String staffId, String fullName, String avgScore, String orderSum, String stationId, String isAble) {
        this.staffId = staffId;
        this.fullName = fullName;
        this.avgScore = avgScore;
        this.orderSum = orderSum;
        this.stationId = stationId;
        this.isAble = isAble;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(String avgScore) {
        this.avgScore = avgScore;
    }

    public String getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(String orderSum) {
        this.orderSum = orderSum;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getIsAble() {
        return isAble;
    }

    public void setIsAble(String isAble) {
        this.isAble = isAble;
    }
}
