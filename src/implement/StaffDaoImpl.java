package implement;

import dao.StaffDao;
import model.Staff;
import utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StaffDaoImpl extends BaseDao implements StaffDao {
    /**
     * 查询所有员工数据
     *
     * @return 员工数据数组
     * @throws Exception
     */
    @Override
    public ArrayList<Staff> getStaffList() throws Exception {
        ArrayList<Staff> staffList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
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
        BaseDao.closeAll(conn, pstmt, result);
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
    public ArrayList<String> getStaffNameByStationId(String stationId) throws Exception {
        ArrayList<String> staffNameList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT fullName FROM staff where stationId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stationId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            staffNameList.add(result.getString(1));
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!staffNameList.isEmpty()) {
            return staffNameList;
        } else {
            return null;
        }
    }
}
