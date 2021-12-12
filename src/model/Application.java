package model;

public class Application{
    private String orderId;//申请调换单号
    private String submitTime;//提交时间
    private String oStaffId;//原先检测员工号
    private String oStaffName;//原先检测员工姓名
    private String nStaffId;//现在检测员工号
    private String nStaffName;//现在检测员工姓名
    private String reason;//调换原因
    private String state;//申请状态

    public Application() {
    }

    public Application(String orderId, String submitTime, String oStaffId, String oStaffName, String nStaffId, String nStaffName, String reason, String state) {
        this.orderId = orderId;
        this.submitTime = submitTime;
        this.oStaffId = oStaffId;
        this.oStaffName = oStaffName;
        this.nStaffId = nStaffId;
        this.nStaffName = nStaffName;
        this.reason = reason;
        this.state = state;
    }

    public String getoStaffName() {
        return oStaffName;
    }

    public void setoStaffName(String oStaffName) {
        this.oStaffName = oStaffName;
    }

    public String getnStaffName() {
        return nStaffName;
    }

    public void setnStaffName(String nStaffName) {
        this.nStaffName = nStaffName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getoStaffId() {
        return oStaffId;
    }

    public void setoStaffId(String oStaffId) {
        this.oStaffId = oStaffId;
    }

    public String getnStaffId() {
        return nStaffId;
    }

    public void setnStaffId(String nStaffId) {
        this.nStaffId = nStaffId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}