package implement;

import dao.BaseDao;
import dao.LoginDao;
import model.Site;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginDaoImpl extends BaseDao implements LoginDao {

    /* 获取登陆者身份 */
    @Override
    public User verifyStatus(String number, String password) throws Exception {

        ArrayList<User> userList = new ArrayList<>();
        User user = new User();
        Connection conn = BaseDao.getConnection();
        String sql = "SELECT * FROM user where user_id=? and user_password=? limit 1";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, number);
        pstmt.setString(2, password);
        ResultSet result = pstmt.executeQuery();

        while (result.next()) {
            user.setId(result.getString(1));
            user.setStatus(result.getString(2));
            user.setPassword(result.getString(3));
            userList.add(user);
        }

        BaseDao.closeAll(conn, pstmt, result);
        if (!userList.isEmpty()) {
            return user;
        } else {
            return null;
        }
    }

}
