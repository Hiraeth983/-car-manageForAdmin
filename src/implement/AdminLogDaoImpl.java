package implement;

import dao.AdminLogDao;
import model.AdminLog;
import utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AdminLogDaoImpl extends BaseDao implements AdminLogDao {

    /**
     * 登录验证
     *
     * @param userName
     * @return 当前用户名所属用户数据
     * @throws Exception
     */
    @Override
    public AdminLog getAdminLogByUserName(String userName) throws Exception {
        AdminLog adminLog = null;
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM adminlog where binary userName=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userName);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            adminLog = new AdminLog();
            adminLog.setUserName(result.getString(1).trim());
            adminLog.setPassword(result.getString(2));
            adminLog.setStationId(result.getString(3));
        }
        BaseDao.closeAll(conn, pstmt, result);
        return adminLog;
    }

    /**
     * 验证用户名唯一性
     *
     * @param userName
     * @return 用户名是否唯一
     * @throws Exception
     */
    @Override
    public boolean searchUserName(String userName) throws Exception {
        boolean flag = false;
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT count(*) FROM adminlog where binary userName=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userName);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            flag = Integer.parseInt(result.getString(1)) > 0;
        }
        BaseDao.closeAll(conn, pstmt, result);
        return flag;
    }

    /**
     * 查询所有站长数据
     *
     * @return 站长数据数组
     * @throws Exception
     */
    @Override
    public ArrayList<AdminLog> getAdminLogList() throws Exception {
        ArrayList<AdminLog> adminLogArrayList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM adminlog";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            AdminLog adminLog = new AdminLog();
            adminLog.setUserName(result.getString(1).trim());
            adminLog.setPassword(result.getString(2).trim());
            adminLog.setStationId(result.getString(3).trim());

            adminLogArrayList.add(adminLog);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!adminLogArrayList.isEmpty()) {
            return adminLogArrayList;
        } else {
            return null;
        }
    }

    /**
     * 查询某一检测站站长数据
     *
     * @param stationId
     * @return 指定编号检测站站长数据
     * @throws Exception
     */
    @Override
    public ArrayList<AdminLog> getAdminLogByStationId(String stationId) throws Exception {
        ArrayList<AdminLog> adminLogArrayList = new ArrayList<>();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM adminlog where stationId=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, stationId);
        ResultSet result = pstmt.executeQuery();
        while (result.next()) {
            AdminLog adminLog = new AdminLog();
            adminLog.setUserName(result.getString(1).trim());
            adminLog.setPassword(result.getString(2).trim());
            adminLog.setStationId(result.getString(3).trim());

            adminLogArrayList.add(adminLog);
        }
        BaseDao.closeAll(conn, pstmt, result);
        if (!adminLogArrayList.isEmpty()) {
            return adminLogArrayList;
        } else {
            return null;
        }
    }

    /**
     * 插入一检测站数据
     *
     * @param adminLog
     * @return 插入 AdminLog 信息是否成功
     * @throws Exception
     */
    @Override
    public Boolean insertAdminLog(AdminLog adminLog) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "insert into adminlog values(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, adminLog.getUserName());
        pstmt.setString(2, adminLog.getPassword());
        pstmt.setString(3, adminLog.getStationId());
        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    /**
     * 删除指定用户名数据
     *
     * @param userName
     * @return 删除是否成功
     * @throws Exception
     */
    @Override
    public Boolean deleteAdminLogByUserName(String userName) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "delete from adminlog where binary userName=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, userName);

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }

    /**
     * 修改指定用户名的用户数据
     * @param adminLog
     * @return 修改是否成功
     * @throws Exception
     */
    @Override
    public Boolean updateAdminLogByUserName(AdminLog adminLog) throws Exception {
        Connection conn = BaseDao.getConnection();
        String sql = "update adminlog set password=?,stationId=? where userName=?;";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, adminLog.getPassword());
        pstmt.setString(2, adminLog.getStationId());
        pstmt.setString(3, adminLog.getUserName());

        boolean flag = pstmt.executeUpdate() > 0;
        conn.close();
        pstmt.close();
        return flag;
    }
}
