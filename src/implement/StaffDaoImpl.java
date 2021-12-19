package implement;

import dao.StaffDao;
import model.Staff;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StaffDaoImpl extends DataBaseConnection implements StaffDao {
    /**
     * 查询所有员工数据
     *
     * @return 员工数据数组
     * @throws Exception
     */
    @Override
    public ArrayList<Staff> getStaffList() throws Exception {
        ArrayList<Staff> staffList = new ArrayList<>();
        Connection conn = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM staff";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Staff staff = new Staff();
            staff.setStaffId(result.getString(1));
            staff.setPassword(result.getString(2));
            staff.setFullName(result.getString(3));
            staff.setAvgScore(result.getDouble(4));
            staff.setOrderSum(result.getInt(5));
            staff.setStationId(result.getString(6));
            staff.setIsAble(result.getInt(7));

            staffList.add(staff);
        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        if (!staffList.isEmpty()) {
            return staffList;
        } else {
            return null;
        }
    }

    /**
     * 查询对应检测站员工姓名
     *
     * @param stationId
     * @return 指定检测站员工姓名列表
     * @throws Exception
     */
    @Override
    public ArrayList<Staff> getStaffListByStationId(String stationId) throws Exception {
        ArrayList<Staff> staffList = new ArrayList<>();
        Connection conn = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM staff where stationId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stationId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Staff staff = new Staff();
            staff.setStaffId(result.getString(1));
            staff.setPassword(result.getString(2));
            staff.setFullName(result.getString(3));
            staff.setAvgScore(result.getDouble(4));
            staff.setOrderSum(result.getInt(5));
            staff.setStationId(result.getString(6));
            staff.setIsAble(result.getInt(7));

            staffList.add(staff);
        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        if (!staffList.isEmpty()) {
            return staffList;
        } else {
            return null;
        }
    }

    /**
     * 插入新员工数据
     *
     * @param staff
     * @return 返回插入是否成功
     * @throws Exception
     */
    @Override
    public Boolean insertStaff(Staff staff) throws Exception {
        Connection conn = DataBaseConnection.getConnection();

        // 获取最大编号，自动加一生成最新编号
        int staffId = 0;
        String sql = "select staffId from staff order by staffId desc limit 1";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            String temp = result.getString(1);
            staffId = Integer.parseInt(temp) + 1;
        }

        sql = "insert into staff values(?,?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, staffId + "");
        pstmt.setString(2, staff.getPassword());
        pstmt.setString(3, staff.getFullName());
        pstmt.setDouble(4, staff.getAvgScore());
        pstmt.setInt(5, staff.getOrderSum());
        pstmt.setString(6, staff.getStationId());
        pstmt.setInt(7, staff.getIsAble());


        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    /**
     * 查询某一检测站数据
     *
     * @param staffId
     * @return
     * @throws Exception
     */
    @Override
    public Staff getStaffByStaffId(String staffId,String stationId) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "SELECT * FROM staff where staffId=? and stationId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, staffId);
        pstmt.setString(2, stationId);
        ResultSet result = pstmt.executeQuery();
        Staff staff = null;
        while (result.next()) {
            staff = new Staff();
            staff.setStaffId(result.getString(1));
            staff.setPassword(result.getString(2));
            staff.setFullName(result.getString(3));
            staff.setAvgScore(result.getDouble(4));
            staff.setOrderSum(result.getInt(5));
            staff.setStationId(result.getString(6));
            staff.setIsAble(result.getInt(7));
        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        return staff;
    }

    /**
     * 删除指定编号员工数据
     *
     * @param staffId
     * @return 删除是否成功
     * @throws Exception
     */
    @Override
    public Boolean deleteStaffByStaffId(String staffId) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "delete from staff where staffId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, staffId);

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    @Override
    public Boolean updateStaff(Staff staff) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "update staff set password=?,isAble=? where staffId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, staff.getPassword());
        pstmt.setInt(2, staff.getIsAble());
        pstmt.setString(3, staff.getStaffId());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }
}
