package implement;

import dao.StaffDao;
import model.Record;
import model.Staff;
import utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StaffDaoImpl extends BaseDao implements StaffDao {
    /**
     * 查询所有员工数据
     * @return 员工数据数组
     * @throws Exception
     */
    @Override
    public ArrayList<Staff> getAllStaff() throws Exception {
        ArrayList<Staff> staffList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM staff";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Staff staff = new Staff();
            staff.setStaffId(result.getString(1));
            staff.setFullName(result.getString(2));
            staff.setAvgScore(result.getString(3));
            staff.setOrderSum(result.getString(4));
            staff.setStationId(result.getString(5));
            staff.setIsAble(result.getString(6));

            staffList.add(staff);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!staffList.isEmpty()) {
            return staffList;
        } else {
            return null;
        }
    }
}
