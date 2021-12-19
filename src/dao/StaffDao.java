package dao;

import model.Staff;

import java.util.ArrayList;

public interface StaffDao {
    /**
     * 查询所有员工数据
     *
     * @return 员工数据数组
     * @throws Exception
     */
    ArrayList<Staff> getStaffList() throws Exception;

    /**
     * 查询对应检测站员工姓名
     *
     * @param stationId
     * @return 指定检测站员工姓名列表
     * @throws Exception
     */
    ArrayList<Staff> getStaffListByStationId(String stationId) throws Exception;

    /**
     * 插入新员工数据
     *
     * @param staff
     * @return 返回插入是否成功
     * @throws Exception
     */
    Boolean insertStaff(Staff staff) throws Exception;

    /**
     * 查询某一员工数据
     *
     * @param staffId
     * @return 返回指定编号员工数据
     * @throws Exception
     */
    Staff getStaffByStaffId(String staffId,String stationId) throws Exception;

    /**
     * 删除指定编号员工数据
     *
     * @param staffId
     * @return 删除是否成功
     * @throws Exception
     */
    Boolean deleteStaffByStaffId(String staffId) throws Exception;

    /**
     * 修改指定编号员工数据
     *
     * @param staff
     * @return 修改是否成功
     * @throws Exception
     */
    Boolean updateStaff(Staff staff) throws Exception;
}
