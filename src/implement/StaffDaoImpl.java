package implement;

import dao.BaseDao;
import dao.StaffDao;
import model.Staff;
import model.StaffChart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StaffDaoImpl extends BaseDao implements StaffDao {
    @Override
    public ArrayList<String> allStaffInfo(String detection_id) throws Exception {
        ArrayList<String> staffList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT staff_name FROM staff_info where Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,detection_id);
        ResultSet result = pstmt.executeQuery();

        while(result.next()){
            staffList.add(result.getString(1));
        }

        BaseDao.closeAll(conn, pstmt, result);
        if (!staffList.isEmpty()) {
            return staffList;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Staff> allStaffQuery(String detection_id) throws Exception {
        ArrayList<Staff> staffList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM staff_info where Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,detection_id);
        ResultSet result = pstmt.executeQuery();

        while(result.next()){
            Staff staff = new Staff();
            staff.setStaff_id(result.getString(1).trim());
            staff.setStaff_name(result.getString(2).trim());
            staff.setDetection_id(result.getString(3).trim());
            staff.setCredit_score(result.getInt(4));
            staff.setIllegal_number(result.getInt(5));

            staffList.add(staff);
        }

        BaseDao.closeAll(conn, pstmt, result);
        if (!staffList.isEmpty()) {
            return staffList;
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Staff> allStaffQuery(String detection_id,String staff_id) throws Exception {
        ArrayList<Staff> staffList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM staff_info where Detection_id=? and staff_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,detection_id);
        pstmt.setString(2,staff_id);
        ResultSet result = pstmt.executeQuery();

        while(result.next()){
            Staff staff = new Staff();
            staff.setStaff_id(result.getString(1).trim());
            staff.setStaff_name(result.getString(2).trim());
            staff.setDetection_id(result.getString(3).trim());
            staff.setCredit_score(result.getInt(4));
            staff.setIllegal_number(result.getInt(5));

            staffList.add(staff);
        }

        BaseDao.closeAll(conn, pstmt, result);
        if (!staffList.isEmpty()) {
            return staffList;
        } else {
            return null;
        }
    }

    @Override
    public boolean updateStaff(Staff staff) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "update staff_info set staff_name=?,Credit_score=?,illegal_number=? where staff_id=? and Detection_id=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, staff.getStaff_name());
        pstmt.setInt(2, staff.getCredit_score());
        pstmt.setInt(3, staff.getIllegal_number());
        pstmt.setString(4, staff.getStaff_id());
        pstmt.setString(5, staff.getDetection_id());
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    @Override
    public boolean deleteStaff(String detection_id, String staff_id) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "delete from staff_info where staff_id=? and Detection_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,staff_id);
        pstmt.setString(2, detection_id);
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();

        return flag;
    }

    @Override
    public boolean insertStaff(Staff staff) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "insert into staff_info values(?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, staff.getStaff_id());
        pstmt.setString(2, staff.getStaff_name());
        pstmt.setString(3, staff.getDetection_id());
        pstmt.setInt(4, staff.getCredit_score());
        pstmt.setInt(5, staff.getIllegal_number());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();

        return flag;
    }

    @Override
    public ArrayList<StaffChart> staffChart(String detection_id) throws Exception {
        Connection conn = BaseDao.getConnection();
        ArrayList<StaffChart> chartArrayList = new ArrayList<>();
        String sql = "select staff_info.staff_id,staff_name,count(test_result.id) from staff_info,error_info,test_result where error_info.staff_id = staff_info.staff_name and test_result.Detection_id=? and test_result.Detection_id = staff_info.Detection_id and test_result.id = error_info.id GROUP BY staff_info.staff_id ORDER BY staff_info.staff_id;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,detection_id);
        ResultSet result = pstmt.executeQuery();

        while(result.next()){
            StaffChart staff = new StaffChart();
            staff.setStaff_id(result.getString(1).trim());
            staff.setStaff_name(result.getString(2).trim());
            staff.setNumber(result.getInt(3));

            chartArrayList.add(staff);
        }

        BaseDao.closeAll(conn, pstmt, result);
        if (!chartArrayList.isEmpty()) {
            return chartArrayList;
        } else {
            return null;
        }
    }
}
