package model;

public class Complaint{
    private String orderId;//投诉单号
    private String submitTime;//提交时间
    private String staffId;//员工号
    private String complaintDescribe;//投诉内容
    private String result;//人工审核意见

    public Complaint() {
    }

    public Complaint(String orderId, String submitTime, String staffId, String complaintDescribe, String result) {
        this.orderId = orderId;
        this.submitTime = submitTime;
        this.staffId = staffId;
        this.complaintDescribe = complaintDescribe;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getComplaintDescribe() {
        return complaintDescribe;
    }

    public void setComplaintDescribe(String complaintDescribe) {
        this.complaintDescribe = complaintDescribe;
    }
}