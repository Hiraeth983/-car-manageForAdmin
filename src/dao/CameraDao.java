package dao;

import model.Camera;

import java.util.ArrayList;

public interface CameraDao {
    /* 查询所有检测线 */
    ArrayList<Camera> queryCamera() throws Exception;

    /* 查询某一检测线 */
    ArrayList<Camera> queryCamera(String camera_id) throws Exception;

    /* 插入数据 */
    boolean insertCamera(Camera camera) throws Exception;

    /* 删除某一条数据 */
    boolean deleteCamera(String camera_id) throws Exception;

    /* 更新某一条数据 */
    boolean updateCamera(Camera camera) throws Exception;
}
