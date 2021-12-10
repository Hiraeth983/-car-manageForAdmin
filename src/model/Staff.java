package model;

public class Staff {
    private String staffId;//员工号
    private String password;//登录密码
    private String fullName;//员工姓名
    private double avgScore;//平均评分
    private int orderSum;//总处理单数
    private String stationId;//归属站号
    private int isAble;//员工是否可以被分配任务

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    public int getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(int orderSum) {
        this.orderSum = orderSum;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public int getIsAble() {
        return isAble;
    }

    public void setIsAble(int isAble) {
        this.isAble = isAble;
    }
}
