package implement;

import dao.BaseDao;
import dao.CameraDao;
import model.Camera;
import model.Camera;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CameraDaoImpl implements CameraDao {
    @Override
    public ArrayList<Camera> queryCamera() throws Exception {
        ArrayList<Camera> cameraList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM camera_info";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Camera camera = new Camera();
            camera.setCamera_id(result.getString(1).trim());
            cameraList.add(camera);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!cameraList.isEmpty()) {
            return cameraList;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Camera> queryCamera(String camera_id) throws Exception {
        ArrayList<Camera> cameraList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM camera_info where camera_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,camera_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Camera camera = new Camera();
            camera.setCamera_id(result.getString(1).trim());
            cameraList.add(camera);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!cameraList.isEmpty()) {
            return cameraList;
        } else {
            return null;
        }
    }

    @Override
    public boolean insertCamera(Camera camera) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "insert into camera_info values(?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, camera.getCamera_id());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();

        return flag;
    }

    @Override
    public boolean deleteCamera(String camera_id) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "delete from camera_info where camera_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,camera_id);
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();

        return flag;
    }

    @Override
    public boolean updateCamera(Camera camera) throws Exception {
        return false;
    }
}
