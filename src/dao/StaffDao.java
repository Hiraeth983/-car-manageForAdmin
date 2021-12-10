package dao;

import model.Staff;

import java.util.ArrayList;

public interface StaffDao {
    /**
     * 查询所有员工数据
     * @return 员工数据数组
     * @throws Exception
     */
    ArrayList<Staff> getStaffList() throws Exception;

    /**
     * 查询对应检测站员工姓名
     * @param stationId
     * @return 指定检测站员工姓名列表
     * @throws Exception
     */
    ArrayList<String> getStaffNameByStationId(String stationId) throws Exception;
}
