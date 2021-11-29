package model;

public class User { //用户基本信息
    private String id;
    private String status;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String id, String status, String password) {
        this.id = id;
        this.status = status;
        this.password = password;
    }
}
