package dao;

import model.Site;
import model.User;

import java.util.ArrayList;

public interface LoginDao {

    /* 验证登陆者身份 */
    User verifyStatus(String number, String password) throws Exception;

}
