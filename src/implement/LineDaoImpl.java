package implement;

import dao.BaseDao;
import dao.LineDao;
import model.Line;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LineDaoImpl extends BaseDao implements LineDao {

    /* 查询当前检测站所有检测线 */
    @Override
    public ArrayList<String> allLineInfo(String detection_id) throws Exception {
        ArrayList<String> lineList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT test_line FROM line where Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        ResultSet result = pstmt.executeQuery();

        while (result.next()) {
            lineList.add(result.getString(1));
        }

        BaseDao.closeAll(conn, pstmt, result);
        if (!lineList.isEmpty()) {
            return lineList;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Line> queryLine(String detection_id) throws Exception {
        ArrayList<Line> lineList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM line where Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, detection_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Line line = new Line();
            line.setDetection_id(result.getString(1).trim());
            line.setTest_line(result.getString(2).trim());
            line.setLine_name(result.getString(3));
            lineList.add(line);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!lineList.isEmpty()) {
            return lineList;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Line> queryLine(String detection_id, String test_line) throws Exception {
        ArrayList<Line> lineList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM line where test_line=? and Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, test_line);
        pstmt.setString(2, detection_id);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Line line = new Line();
            line.setDetection_id(result.getString(1).trim());
            line.setTest_line(result.getString(2).trim());
            line.setLine_name(result.getString(3));
            lineList.add(line);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!lineList.isEmpty()) {
            return lineList;
        } else {
            return null;
        }
    }

    @Override
    public boolean insertLine(Line line) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "insert into line values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, line.getDetection_id());
        pstmt.setString(2, line.getTest_line());
        pstmt.setString(3, line.getLine_name());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();

        return flag;
    }

    @Override
    public boolean deleteLine(String detection_id, String test_line) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "delete from line where test_line=? and Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, test_line);
        pstmt.setString(2, detection_id);
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();

        return flag;
    }

    @Override
    public boolean updateLine(Line line) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "update line set line_name=? where test_line=? and Detection_id=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(3, line.getDetection_id());
        pstmt.setString(2, line.getTest_line());
        pstmt.setString(1, line.getLine_name());
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }
}
