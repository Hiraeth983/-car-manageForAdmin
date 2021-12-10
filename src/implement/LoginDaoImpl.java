package implement;

import dao.LoginDao;
import model.AdminLog;
import utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl extends BaseDao implements LoginDao {

    /**
     * 登录验证
     *
     * @param userName
     * @return
     * @throws Exception
     */
    @Override
    public AdminLog getAdminLogByUserName(String userName) throws Exception {
        AdminLog adminLog = null;
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM adminLog where userName=?";
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
}
