package model;

public class Station {
    private String stationId;
    private float longitude;
    private float latitude;
    private String address;
    private String stationName;
    private String phone;
    private int maxNum;
    private int currentNum;

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public Station(String stationId, float longitude, float latitude, String address, String stationName, String phone, int maxNum, int currentNum) {
        this.stationId = stationId;
        this.longitude = longitude;
        this.latitude = latitude;
        this.address = address;
        this.stationName = stationName;
        this.phone = phone;
        this.maxNum = maxNum;
        this.currentNum = currentNum;
    }

    public Station() {
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }
}
