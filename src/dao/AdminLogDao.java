package dao;

import model.AdminLog;

import java.util.ArrayList;

public interface AdminLogDao {

    /**
     * 登录验证
     *
     * @param userName
     * @return 当前用户名用户数据
     * @throws Exception
     */
    AdminLog getAdminLogByUserName(String userName) throws Exception;

    /**
     * 验证用户名唯一性
     *
     * @param userName
     * @return 用户名是否唯一
     * @throws Exception
     */
    boolean searchUserName(String userName) throws Exception;

    /**
     * 查询所有站长数据
     *
     * @return 站长数据数组
     * @throws Exception
     */
    ArrayList<AdminLog> getAdminLogList() throws Exception;

    /**
     * 查询某一检测站站长数据
     *
     * @param stationId
     * @return 指定编号检测站站长数据
     * @throws Exception
     */
    ArrayList<AdminLog> getAdminLogByStationId(String stationId) throws Exception;

    /**
     * 插入一检测站数据
     *
     * @param adminLog
     * @return 插入 AdminLog 信息是否成功
     * @throws Exception
     */
    Boolean insertAdminLog(AdminLog adminLog) throws Exception;

    /**
     * 删除指定用户名数据
     *
     * @param userName
     * @return 删除是否成功
     * @throws Exception
     */
    Boolean deleteAdminLogByUserName(String userName) throws Exception;

    /**
     * 修改指定用户名的用户数据
     * @param adminLog
     * @return 修改是否成功
     * @throws Exception
     */
    Boolean updateAdminLogByUserName(AdminLog adminLog) throws Exception;
}
