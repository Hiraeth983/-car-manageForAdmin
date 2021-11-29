package dao;

import model.Staff;
import model.StaffChart;

import java.util.ArrayList;

public interface StaffDao {
    /* 查询当前检测站所有员工 */
    ArrayList<String> allStaffInfo(String staff_id) throws Exception;

    /* 查询所有检测站数据 */
    ArrayList<Staff> allStaffQuery(String detection_id) throws Exception;

    /* 查询某一检测站数据 */
    ArrayList<Staff> allStaffQuery(String detection_id,String staff_id) throws Exception;

    /* 修改某一检测站数据 */
    boolean updateStaff(Staff staff) throws Exception;

    /* 删除某一检测站数据 */
    boolean deleteStaff(String detection_id, String staff_id) throws Exception;

    /* 插入数据 */
    boolean insertStaff(Staff staff) throws Exception;

    /* 查询员工及对应异常处置数 */
    ArrayList<StaffChart> staffChart(String detection_id) throws Exception;
}
