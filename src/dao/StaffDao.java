package dao;

import model.Staff;

import java.util.ArrayList;

public interface StaffDao {
    /**
     * 查询所有员工数据
     * @return 员工数据数组
     * @throws Exception
     */
    ArrayList<Staff> getAllStaff() throws Exception;
}
