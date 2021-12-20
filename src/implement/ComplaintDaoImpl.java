package implement;

import dao.ComplaintDao;
import model.Complaint;
import utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ComplaintDaoImpl extends DataBaseConnection implements ComplaintDao {
    /**
     * 返回投诉指定站点员工数据
     * @param stationId
     * @return 投诉指定站点员工数据列表
     * @throws Exception
     */
    @Override
    public ArrayList<Complaint> getComplaintListByStationId(String stationId) throws Exception {
        ArrayList<Complaint> complaints = new ArrayList<>();
        Connection conn = DataBaseConnection.getConnection();
        String sql = "select complaint.* from complaint,staff where complaint.staffId=staff.staffId and staff.stationId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,stationId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            Complaint complaint = new Complaint();
            complaint.setOrderId(result.getString(1).trim());
            complaint.setSubmitTime(result.getString(2).trim());
            complaint.setStaffId(result.getString(3).trim());
            complaint.setComplaintDescribe(result.getString(4).trim());
            complaint.setResult(result.getString(5).trim());

            complaints.add(complaint);
        }
        DataBaseConnection.closeAll(conn, pstmt, result);
        if (!complaints.isEmpty()) {
            return complaints;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 修改人工审批意见
     * @param complaint
     * @return 修改是否成功
     * @throws Exception
     */
    @Override
    public Boolean examineComplaint(Complaint complaint) throws Exception {
        Connection conn = DataBaseConnection.getConnection();
        String sql = "update complaint set result=? where orderId=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, complaint.getResult());
        pstmt.setString(2, complaint.getOrderId());
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }
}
