package dao;

import model.AdminLog;

public interface LoginDao {

    /**
     * 登录验证
     *
     * @param userName
     * @return
     * @throws Exception
     */
    AdminLog getAdminLogByUserName(String userName) throws Exception;
}
