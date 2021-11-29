package model;

import java.util.Date;

public class DateStatusInfo {
    private String date;
    private int normal;
    private int untreated;
    private int processing;
    private int processed;

    public DateStatusInfo() {
    }

    public DateStatusInfo(String date, int normal, int untreated, int processing, int processed) {
        this.date = date;
        this.normal = normal;
        this.untreated = untreated;
        this.processing = processing;
        this.processed = processed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNormal() {
        return normal;
    }

    public void setNormal(int normal) {
        this.normal = normal;
    }

    public int getUntreated() {
        return untreated;
    }

    public void setUntreated(int untreated) {
        this.untreated = untreated;
    }

    public int getProcessing() {
        return processing;
    }

    public void setProcessing(int processing) {
        this.processing = processing;
    }

    public int getProcessed() {
        return processed;
    }

    public void setProcessed(int processed) {
        this.processed = processed;
    }
}
