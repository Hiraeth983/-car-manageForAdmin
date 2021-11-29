package model;

public class DetectionLineException {  //当日检测线及其对应异常数
    private String line;
    private int exceptionCount;

    public DetectionLineException() {
    }

    public DetectionLineException(String line, int exceptionCount) {
        this.line = line;
        this.exceptionCount = exceptionCount;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getExceptionCount() {
        return exceptionCount;
    }

    public void setExceptionCount(int exceptionCount) {
        this.exceptionCount = exceptionCount;
    }
}
