package model;

public class Camera {
    private String camera_id;

    public Camera(String camera_id) {
        this.camera_id = camera_id;
    }

    public Camera() {
    }

    public String getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(String camera_id) {
        this.camera_id = camera_id;
    }
}
